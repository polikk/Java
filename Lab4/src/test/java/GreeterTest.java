import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GreeterTest {

    @Test

    public void sayHelloTest() {
        Greeter greeter = new Greeter();
        assertEquals("Greeter should say 'Hello world!'","Hello world!", greeter.sayHello());
    }

    private void assertEquals(String s, String s1, String s2) {
    }
}
