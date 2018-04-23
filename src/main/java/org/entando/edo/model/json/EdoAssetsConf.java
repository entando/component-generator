package org.entando.edo.model.json;


public class EdoAssetsConf {

    private boolean rest;
    private boolean cxf;
    private boolean specialWidget;
    private boolean internalServlet;
    private boolean adminConsole;
    private String adminConsoleProducer;

    public boolean isRest() {
        return rest;
    }

    public void setRest(boolean rest) {
        this.rest = rest;
    }

    public boolean isCxf() {
        return cxf;
    }

    public void setCxf(boolean cxf) {
        this.cxf = cxf;
    }

    public boolean isSpecialWidget() {
        return specialWidget;
    }

    public void setSpecialWidget(boolean specialWidget) {
        this.specialWidget = specialWidget;
    }

    public boolean isInternalServlet() {
        return internalServlet;
    }

    public void setInternalServlet(boolean internalServlet) {
        this.internalServlet = internalServlet;
    }

    public String getAdminConsoleProducer() {
        return adminConsoleProducer;
    }

    public void setAdminConsoleProducer(String adminConsoleProducer) {
        this.adminConsoleProducer = adminConsoleProducer;
    }

    public boolean isAdminConsole() {
        return adminConsole;
    }

    public void setAdminConsole(boolean adminConsole) {
        this.adminConsole = adminConsole;
    }

}
