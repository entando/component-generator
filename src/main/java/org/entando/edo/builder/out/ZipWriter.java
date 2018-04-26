package org.entando.edo.builder.out;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.entando.edo.builder.out.exception.EdoWriterException;
import org.entando.edo.model.EdoBuilder;

public class ZipWriter implements EdoWriter {

    private Logger logger = LogManager.getLogger(getClass());

    private ZipOutputStream zipStream = null;
    private EdoBuilder edoBuilder = null;
    private String folder = null;


    public ZipWriter(EdoBuilder builder, String folder) {
        this.folder = folder;
        this.onInit(builder);
    }

    public EdoReportEntry write(String path, String text) {
        try {
            File file = File.createTempFile("prefix-", "suffix-");
            FileUtils.writeStringToFile(file, text, "UTF-8");
            addFile(path, text, zipStream);

            EdoReportEntry edoReportEntry = new EdoReportEntry();
            edoReportEntry.setFileName(path);
            edoReportEntry.setLines(FileUtils.readLines(file).size());
            file.deleteOnExit();
            return edoReportEntry;

        } catch (Exception e) {
            throw new EdoWriterException("error error in write file", e);
        }
    }


    private void addFile(String file, String text, ZipOutputStream zipStream) {
        try {
            ZipEntry entry = new ZipEntry(file);
            zipStream.putNextEntry(entry);
            zipStream.write(text.getBytes());
            zipStream.closeEntry();

        } catch (IOException e) {
            throw new EdoWriterException("error error in write zip");
        }
    }

    @Override
    public void onInit(EdoBuilder builder) {
        try {
            List<String> tokens = new ArrayList<>(Arrays.asList(folder.split(File.separator)));
            tokens.add(builder.getBean().getName() + ".zip");
            String zipFileName = StringUtils.join(tokens, File.separator);

            OutputStream os = new FileOutputStream(zipFileName);
            zipStream = new ZipOutputStream(os);
            edoBuilder = builder;
        } catch (Exception e) {
            throw new EdoWriterException("error creating zip");
        }

    }

    @Override
    public void onClose() {
        try {
            zipStream.close();
        } catch (Exception e) {
            throw new EdoWriterException("error closing zip");
        }

    }

}
