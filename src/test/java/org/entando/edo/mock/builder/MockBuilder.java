package org.entando.edo.mock.builder;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.entando.edo.builder.Builder;
import org.entando.edo.model.EdoConstants;
import org.entando.edo.report.Report;


public class MockBuilder extends Builder {

	protected void writeFile(String baseDir, String path, String text) {
		try {
			Report report = Report.getInstance();
			String workingDir = baseDir;
			//File file = new File(path);
			this.getContents().put(path, text);
			//TODO
			int lines = -1;//FileUtils.readLines(file).size();
			path = StringUtils.substringAfter(path, workingDir  + File.separator);

			if (FilenameUtils.getBaseName(path).startsWith(EdoConstants.FILE_NO_OVERRIDE_PREFIX)) {
				report.addFileToMerge(path, lines);
			} else {
				report.addFile(path, lines);
			}
		} catch (Throwable t) {
			logger.error("error!", t);
			t.printStackTrace();
		}
	}
	
	public String getContent(String key) {
		return this.getContents().get(key);
	}

	public Map<String, String> getContents() {
		return contents;
	}
	public void setContents(Map<String, String> contents) {
		this.contents = contents;
	}

	private Map<String, String> contents = new HashMap<String, String>();
}
