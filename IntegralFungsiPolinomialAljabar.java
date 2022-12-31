import java.util.Scanner;

public class IntegralFungsiPolinomialAljabar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Menagkap input dari user
        System.out.print("Masukkan derajat polinomial: ");
        int derajat = sc.nextInt();

// Membuat array untuk menyimpan koefisien
        double[] koefisien = new double[derajat + 1];
        for (int i = 0; i <= derajat; i++) {
            System.out.print("Masukkan koefisien x^" + i + ": ");
            koefisien[i] = sc.nextDouble();
        }

// Menagkap input batas integral
        System.out.print("Masukkan batas integral (a): ");
        double a = sc.nextDouble();
        System.out.print("Masukkan batas integral (b): ");
        double b = sc.nextDouble();

// Menagkap input jumlah subinterval
        System.out.print("Masukkan jumlah subinterval: ");
        int n = sc.nextInt();

// Menghitung jarak antar subinterval
        double h = (b - a) / n;

// Menghitung integral dengan metode Trapezoidal
        double integral = 0;
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            integral += hitungFungsi(x, koefisien, derajat);
        }
        integral = (integral + (hitungFungsi(a, koefisien, derajat) + hitungFungsi(b, koefisien, derajat)) / 2) * h;

// Menampilkan hasil integral
        System.out.println("Hasil integral: " + integral);
    }

    // Method untuk menghitung nilai fungsi polinomial pada suatu titik x
    public static double hitungFungsi(double x, double[] koefisien, int derajat) {
        double hasil = 0;
        for (int i = 0; i <= derajat; i++) {
            hasil += koefisien[i] * Math.pow(x, i);
        }
        return hasil;
    }
}