import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class UnitTestOutput {
    @Test
    public void test00() throws IOException{
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(baos, true, StandardCharsets.UTF_8));
            System.out.print("");
        } finally {
            System.setOut(originalOut);
        }
        String printed = baos.toString(StandardCharsets.UTF_8);
        String[] lines = printed.split("\\R");

        assertEquals(1, lines.length);
        assertEquals("", lines[0]);
    }
}
