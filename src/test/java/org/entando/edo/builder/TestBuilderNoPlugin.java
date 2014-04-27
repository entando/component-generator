package org.entando.edo.builder;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.entando.edo.mock.builder.MockBuilder;
import org.entando.edo.mock.parser.MockCommandLineParser;
import org.entando.edo.model.EdoBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestBuilderNoPlugin {

	public static Logger logger = LogManager.getLogger(TestBuilderNoPlugin.class);

	public static final String TEST_BASE_FOLDER = System.getProperty("user.dir") + File.separator + "target" + File.separator + "sandbox/";
	public static final String ACTUAL_BASE_FOLDER = System.getProperty("user.dir") + File.separator + "src/test/outcomes/noplugin_simple_1/";

	public static int testedFiles = 0;
	public static Builder builder = new MockBuilder();

	@BeforeClass
	public static void createArtifacts() throws Throwable {
		logger.info("creating artifacts...");

		MockCommandLineParser commandline = new MockCommandLineParser();
		commandline.setBaseDir(System.getProperty("user.dir") + File.separator + "target" + File.separator + "sandbox");
		commandline.setPackageName("com.myportal");
		commandline.setBeanExpression("Cat name:string-r8 age:int weight:bigdecimal createdat:date");
		EdoBuilder edoBuilder = commandline.generate();
		builder.build(edoBuilder);
		logger.info("start tests");
	}

	@AfterClass
	public static void deleteArtifacts() throws Throwable {
		logger.info("tested files: {}", testedFiles);
		
	}

	@Test
	public void test_Service_Init_Java() throws IOException {
		String commonPath = "src/main/java/com/myportal/aps/system/init".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		List<File> actualFiles = this.searchFiles(actualDir, null);
		Assert.assertEquals(1, actualFiles.size());
		this.compareFiles(actualFiles);
	}


	@Test
	public void test_Service_Init_Xml() throws IOException {

		String commonPath = "src/main/resources/component/sandbox".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		List<File> actualFiles = this.searchFiles(actualDir, null);
		Assert.assertEquals(1, actualFiles.size());
		this.compareFiles(actualFiles);
	}
	@Test
	public void test_Service_Init_Sql() throws IOException {
		String commonPath = "src/main/resources/sql/misc/sandbox".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		List<File> actualFiles = this.searchFiles(actualDir, null);
		Assert.assertEquals(2, actualFiles.size());
		this.compareFiles(actualFiles);
	}

	@Test
	public void test_Service_Java() throws IOException {
		String commonPath = "src/main/java/com/myportal/aps/system/services/cat".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		FileFilter excludeAPIFolder = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if (pathname.isDirectory() && pathname.getName().equals("api")) return false;
				return true;
			}
		};

		List<File> actualFiles = this.searchFiles(actualDir, excludeAPIFolder);
		Assert.assertEquals(7, actualFiles.size());
		this.compareFiles(actualFiles);
	}

	@Test
	public void test_Service_Xml() throws IOException {
		String commonPath = "src/main/resources/spring/sandbox/aps".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		List<File> actualFiles = this.searchFiles(actualDir, null);
		Assert.assertEquals(1, actualFiles.size());
		this.compareFiles(actualFiles);
	}

	@Test
	public void test_Service_Api_Java() throws IOException {
		String commonPath = "src/main/java/com/myportal/aps/system/services/cat/api".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		List<File> actualFiles = this.searchFiles(actualDir, null);
		Assert.assertEquals(5, actualFiles.size());
		this.compareFiles(actualFiles);
	}

	@Test
	public void test_Service_Api_Xml() throws IOException {
		String commonPath = "src/main/resources/api/sandbox".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		List<File> actualFiles = this.searchFiles(actualDir, null);
		Assert.assertEquals(1, actualFiles.size());
		this.compareFiles(actualFiles);
	}


	@Test
	public void test_Controller_Java_Model() throws IOException {
		String commonPath = "src/main/java/com/myportal/apsadmin/cat".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		List<File> actualFiles = this.searchFiles(actualDir, null);
		Assert.assertEquals(8, actualFiles.size());
		this.compareFiles(actualFiles);
	}

	@Test
	public void test_Controller_GlobalMassages() throws IOException {
		String commonPath = "src/main/java/com/myportal/apsadmin".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());
		
		FileFilter excludeSubfolders = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if (pathname.isDirectory() && !pathname.getName().equals("apsadmin")) return false;
				return true;
			}
		};

		List<File> actualFiles = this.searchFiles(actualDir, excludeSubfolders);
		Assert.assertEquals(0, actualFiles.size());
		//this.compareFiles(actualFiles);
	}

	@Test
	public void test_Controller_Spring_Xml() throws IOException {
		String commonPath = "src/main/resources/spring/sandbox/apsadmin".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		List<File> actualFiles = this.searchFiles(actualDir, null);
		Assert.assertEquals(1, actualFiles.size());
		this.compareFiles(actualFiles);
	}

	@Test
	public void test_Controller_Struts_Xml() throws IOException {
		String commonPath = "src/main/resources".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		FileFilter excludeSubfolders = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if (pathname.isDirectory() && !pathname.getName().equals("resources")) return false;
				return true;
			}
		};
		List<File> actualFiles = this.searchFiles(actualDir, excludeSubfolders);
		Assert.assertEquals(1, actualFiles.size());
		this.compareFiles(actualFiles);
	}

	@Test
	public void test_Controller_Shortcuts() throws IOException {
		String commonPath = "src/main/resources/shortcuts/sandbox/apsadmin".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		List<File> actualFiles = this.searchFiles(actualDir, null);
		Assert.assertEquals(1, actualFiles.size());
		this.compareFiles(actualFiles);
	}

	@Test
	public void test_Controller_Tiles() throws IOException {
		String commonPath = "src/main/webapp/WEB-INF/sandbox/apsadmin".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		FileFilter excludeSubfolders = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if (pathname.isDirectory() && !pathname.getName().equals("apsadmin")) return false;
				return true;
			}
		};

		List<File> actualFiles = this.searchFiles(actualDir, excludeSubfolders);
		Assert.assertEquals(1, actualFiles.size());
		this.compareFiles(actualFiles);
	}

	@Test
	public void test_Controller_Jsp_Model() throws IOException {
		String commonPath = "src/main/webapp/WEB-INF/sandbox/apsadmin/jsp/cat".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		List<File> actualFiles = this.searchFiles(actualDir, null);
		Assert.assertEquals(3, actualFiles.size());
		this.compareFiles(actualFiles);

		//----

		commonPath = "src/main/webapp/WEB-INF/sandbox/apsadmin/jsp/common/layouts".replaceAll("/", Matcher.quoteReplacement(File.separator));

		actualPath = ACTUAL_BASE_FOLDER + commonPath;

		actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		FileFilter excludeSubfolders = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if (pathname.isDirectory() && !pathname.getName().equals("layouts")) return false;
				return true;
			}
		};

		actualFiles = this.searchFiles(actualDir, excludeSubfolders);
		Assert.assertEquals(0, actualFiles.size()); //no submenu
		//this.compareFiles(actualFiles);
	}

	@Test
	public void test_Controller_Jsp_Model_Assets() throws IOException {
		String commonPath = "src/main/webapp/WEB-INF/sandbox/apsadmin/jsp/common/layouts/assets-more".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;
	
		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		List<File> actualFiles = this.searchFiles(actualDir, null);
		Assert.assertEquals(3, actualFiles.size());
		this.compareFiles(actualFiles);
	}


	@Test
	public void test_Controller_Java_Widget() throws IOException {
		String commonPath = "src/main/java/com/myportal/apsadmin/portal".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		List<File> actualFiles = this.searchFiles(actualDir, null);
		Assert.assertEquals(4, actualFiles.size());
		this.compareFiles(actualFiles);
	}

	@Test
	public void test_Controller_Jsp_Widget() throws IOException {
		String commonPath = "src/main/webapp/WEB-INF/sandbox/apsadmin/jsp/portal".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		List<File> actualFiles = this.searchFiles(actualDir, null);
		Assert.assertEquals(1, actualFiles.size());
		this.compareFiles(actualFiles);
	}

	@Test
	public void test_Widget_Jsp() throws IOException {
		String commonPath = "src/main/webapp/WEB-INF/aps/jsp/widgets".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		List<File> actualFiles = this.searchFiles(actualDir, null);
		Assert.assertEquals(1, actualFiles.size());
		this.compareFiles(actualFiles);
	}

	@Test
	public void test_Widget_Tags() throws IOException {
		String commonPath = "src/main/java/com/myportal/aps/tags".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		List<File> actualFiles = this.searchFiles(actualDir, null);
		Assert.assertEquals(2, actualFiles.size());
		this.compareFiles(actualFiles);

		//------
		commonPath = "src/main/tld/sandbox".replaceAll("/", Matcher.quoteReplacement(File.separator));

		actualPath = ACTUAL_BASE_FOLDER + commonPath;

		actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		actualFiles = this.searchFiles(actualDir, null);
		Assert.assertEquals(1, actualFiles.size());
		this.compareFiles(actualFiles);
	}

	@Test
	public void test_Widget_InternalServlet_Java() throws IOException {
		String commonPath = "src/main/java/com/myportal/aps/internalservlet/cat".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		List<File> actualFiles = this.searchFiles(actualDir, null);
		Assert.assertEquals(3, actualFiles.size());
		this.compareFiles(actualFiles);
	}

	@Test
	public void test_Widget_InternalServlet_Jsp() throws IOException {
		String commonPath = "src/main/webapp/WEB-INF/aps/jsp/internalservlet".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		List<File> actualFiles = this.searchFiles(actualDir, null);
		Assert.assertEquals(4, actualFiles.size());
		this.compareFiles(actualFiles);
	}

	@Test
	public void test_TestJava() throws IOException {
		String commonPath = "src/test/java/com/myportal".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		List<File> actualFiles = this.searchFiles(actualDir, null);
		Assert.assertEquals(6, actualFiles.size());
		this.compareFiles(actualFiles);
	}

	@Test
	public void test_TestResources() throws IOException {
		String commonPath = "src/test/resources".replaceAll("/", Matcher.quoteReplacement(File.separator));

		String actualPath = ACTUAL_BASE_FOLDER + commonPath;

		File actualDir = new File(actualPath);
		Assert.assertTrue(actualDir.exists());

		List<File> actualFiles = this.searchFiles(actualDir, null);
		Assert.assertEquals(2, actualFiles.size());
		this.compareFiles(actualFiles);
	}


	protected void compareFiles(List<File> actualFiles) throws IOException {
		Iterator<File> it = actualFiles.iterator();
		while (it.hasNext()) {
			File actual = it.next();

			String key = actual.getPath().replace(ACTUAL_BASE_FOLDER, TEST_BASE_FOLDER);
			String expected = ((MockBuilder) builder).getContent(key);
			//System.out.println(((MockBuilder) builder).getContents().keySet());
			Assert.assertTrue(key + " shuold exists ", expected != null);

			
			Assert.assertEquals(((MockBuilder)builder).getContents().get(key), FileUtils.readFileToString(actual, "UTF-8"));
			testedFiles++;

		}			
	}

	public List<File> searchFiles(File rootDir, FileFilter filter){
		List<File> results = new ArrayList<File>();
		for(File currentFile : rootDir.listFiles(filter)) {
			if(currentFile.isDirectory()) {
				results.addAll(this.searchFiles(currentFile, filter));
			} else {
				results.add(currentFile);
			}
		}
		return results;
	}

}
