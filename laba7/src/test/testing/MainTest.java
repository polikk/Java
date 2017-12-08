package testing;

import laba7.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

public class MainTest {
    @Test
    public void testCreatePersonObjects() {
        ArrayList<Person> personList = Main.createPersonList();
        assertNotNull(personList);
    }
}
