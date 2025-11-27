import java.util.Scanner;
public class Kubus08 {

    static int hitungVolume(int sisi) {
        return sisi * sisi * sisi; 
    }
    static int hitungLuasPermukaan(int sisi) {
        return 6 * sisi * sisi;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukkan panjang sisi kubus:");
        int sisi = input.nextInt();

        int volume = hitungVolume(sisi);
        System.out.println("Volume kubus adalah: " + volume);

        int luasPermukaan = hitungLuasPermukaan(sisi);
        System.out.println("Luas permukaan kubus adalah: " + luasPermukaan);

        input.close();
    }
    
}
