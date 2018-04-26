package org.entando.edo.builder.out;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.entando.edo.builder.out.exception.EdoWriterException;
import org.entando.edo.model.EdoBuilder;

public class FileSystemWriter implements EdoWriter {

    private EdoBuilder edoBuilder = null;

    public FileSystemWriter(EdoBuilder edoBuilder) {
        this.edoBuilder = edoBuilder;
    }

    @Override
    public void onInit(EdoBuilder builder) {
        edoBuilder = builder;

    }

    @Override
    public EdoReportEntry write(String path, String text) {
        try {
            String workingDir = edoBuilder.getBaseDir();
            File file = new File(path);
            FileUtils.writeStringToFile(file, text, "UTF-8");

            path = StringUtils.substringAfter(path, workingDir + File.separator);
            EdoReportEntry edoReportEntry = new EdoReportEntry();
            edoReportEntry.setFileName(path);
            edoReportEntry.setLines(FileUtils.readLines(file).size());
            return edoReportEntry;
        } catch (Exception e) {
            throw new EdoWriterException("error in write file");
        }

    }

    @Override
    public void onClose() {
        // TODO Auto-generated method stub
    }

}
