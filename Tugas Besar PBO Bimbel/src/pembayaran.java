import java.util.InputMismatchException;

// Inheritance
public class pembayaran extends transaksi {
    public int biaya1;

    // Consturctor
    public pembayaran(int biaya1) {
        this.biaya1 = biaya1;
    }

    @Override
    public void MetodePembayaran() {
        System.out.println("\n==================================");
        System.out.println("     !! Metode Pembayaran !!");
        System.out.println("==================================");
        System.out.println(" 1. Kartu Debit Diskon 5%");
        System.out.println(" 2. Kartu Kredit");
        System.out.println(" 3. Tunai");
        System.out.print("\n > Masukkan Metode Pembayaran : ");
        metode = input.nextInt();
        //percabangan
        if (metode == 1) {
            metodenya = "Kartu Debit";
            // operasi matematika
            diskon = (int) (((double) 5 / 100) * biaya1);
            totalHarga=biaya1-diskon;
            System.out.print(" Total harga : Rp. " + totalHarga);
            System.out.println("");
        } else if (metode == 2) {
            metodenya = "Kartu Kredit";
            totalHarga = biaya1;
            System.out.print(" Total harga : Rp. " + totalHarga);
            System.out.println("");
        } else if (metode == 3) {
            metodenya = "Tunai";
            totalHarga = biaya1;
            System.out.print(" Total harga : Rp. " + totalHarga);
            System.out.println("");
            System.out.print(" Cash : Rp. ");
            cash = input.nextInt();
            System.out.println("");

            // percabangan
            if (totalHarga > cash) {
                System.out.println("Uang anda kurang");
                System.out.print("\n > Masukkan uang anda : ");
                cash = input.nextInt();
                input.nextLine();
                System.out.println("");
                // operasi matematika
                kembalian = cash - totalHarga;
                System.out.println("Kembalian : Rp. " + kembalian);
                System.out.println("");

            } else {
                // operasi matematika
                kembalian = cash - totalHarga;
                System.out.println("Kembalian : Rp. " + kembalian);
                System.out.println("");
            }

        } else {
            System.out.println("Masukkan metode pembayaran 1-3");
            System.out.print("\n > Masukkan Metode Pembayaran : ");
            metode = input.nextInt();
        }
    }

    @Override
    // Exception
    public void kelas() {
        boolean kondisi = true;
        do {
            try {
                if (inputwaktu <= 0 || inputwaktu > 3)
                    throw new Exception();
                kondisi = false;
            } catch (InputMismatchException e) {
                System.out.print("Inputan anda salah! pilihan hanya bisa diisi angka" + "\n");
                input.nextLine();
            } catch (Exception e) {
                System.out.print("Inputan anda salah! pilihan harus hanya bisa diisi angka 1-2" + "\n");
                input.nextLine();
            } finally {
                System.out.print("Yeay! Susah Benar" + "\n");
            }
        } while (kondisi);
    }

}
