/*
 * Copyright 2013-Present Entando Corporation (http://www.entando.com) All rights reserved.
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
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.entando.edo.model.EdoBean;
import org.entando.edo.model.EdoBuilder;


public class CommandlineParser {

	private static Logger _logger = LogManager.getLogger(CommandlineParser.class);

	public EdoBuilder generate(String[] args) throws Throwable {
		EdoBuilder edoBuilder = null;
		try {
			if (null != args) {
				ArrayList<String> rawArgs = new ArrayList<String>();
				for(String s : args) {
					if(StringUtils.isNotBlank(s)) {
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
			edoBuilder = new EdoBuilder();
			edoBuilder.setOriginalArgs(originalArgs);
			if (null != cl) {
				args = processCommandline(cl, edoBuilder, args);
			}
			if (StringUtils.isBlank(edoBuilder.getPackageName())) {
				_logger.warn("No package name!, skip");
				return null;
			}
			/////////

			if (this.checkForPom) {	
				_logger.trace("check for pom.xml");
				boolean pomExists = new File(edoBuilder.getBaseDir(), "pom.xml").exists();
				if (!pomExists) {
					_logger.error("no pom.xml found in dir:'{}'. skip", edoBuilder.getBaseDir());
					return null;
				}
				_logger.trace("found {}.pom.xml", edoBuilder.getBaseDir());
			}


			EdoBean edoBean = new EdoBean();
			IAgrumentParser parser = new NameParser();
			String a[] = parser.parse(edoBean, args);

			parser = new FieldsParser();
			a = parser.parse(edoBean, a);
			if (a.length > 0) {
				_logger.warn("These parameters were skipped: " + Arrays.toString(a));
			}
			edoBuilder.addBean(edoBean);

		} catch (ParseException exp) {
			_logger.error("Error parsing command line", exp);
		} catch (Throwable t) {
			_logger.error("Error parsing command line", t);
			throw t;
		}
		return edoBuilder;
	}




	private static Options createCommandLineOptions() {
		final Options options = new Options();
		options.addOption(OPTION_BASE_DIR, OPTION_BASE_DIR, true, "full path of edo work directory. Should be the root of an Entando project. By default is the current directory");
		options.addOption(OPTION_PERMISSION, OPTION_PERMISSION, true, "code of the Entando permission used to protect actions. Default is 'superuser'");
		options.addOption(OPTION_PACKAGE, OPTION_PACKAGE, true, "fully qualified package name, for example: com.mycompany");
		return options;
	}

	private static void outputCommandLineHelp(final Options options) {
		final HelpFormatter formater = new HelpFormatter();
		formater.printHelp("edo [options] [ARGS]", options);
	}


	/**
	 * Setta le opzioni e pulisce args!
	 * @param cl
	 * @param edoBean
	 * @param args
	 * @return
	 * @throws IllegalArgumentException
	 */
	private String[] processCommandline(CommandLine cl, EdoBuilder edoBuilder, String[] args) throws IllegalArgumentException {
		if (cl.hasOption(OPTION_BASE_DIR)) {
			String baseDir = cl.getOptionValue(OPTION_BASE_DIR);
			if (StringUtils.isNotBlank(baseDir)) {
				if (baseDir.endsWith(File.separator)) {
					baseDir = StringUtils.removeEnd(baseDir, File.separator);
				}
				edoBuilder.setBaseDir(baseDir);
			}
		}
		_logger.debug("baseDir is: '{}'", edoBuilder.getBaseDir());

		if (cl.hasOption(OPTION_PERMISSION)) {
			String perm = cl.getOptionValue(OPTION_PERMISSION);
			if (StringUtils.isNotBlank(perm)) {
				edoBuilder.setPermission(perm);
			}
		}
		_logger.debug("permission is: '{}'", edoBuilder.getPermission());

		String packageName = null;
		if (cl.hasOption(OPTION_PACKAGE)) {
			String packageNameParam = cl.getOptionValue(OPTION_PACKAGE);
			if (StringUtils.isNotBlank(packageNameParam)) {
				if (PackageValidator.isValidPackageName(packageNameParam)) {					
					packageName = packageNameParam;
				} else {
					_logger.error("invalid package name specified: {}", packageName);
					throw new IllegalArgumentException("invalid package name specified: " + packageName);
				}
			}
		} else {
			_logger.trace("auto generate packagename");
			if (!cl.getArgList().isEmpty()) {
				packageName = "org.entando.entando.plugins.jp" + cl.getArgs()[0].toLowerCase();
			} else {
				_logger.warn("Unable to generate the default package name. No enough args");
			}
		}



		edoBuilder.setPackageName(packageName);
		_logger.debug("packagename: is '{}'", edoBuilder.getPackageName());

		args = Arrays.copyOfRange(args, cl.getOptions().length, args.length);
		return args;
	}


	protected void setCheckForPom(boolean checkForPom) {
		this.checkForPom = checkForPom;
	}

	private boolean checkForPom = true;

	public static final String OPTION_BASE_DIR = "baseDir";
	public static final String OPTION_PERMISSION = "permission";
	public static final String OPTION_PACKAGE = "package";
}
