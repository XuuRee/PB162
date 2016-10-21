package cz.muni.fi.pb162.project.test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;, Masaryk University, Faculty of Informatics
 */
public class OutputTester {

    private OutputStream os;
    private PrintStream tempOutput;
    private PrintStream origOutput;

    /**
     * Constructor
     */
    public OutputTester() {
        os = new ByteArrayOutputStream();
        tempOutput = new PrintStream(os);
    }

    /**
     * Capture stdout and temporarily replace it with controlled output stream
     */
    public void captureOutput() {
        origOutput = System.out;
        System.setOut(tempOutput);
    }

    /**
     * Release the captured stdout
     */
    public void releaseOutput() {
        System.setOut(origOutput);
    }

    /**
     * Check that a matching text was written to stdout
     *
     * @param exp expected output
     * @return true if expected text is on stdout, false otherwise
     */
    public boolean outputEquals(String exp) {
        return exp.trim().equals(os.toString().trim());
    }

    /**
     * Check that a matching text (ignoring case) was written to stdout
     *
     * @param exp expected output
     * @return true if expected text is on stdout, false otherwise
     */
    public boolean outputEqualsIgnoreCase(String exp) {
        return exp.trim().equalsIgnoreCase(os.toString().trim());
    }
}
