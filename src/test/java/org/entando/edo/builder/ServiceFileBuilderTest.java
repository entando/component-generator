package org.entando.edo.builder;

import java.io.File;

import org.entando.edo.Edo;
import org.entando.edo.mock.parser.MockCommandLineParser;
import org.entando.edo.model.EdoBuilder;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.junit.Assert.assertThat;

public class ServiceFileBuilderTest {

    public EdoBuilder createBuilder() throws Throwable {
        MockCommandLineParser commandline = new MockCommandLineParser();
        commandline.setBaseDir(System.getProperty("user.dir") + File.separator + "target" + File.separator + "sandbox");
        commandline.setBeanExpression("Acme name:string descr:string-r20");
        commandline.setPackageName("org.entando.entando.xxx");
        return commandline.generate();
    }

    @Test
    public void testGetServiceInterfaceFilePath() throws Throwable {
        EdoBuilder builder = createBuilder();


        String fileName = ServiceFileBuilder.getServiceInterfaceFilePath(builder.getBean());
        assertThat(fileName, endsWith(File.separator + "IAcmeService.java"));

    }

    @Test
    //@Ignore
    public void testForReal() {
        String inString = "-baseDir=/dati/lavoro/repos/github/entando-core/engine --package=com.myportal Cat name:string-r8 age:int weight:bigdecimal createdat:date";
        String[] args = inString.split(" ");
        Edo.main(args);
        System.out.println("DELETE_THIS");
        System.out.println("DELETE_THIS");
        System.out.println("DELETE_THIS");
        System.out.println("DELETE_THIS");
    }
}
