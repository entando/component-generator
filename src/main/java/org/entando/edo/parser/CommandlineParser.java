/*
 * Copyright 2015-Present Entando Inc. (http://www.entando.com) All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package org.entando.edo.parser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.entando.edo.model.EdoBuilder;
import org.entando.edo.model.json.EdoInput;


public class CommandlineParser {

    private static Logger _logger = LogManager.getLogger(CommandlineParser.class);

    private static Validator validator;

    public EdoBuilder generate(String[] args) throws Throwable {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        EdoBuilder edoBuilder = null;
        try {
            if (null != args) {
                ArrayList<String> rawArgs = new ArrayList<String>();
                for (String s : args) {
                    if (StringUtils.isNotBlank(s)) {
                        rawArgs.add(s);
                    }
                }
                args = rawArgs.toArray(new String[rawArgs.size()]);
            }
            String originalArgs = Arrays.toString(args);

            /////////
            CommandLineParser commandlineparser = new GnuParser();
            Options options = createCommandLineOptions();
            CommandLine cl = null;
            cl = commandlineparser.parse(options, args);
            if ((null != cl) && cl.hasOption("help") || null == args || args.length < 1) {
                outputCommandLineHelp(options);
                return null;
            }

            EdoInput edoInput = this.processCommandline(cl, args);

            edoBuilder = edoInput.buildEdoBuilder();
            edoBuilder.setOriginalArgs(originalArgs);

            if (this.checkForPom) {
                _logger.trace("check for pom.xml");
                boolean pomExists = new File(edoBuilder.getBaseDir(), "pom.xml").exists();
                if (!pomExists) {
                    _logger.error("no pom.xml found in dir:'{}'. skip", edoBuilder.getBaseDir());
                    return null;
                }
                _logger.trace("found {}.pom.xml", edoBuilder.getBaseDir());
            }


        } catch (ParseException exp) {
            _logger.error("Error parsing command line", exp);
        } catch (Throwable t) {
            _logger.error("Error parsing command line");
            throw t;
        }
        return edoBuilder;
    }


    private static Options createCommandLineOptions() {
        final Options options = new Options();
        options.addOption(OPTION_EDO_FILE_SHORT, OPTION_EDO_FILE, true, "the edo model descriptor");
        options.addOption(OPTION_EDO_FILE_OUTPUT_ZIP_SHORT, OPTION_EDO_FILE_OUTPUT_ZIP, true, "path to the directory where to save the assets");
        return options;
    }

    private static void outputCommandLineHelp(final Options options) {
        final HelpFormatter formater = new HelpFormatter();
        formater.printHelp("edo [options] [ARGS]", options);
    }



    private EdoInput processCommandline(CommandLine cl, String[] args) {
        EdoInput edoInput = processFile(cl);
        this.processZipOut(edoInput, cl);

        Set<ConstraintViolation<EdoInput>> violations = validator.validate(edoInput);
        if (violations.size() > 0) {
            for (ConstraintViolation<EdoInput> v : violations) {
                _logger.error(v.getMessage());
            }
            throw new EdoInputException("validation errors");
        }
        return edoInput;
    }

    protected EdoInput processFile(CommandLine cl) {
        try {
            if (cl.hasOption(OPTION_EDO_FILE)) {
                String filePath = cl.getOptionValue(OPTION_EDO_FILE);
                if (StringUtils.isBlank(filePath)) {
                    _logger.error("invalid path specifed");
                    throw new IllegalArgumentException("invalid path specifed");
                }

                ObjectMapper mapper = new ObjectMapper();
                Path path = Paths.get(filePath);
                EdoInput input = mapper.readValue(new File(path.toUri()), EdoInput.class);
                return input;
            } else {
                _logger.error("no input file specified");
                throw new EdoInputException("no input file specified");
            }
        } catch (IOException e) {
            _logger.error("error parsing input file", e);
            throw new EdoInputException("error parsing input file", e);
        }
    }

    protected void processZipOut(EdoInput edoInput, CommandLine cl) {
        try {
            if (cl.hasOption(OPTION_EDO_FILE_OUTPUT_ZIP)) {
                String filePath = cl.getOptionValue(OPTION_EDO_FILE_OUTPUT_ZIP);
                if (StringUtils.isBlank(filePath)) {
                    _logger.error("invalid path specifed");
                    throw new IllegalArgumentException("invalid path specifed");
                }

                File x = new File(filePath);

                if (!x.exists()) {
                    FileUtils.forceMkdir(x);
                }

                if (x.isDirectory()) {
                    if (!x.canWrite()) {
                        throw new EdoInputException("the folder cannot be written");
                    }
                } else {
                    if (!x.getParentFile().canWrite()) {
                        throw new EdoInputException("the folder cannot be written");
                    }
                }

                edoInput.setZipDir(filePath);
                this.checkForPom = false;
            }

        } catch (IOException e) {
            _logger.error("error parsing out file", e);
            throw new EdoInputException("error parsing out file", e);
        }
    }

    protected void setCheckForPom(boolean checkForPom) {
        this.checkForPom = checkForPom;
    }

    private boolean checkForPom = true;

    public static final String OPTION_EDO_FILE_SHORT = "f";
    public static final String OPTION_EDO_FILE = "file";

    public static final String OPTION_EDO_FILE_OUTPUT_ZIP_SHORT = "z";
    public static final String OPTION_EDO_FILE_OUTPUT_ZIP = "zip";
}
