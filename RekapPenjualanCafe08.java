import java.util.Arrays;
import java.util.Scanner;

public class RekapPenjualanCafe08 {

    static String[] menu;
    static int[][] penjualan;
    static int jumlahMenu, jumlahHari;


    static void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah menu: ");
        jumlahMenu = sc.nextInt();
        sc.nextLine();  

        System.out.print("Masukkan jumlah hari penjualan: ");
        jumlahHari = sc.nextInt();
        sc.nextLine();

        menu = new String[jumlahMenu];
        penjualan = new int[jumlahMenu][jumlahHari];

        System.out.println("\n=== Input Data Menu ===");
        for (int i = 0; i < jumlahMenu; i++) {
            System.out.print("Nama menu ke-" + (i + 1) + ": ");
            menu[i] = sc.nextLine();
        }

        System.out.println("\n=== Input Data Penjualan ===");
        for (int i = 0; i < jumlahMenu; i++) {
            System.out.println("Menu: " + menu[i]);
            for (int hari = 0; hari < jumlahHari; hari++) {
                System.out.print(" Hari ke-" + (hari + 1) + " : ");
                penjualan[i][hari] = sc.nextInt();
            }
        }
    }

    static void tampilData() {
        System.out.println("\n=== Tabel Penjualan ===");

        System.out.printf("%-15s", "Menu");
        for (int h = 1; h <= jumlahHari; h++) {
            System.out.printf("%5s", "H" + h);
        }
        System.out.println();

        for (int i = 0; i < jumlahMenu; i++) {
            System.out.printf("%-15s", menu[i]);
            for (int j = 0; j < jumlahHari; j++) {
                System.out.printf("%5d", penjualan[i][j]);
            }
            System.out.println();
        }
    }

    static void tampilMenuTerlaris() {
        System.out.println("\n=== Menu Terlaris per Hari ===");
        for (int hari = 0; hari < jumlahHari; hari++) {
            int max = -1;
            String namaMenu = "";
            for (int i = 0; i < jumlahMenu; i++) {
                if (penjualan[i][hari] > max) {
                    max = penjualan[i][hari];
                    namaMenu = menu[i];
                }
            }
            System.out.println("Hari ke-" + (hari + 1) + ": " + namaMenu + " (" + max + ")");
        }
    }

    static void tampilMenuTersepi() {
        System.out.println("\n=== Menu Tersepi Selama Periode ===");
        int min = Integer.MAX_VALUE;
        String menuMin = "";

        for (int i = 0; i < jumlahMenu; i++) {
            int total = 0;
            for (int j = 0; j < jumlahHari; j++) {
                total += penjualan[i][j];
            }
            if (total < min) {
                min = total;
                menuMin = menu[i];
            }
        }
        System.out.println("Menu dengan total terendah: " + menuMin + " (" + min + ")");
    }

    static void rataRataPerMenu() {
        System.out.println("\n=== Rata-rata Penjualan per Menu ===");
        for (int i = 0; i < jumlahMenu; i++) {
            int total = 0;
            for (int j = 0; j < jumlahHari; j++) {
                total += penjualan[i][j];
            }
            double rata = total / (double) jumlahHari;
            System.out.println(menu[i] + ": " + rata);
        }
    }

    static void menuTersepiPerHari() {
        System.out.println("\n=== Menu Tersepi per Hari ===");
        for (int hari = 0; hari < jumlahHari; hari++) {
            int min = Integer.MAX_VALUE;
            String namaMenu = "";
            for (int i = 0; i < jumlahMenu; i++) {
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
        menuTersepiPerHari();
    }
}