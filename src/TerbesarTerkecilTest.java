import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class TerbesarTerkecilTest {

    @Test
    public void testSemuaUnik() {
        // siapkan input: user mengetik 4 angka (tiap baris)
        String stdin = "4\n7\n-3\n2\n";

        // simpan stream asli
        PrintStream originalOut = System.out;
        java.io.InputStream originalIn = System.in;

        // siapkan stream pengganti
        ByteArrayInputStream bais = new ByteArrayInputStream(stdin.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            System.setIn(bais);
            System.setOut(new PrintStream(baos, true)); // cukup default; baca pakai UTF-8 saat cek

            // jalankan program
            TerbesarTerkecil.main(new String[0]);
        } finally {
            // kembalikan stream supaya test lain aman
            System.setOut(originalOut);
            System.setIn(originalIn);
        }

        // ambil output sebagai String (UTF-8)
        String out = baos.toString(StandardCharsets.UTF_8);

        // cek prompt tampil
        assertTrue(out.contains("Input a: "));
        assertTrue(out.contains("Input b: "));
        assertTrue(out.contains("Input c: "));
        assertTrue(out.contains("Input d: "));

        // cek hasil (format: ada satu newline di antara dua baris hasil)
        String expected =
                "Bilangan terbesar 7" + System.lineSeparator() +
                        "Bilangan terkecil -3";
        assertTrue("hasil tidak sesuai: " + out, out.contains(expected));
    }
}
