import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // set up scan object and df for decimal format class in order for the decimal numbers to be x.xx
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");

        // variables setup
        boolean status = true;
        String namaPembeli;
        int jumlahOrang = 0,
                orderNasiGoreng,
                orderAyamBakar,
                orderSteakSirloin,
                orderKwetiawSiram,
                orderKambingGuling;
        Double nasiGoreng = 9999.99,
                ayamBakar = 12345.67,
                steakSirloin = 21108.40,
                kwetiawSiram = 13579.13,
                kambingGuling = 98765.43;
        Double hargaPembelianIndividual, totalPembelianDisc, totalDisc, totalPembelian;

        while(status) {
            // program initialize and welcome its user
            System.out.println("Selamat siang...");
            System.out.print("Pesan untuk berapa orang : ");
            jumlahOrang = Integer.parseInt(scan.nextLine());
            System.out.print("Pesanan atas nama : ");
            namaPembeli = scan.nextLine();

            // print menu
            System.out.println("Menu Spesial hari ini" + "\n=========================");
            System.out.println("1. Nasi Goreng Spesial\t\t @ Rp. \t" + nasiGoreng);
            System.out.println("2. Ayam Bakar Spesial\t\t @ Rp. \t" + ayamBakar);
            System.out.println("3. Steak Sirloin Spesial\t @ Rp. \t" + steakSirloin);
            System.out.println("4. Kwetiaw Siram Spesial\t @ Rp. \t" + kwetiawSiram);
            System.out.println("5. Kambing Guling Spesial\t @ Rp. \t" + kambingGuling);

            // getting user input
            System.out.println("\n\nPesanan Anda [batas pemesanan 0 - 10 porsi]" + "\n=========================");
            System.out.print("1. Nasi Goreng Spesial\t\t = ");
            orderNasiGoreng = Integer.parseInt(scan.nextLine());
            System.out.print("2. Ayam Bakar Spesial\t\t = ");
            orderAyamBakar = Integer.parseInt(scan.nextLine());
            System.out.print("3. Steak Sirloin Spesial\t = ");
            orderSteakSirloin = Integer.parseInt(scan.nextLine());
            System.out.print("4. Kwetiaw Siram Spesial\t = ");
            orderKwetiawSiram = Integer.parseInt(scan.nextLine());
            System.out.print("5. Kambing Guling Spesial\t = ");
            orderKambingGuling = Integer.parseInt(scan.nextLine());

            // output invoice
            System.out.print("Selamat menikmati makanan anda...");
            System.out.println("\n\nPembelian untuk " + namaPembeli + " :");
            System.out.println("1. Nasi Goreng Spesial\t\t\t " + orderNasiGoreng + " porsi * Rp. " + df.format(nasiGoreng) + "\t = \t Rp. \t" + df.format(nasiGoreng * orderNasiGoreng));
            System.out.println("2. Ayam Bakar Spesial\t\t\t " + orderAyamBakar + " porsi * Rp. " + df.format(ayamBakar) + "\t = \t Rp. \t" + df.format(ayamBakar * orderAyamBakar));
            System.out.println("3. Steak Sirloin Spesial\t\t " + orderSteakSirloin + " porsi * Rp. " + df.format(steakSirloin) + "\t = \t Rp. \t" + df.format(steakSirloin * orderSteakSirloin));
            System.out.println("4. Kwetiaw Siram Spesial\t\t " + orderKwetiawSiram + " porsi * Rp. " + df.format(kwetiawSiram) + "\t = \t Rp. \t" + df.format(kwetiawSiram * orderKwetiawSiram));
            System.out.println("5. Kambing Guling Spesial\t\t " + orderKambingGuling + " porsi * Rp. " + df.format(kambingGuling) + "\t = \t Rp. \t" + df.format(kambingGuling * orderKambingGuling) + " +");
            System.out.println("=====================================================================");

            // calculate totalPembelian, then totalDisc is equals to 10% of totalPembelian
            totalPembelian = (nasiGoreng * orderNasiGoreng) + (ayamBakar * orderAyamBakar) + (steakSirloin * orderSteakSirloin) + (kwetiawSiram * orderKwetiawSiram) + (kambingGuling * orderKambingGuling);
            totalDisc = totalPembelian * 0.1;
            totalPembelianDisc = totalPembelian - totalDisc;
            hargaPembelianIndividual = totalPembelianDisc / jumlahOrang;
            System.out.println("Total Pembelian \t\t\t\t\t\t\t\t\t\t = \t Rp. \t" + df.format(totalPembelian));
            System.out.println("Disc. 10 % (Masa Promosi) \t\t\t\t\t\t\t\t = \t Rp. \t" + df.format(totalDisc) + " -");
            System.out.println("=====================================================================");
            System.out.println("Total Pembelian setelah discount 10% \t\t\t\t\t = \t Rp. \t" + df.format(totalPembelianDisc));
            System.out.println("Pembelian per orang (untuk " + jumlahOrang + " orang) \t\t\t\t\t = \t Rp. \t" + df.format(hargaPembelianIndividual));

            // ask if the user wants to retry the program
            System.out.print("\nApakah anda ingin kembali memesan?  [Y/T] ");
            String retry = scan.nextLine();

            if (retry.equalsIgnoreCase("t")){
                status = false;
                System.out.println("Terima kasih atas kunjungan anda... \n");
            } else if (retry.equalsIgnoreCase("y")) {
                status = true;
            } else {
                status = false;
            }
        }
    }
}