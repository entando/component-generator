/*
 *
 * Copyright 2013 Entando S.r.l. (http://www.entando.com) All rights reserved.
 *
 * This file is part of Entando Enterprise Edition software.
 * You can redistribute it and/or modify it
 * under the terms of the Entando's EULA
 * 
 * See the file License for the specific language governing permissions   
 * and limitations under the License
 * 
 * 
 * 
 * Copyright 2013 Entando S.r.l. (http://www.entando.com) All rights reserved.
 *
 */
package org.entando.edo.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang.ArrayUtils;
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
			 new HashMap<String, String>();
			CommandLineParser commandlineparser = new GnuParser();

			Options options = createCommandLineOptions();
			CommandLine cl = null;
			cl = commandlineparser.parse(options, args, true);
			if ((null != cl) && cl.hasOption("help") || null == args || args.length < 1) {
				outputCommandLineHelp(options);
				return null;
			}
			Map<String, String> globalOptions  = processGlobalOptions(cl, args);

			if (this.checkForPom) {	
				String basedir = globalOptions.get(OPTION_BASE_DIR);
				if (StringUtils.isBlank(basedir)) basedir = System.getProperty("user.dir");
				
				_logger.trace("check for pom.xml");
				boolean pomExists = new File(basedir, "pom.xml").exists();
				if (!pomExists) {
					_logger.error("no pom.xml found in dir:'{}'. skip", basedir);
					return null;
				}
				_logger.trace("found {}.pom.xml", basedir);
			}

			List<EdoBean> beans = this.generateBeans(cl.getArgs());
			if (!beans.isEmpty()) {
				edoBuilder = new EdoBuilder(args, globalOptions.get(OPTION_BASE_DIR), globalOptions.get(OPTION_PACKAGE), globalOptions.get(OPTION_PERMISSION), beans);
			} else {
				_logger.error("No bean specified");
			}

		} catch (ParseException exp) {
			_logger.error("Error parsing global command line", exp);
		} catch (Throwable t) {
			_logger.error("Error parsing bean command line", t);
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
	 * Extracts the global options
	 * @param commandline
	 * @param args
	 * @return a map containing the global options
	 * @throws IllegalArgumentException
	 */
	private Map<String, String> processGlobalOptions(CommandLine commandline, String[] args) throws IllegalArgumentException {
		Map<String, String> options = new HashMap<String, String>();
		if (commandline.hasOption(OPTION_BASE_DIR)) {
			String baseDir = commandline.getOptionValue(OPTION_BASE_DIR);
			if (StringUtils.isNotBlank(baseDir)) {
				if (baseDir.endsWith(File.separator)) {
					baseDir = StringUtils.removeEnd(baseDir, File.separator);
				}
				options.put(OPTION_BASE_DIR, baseDir);
			}
		}
		if (commandline.hasOption(OPTION_PERMISSION)) {
			String perm = commandline.getOptionValue(OPTION_PERMISSION);
			if (StringUtils.isNotBlank(perm)) {
				options.put(OPTION_PERMISSION, perm);
			}
		}
		String packageName = null;
		if (commandline.hasOption(OPTION_PACKAGE)) {
			String packageNameParam = commandline.getOptionValue(OPTION_PACKAGE);
			if (StringUtils.isNotBlank(packageNameParam)) {
				if (PackageValidator.isValidPackageName(packageNameParam)) {					
					packageName = packageNameParam;
					options.put(OPTION_PACKAGE, packageName);
				} else {
					_logger.error("invalid package name specified: {}", packageName);
					throw new IllegalArgumentException("invalid package name specified: " + packageName);
				}
			}
		}
		return options;
	}

	protected List<EdoBean> generateBeans(String[] args) throws Throwable {
		List<EdoBean> beans = new ArrayList<EdoBean>();
		try {
			List<String[]> beanExpressions = new ArrayList<String[]>();
			
			this.extractExpressions(beanExpressions, args, "AND");

			for (int i = 0; i < beanExpressions.size(); i++) {
				String[] currentExp = beanExpressions.get(i);
				if (!ArrayUtils.isEmpty(currentExp)) {
					EdoBean edoBean = new EdoBean();
					IAgrumentParser parser = new NameParser();
					String a[] = parser.parse(edoBean, currentExp);
					
					parser = new FieldsParser();
					a = parser.parse(edoBean, a);
					if (a.length > 0) {
						_logger.warn("These parameters were skipped: " + Arrays.toString(a));
					}
					beans.add(edoBean);
					_logger.info("bean {} created", edoBean.getName());
				}
			}

		} catch (Throwable t) {
			_logger.error("Error generating beans");
			throw t;
		}
		return beans;
	}

	protected void extractExpressions(List<String[]> expressions, String[] args, String token) {
		int index = ArrayUtils.indexOf(args, token);
		int start = 0;
		if (index > 0) {
			expressions.add((String[]) ArrayUtils.subarray(args, start, index));
			index = index + 1; // skip token
			extractExpressions(expressions, (String[]) ArrayUtils.subarray(args, index, args.length), token);
		} else {
			expressions.add(args);
		}
	}

	protected void setCheckForPom(boolean checkForPom) {
		this.checkForPom = checkForPom;
	}

	private boolean checkForPom = true;

	public static final String OPTION_BASE_DIR = "baseDir";
	public static final String OPTION_PERMISSION = "permission";
	public static final String OPTION_PACKAGE = "package";

/*
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
			cl = commandlineparser.parse(options, args, true);
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

			this.generateBeans(args, edoBuilder);


		} catch (ParseException exp) {
			_logger.error("Error parsing global command line", exp);
		} catch (Throwable t) {
			_logger.error("Error parsing bean command line", t);
			throw t;
		}
		return edoBuilder;
	}





	private void generateBeans(String[] args, EdoBuilder edoBuilder) throws Throwable {
		try {
			List<String[]> beanExpressions = new ArrayList<String[]>();
			this.extractExpressions(beanExpressions, args, "AND");

			for (int i = 0; i < beanExpressions.size(); i++) {
				String[] currentExp = beanExpressions.get(i);
				EdoBean edoBean = new EdoBean();
				IAgrumentParser parser = new NameParser();
				String a[] = parser.parse(edoBean, currentExp);

				parser = new FieldsParser();
				a = parser.parse(edoBean, a);
				if (a.length > 0) {
					_logger.warn("These parameters were skipped: " + Arrays.toString(a));
				}
				edoBuilder.addBean(edoBean);
			}

		} catch (Throwable t) {
			_logger.error("Error generating beans");
			throw t;
		}
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


	private void extractExpressions(List<String[]> expressions, String[] args, String token) {
		int index = ArrayUtils.indexOf(args, token);
		int start = 0;
		if (index > 0) {
			expressions.add((String[]) ArrayUtils.subarray(args, start, index));
			index = index + 1; // skip token
			extractExpressions(expressions, (String[]) ArrayUtils.subarray(args, index, args.length), token);
		} else {
			expressions.add(args);
		}
	}

	protected void setCheckForPom(boolean checkForPom) {
		this.checkForPom = checkForPom;
	}

	private boolean checkForPom = true;

	public static final String OPTION_BASE_DIR = "baseDir";
	public static final String OPTION_PERMISSION = "permission";
	public static final String OPTION_PACKAGE = "package";
	*/
}
