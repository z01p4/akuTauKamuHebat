import java.util.Scanner;

public class TerbesarTerkecil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input a: ");
        int a = scanner.nextInt();
        System.out.print("Input b: ");
        int b = scanner.nextInt();
        System.out.print("Input c: ");
        int c = scanner.nextInt();
        System.out.print("Input d: ");
        int d = scanner.nextInt();

        if (a >= b && a >= c && a >= d) {
            System.out.print("Bilangan terbesar " + a);
        } else if (b >= a && b >= c && b >= d) {
            System.out.print("Bilangan terbesar " + b);
        } else if (c >= a && c >= b && c >= d) {
            System.out.print("Bilangan terbesar " + c);
        } else if (d >= a && d >= b && d >= c) {
            System.out.print("Bilangan terbesar " + d);
        }

        System.out.println();
        if (a <= b && a <= c && a <= d) {
            System.out.print("Bilangan terkecil " + a);
        } else if (b <= a && b <= c && b <= d) {
            System.out.print("Bilangan terkecil " + b);
        } else if (c <= a && c <= b && c <= d) {
            System.out.print("Bilangan terkecil " + c);
        } else if (d <= a && d <= b && d <= c) {
            System.out.print("Bilangan terkecil " + d);
        }
    }
}
