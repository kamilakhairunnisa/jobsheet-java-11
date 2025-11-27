import java.util.Arrays;
import java.util.Scanner;

public class RekapPenjualanCafe08 {

    static String[] menu = {"Kopi", "Teh", "Es Kelapa Muda", "Roti Bakar", "Gorengan"};
    static int[][] penjualan = new int [5][7];


    static void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Data Penjualan Cafe ===");

        for (int i = 0; i < menu.length; i++) {
            System.out.println("Menu " + menu[i]);
            for (int hari = 0; hari < 7; hari++) {
                System.out.print(" Hari ke- " + (hari + 1) + " : ");
                penjualan[i] [hari] = sc.nextInt();
            }
        }
    }

    static void tampilData() { 
        System.out.println("\n=== Tabel Data Penjualan 7 Hari ==="); 
         System.out.printf("%-15s", "Menu");
    for (int h = 1; h <= 7; h++) {
        System.out.printf("%5s", "H" + h);
    }
    System.out.println();

    for (int i = 0; i < menu.length; i++) { 
        System.out.printf("%-15s", menu[i]);
        for (int j = 0; j < 7; j++) { 
            System.out.printf("%5d", penjualan[i][j]);
        }
        System.out.println(); 
    }
}
    static void tampilMenuTerlaris() {
        System.out.println("\n=== Menu Terlaris per Hari ===");
        for (int hari = 0; hari < 7; hari++) {
        int max = -1;
        String namaMenu = "";

        for (int i = 0; i < menu.length; i++) {
            if (penjualan[i][hari] > max) {
                max = penjualan[i][hari];
                namaMenu = menu[i];
            }
        }
    System.out.println("Hari ke-" + (hari + 1) + ": " + namaMenu + " (" + max + ")");
        }
    }

    static void tampilMenuTersepi() {
        System.out.println("\n=== Menu tersepi dalam 7 hari ===");
        int min = Integer.MAX_VALUE;
        String menuMin = "";

        for (int i = 0; i < menu.length; i++) {
            int total = 0;
            for (int j = 0; j <7; j++) {
                total += penjualan[i][j];
            }
            if (total < min) {
                min = total;
                menuMin = menu[i];
            }
        }
        System.out.println("Menu dengan total penjualan terendah: " + menuMin + "" + min);
    }


    static void rataRataPerMenu() {
        System.out.println("\n=== Rata-rata Penjualan per Menu ===");
        for (int i = 0; i < menu.length; i++) {
            int total = 0;
            for (int j = 0; j < 7; j++) {
                total += penjualan[i][j];
            }
            int rata = (int) total / 7;
            System.out.println(menu[i] + ": " + rata);
        }
    }

    static void menuTerlarisPerHari() {
        System.out.println("\nMenu Terlaris per Hari:");
        for (int hari = 0; hari < 7; hari++) {
            int max = 0;
            String namaMenu = "";
            for (int i = 0; i < menu.length; i++) {
                if (penjualan[i][hari] > max) {
                    max = penjualan[i][hari];
                    namaMenu = menu[i];
                }
            }
            System.out.println("Hari ke-" + (hari + 1) + ": " + namaMenu + " (" + max + ")");
        }
    }

    static void menuTersepiPerHari() {
        System.out.println("\nMenu Tersepi per Hari:");
        for (int hari = 0; hari < 7; hari++) {
            int min = Integer.MAX_VALUE;
            String namaMenu = "";
            for (int i = 0; i < menu.length; i++) {
                if (penjualan[i][hari] < min) {
                    min = penjualan[i][hari];
                    namaMenu = menu[i];
                }
            }
            System.out.println("Hari ke-" + (hari + 1) + ": " + namaMenu + " (" + min + ")");
        }
    }

    public static void main(String[] args) {
        inputData();
        tampilData();
        tampilMenuTerlaris();
        tampilMenuTersepi();
        rataRataPerMenu();
        menuTerlarisPerHari();
        menuTersepiPerHari();
    }
}

