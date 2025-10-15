import java.util.Random;
import java.util.Scanner;

public class SubstringIndeks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rng = new Random();

        // minta kalimat dari user
        System.out.print("Masukkan sebuah kalimat: ");
        String kalimat = sc.nextLine();

        // pilih indeks acak [start..end] (end inklusif)
        int n = kalimat.length();
        int start = rng.nextInt(n);               // 0..n-1
        int end = start + rng.nextInt(n - start); // start..n-1 (pasti >= start)

        // tanya user apa substringnya
        System.out.print("Apa substring dari indeks " + start + " hingga " + end + "? ");
        String jawabanUser = sc.nextLine();

        // hitung jawaban benar (ingat: end inklusif => end+1 di Java)
        String jawabanBenar = kalimat.substring(start, end + 1);

        if (jawabanUser.equals(jawabanBenar)) {
            System.out.println("\u2714 Benar! Keren, kamu jago string!");
        } else {
            System.out.println("\u2718 Kurang tepat. Jawaban yang benar: " + jawabanBenar);
        }
    }
}

