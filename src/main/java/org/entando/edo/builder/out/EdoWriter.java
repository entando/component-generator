package org.entando.edo.builder.out;

import org.entando.edo.model.EdoBuilder;

public interface EdoWriter {

    public void onInit(EdoBuilder edoBuilder);

    public EdoReportEntry write(String path, String text);

    public void onClose();
}
