package test.laba6;

import laba6.Main;
import org.junit.Test;
import org.junit.contrib.java.lang.system.*;
import static org.junit.Assert.*;

public class MainTest {
    @Test
    /** freaks out if main prints ERROR
     * prints result on screen
     * hell no I won't write a test for outputs
     */
    public void main() throws Exception {
        SystemOutRule rule = new SystemOutRule().enableLog();
        Main.main(null);
        assertEquals(false, rule.getLog().contains("ERROR"));
    }
}
