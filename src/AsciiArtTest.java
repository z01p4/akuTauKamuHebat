import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class AsciiArtTest {
    @Test
    public void test00() throws IOException{
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(baos, true, StandardCharsets.UTF_8));
            System.out.print(
                    "     .___,\n" +
                            "  ___('v')___\n" +
                            "  `\"-\\._./-\"'\n" +
                            "      ^ ^\n" +
                            "  -----------\n" +
                            "Muhammad Rayyan Basalamah \uD83E\uDD89 (NPM: 2406496372)"
            );
        } finally {
            System.setOut(originalOut);
        }
        String printed = baos.toString(StandardCharsets.UTF_8);
        String[] lines = printed.split("\\R");

        assertEquals(6, lines.length);
        assertEquals("     .___,", lines[0]);
        assertEquals("  ___('v')___", lines[1]);
        assertEquals("  `\"-\\._./-\"'", lines[2]);
        assertEquals("      ^ ^", lines[3]);
        assertEquals("  -----------", lines[4]);
        assertEquals("Muhammad Rayyan Basalamah \uD83E\uDD89 (NPM: 2406496372)", lines[5]);
    }
}
