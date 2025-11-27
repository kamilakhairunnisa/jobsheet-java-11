import java.util.Scanner;

public class Cafe08 {
    
    public static void Menu(String namaPelanggan, boolean isMember, String kodePromo) {
        System.out.println("Selamat datang, " + namaPelanggan + "!");

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }

        if (kodePromo.equals("DISKON50")) {
            System.out.println("Kode promo valid: Anda mendapatkan diskon 50%!");
        } else if (kodePromo.equals("DISKON30")) {
            System.out.println("Kode promo valid: Anda mendapatkan diskon 30%!");
        } else {
            System.out.println("Kode promo invalid atau tidak ada promo yang berlaku.");
        }
        
    System.out.println("==== MENU RESTO KAFE");
    System.out.println("1. Kopi Hitam - RP 15,000");
    System.out.println("2. Cappucino - RP 20,000");
    System.out.println("3. Latte - RP 22,000");
    System.out.println("4. Teh Tarik - RP 12,000");
    System.out.println("5. Roti Bakar - RP 10,000");
    System.out.println("6. Mie Goreng - RP 18,000");
    System.out.println("===========================");
    System.out.println("Silahkan pilih menu yang anda inginkan");      
    }

    public static int hitungTotalHarga08(int pilihanMenu, int banyakItem, String kodePromo) {
        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};

        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;
        double diskon = 0;

        if (kodePromo.equals("DISKON50")) {
            diskon = 0.50;
            System.out.println("Kode promo DISKON50 berhasil diskon 50% diberikan");
        } else if (kodePromo.equals("DISKON30")) {
            diskon= 0.30;
            System.out.println("Kode promo DISKON30 berhasil diskon 30% diberikan");
        } else {
            System.out.println("Kode promo invalid! tidak ada diskon");
        }

        int totalSetelah = (int) (hargaTotal- (hargaTotal * diskon));
        return totalSetelah;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Menu("Budi", true, "DISKON30") ;
        int totalKeseluruhan = 0;
        String lanjut = "y";

        while (lanjut.equalsIgnoreCase("y")) {
        System.out.print("\nMasukkan nomor menu yang ingin Anda pesan: ");
        int pilihanMenu = sc.nextInt();
        System.out.print("Masukkan jumlah item yang ingin dipesan: ");
        int banyakItem = sc.nextInt();
        System.out.println("Masukkan kode promo");
        String kodePromo = sc.next();

        int totalBayar = hitungTotalHarga08(pilihanMenu, banyakItem, kodePromo);
        totalKeseluruhan += totalBayar;

        System.out.println("Ingin menambah pesanan lain? (y/n) ");
        lanjut = sc.next();
    }
    System.out.println("======================");
    System.out.println("Total keseluruhan pesanan; Rp " + totalKeseluruhan);    
    }
}
