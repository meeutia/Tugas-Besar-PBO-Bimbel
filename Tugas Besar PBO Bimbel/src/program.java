import java.util.InputMismatchException;
import java.util.Scanner;

import java.sql.*;

//inheritance
public class program extends transaksi {

    static Scanner input;
    static Connection conn;

    public static void main(String[] args) {

        // pengolahan Database CRUD
        try {
            input = new Scanner(System.in);
            String pilihanUser;
            boolean isLanjutkan = true;

            String url = "jdbc:mysql://localhost:3306/bimbel";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, "root", "");
                System.out.println("Class Driver ditemukan\n");
                System.out.println("=!! WELLCOME TO PROGRAM KASIR BIMBEL  !!=\n");

                while (isLanjutkan) {
                    System.out.println("\n--------------------------------");
                    System.out.println("PROGRAM KASIR BIMBEL");
                    System.out.println("         ");
                    System.out.println("--------------------------------");
                    System.out.println("    1. Lihat  Data Pendaftar");
                    System.out.println("    2. Tambah Data Pendaftar");
                    System.out.println("    3. Ubah   Data Pendaftar");
                    System.out.println("    4. Hapus  Data Pendaftar");
                    System.out.println("    5. Cari   Data Pendaftar");

                    System.out.print("\n> Pilihan anda (1/2/3/4/5): ");
                    pilihanUser = input.next();
                    input.nextLine();

                    switch (pilihanUser) {
                        case "1":
                            lihatdata();
                            break;
                        case "2":
                            tambahdata();
                            break;
                        case "3":
                            ubahdata();
                            break;
                        case "4":
                            hapusdata();
                            break;
                        case "5":
                            caridata();
                            break;
                        default:
                            System.err.println("\nInput anda tidak ditemukan\nInputkan [1-5]");
                    }

                    System.out.print("\n> Apakah Anda ingin melanjutkan [y/n]? ");
                    pilihanUser = input.next();
                    input.nextLine();
                    isLanjutkan = pilihanUser.equalsIgnoreCase("y");

                }
                // Exception
            } catch (ClassNotFoundException ex) {
                System.err.println("\nDriver Error\n");
                System.exit(0);
            } catch (SQLException e) {
                System.err.println("Tidak Ada Koneksi");
            }
        } finally {
            if (input != null) {
                input.close();  // Close the Scanner when it's no longer needed
            }
        }
    }

    private static void lihatdata() throws SQLException {
        System.out.println("\n====================================");
        String text1 = "Daftar Seluruh Pendaftar Bimbel";
        System.out.println(text1.toUpperCase());
        System.out.println("====================================");

        String sql = "SELECT * FROM pendaftar";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            System.out.print("\nTanggal transaksi\t: ");
            System.out.print(result.getString("tanggal"));
            System.out.print("\nID Pembeli\t\t: ");
            System.out.print(result.getString("id_pendaftar"));
            System.out.print("\nNama Pembeli\t\t: ");
            System.out.print(result.getString("nama_pendaftar"));
            System.out.print("\nAplikasi \t\t: ");
            System.out.print(result.getString("paket"));
            System.out.print("\nWaktu\t\t\t: ");
            System.out.print(result.getString("waktu"));
            System.out.print("\nKelas\t\t\t: ");
            System.out.print(result.getString("kelas"));
            System.out.print("\nMetode Pembayaran\t: ");
            System.out.print(result.getString("pembayaran"));
            System.out.print("\nTotal pembayaran\t: ");
            System.out.print(result.getInt("total_Pembayaran"));
            System.out.print("\n");
        }
    }

    private static void tambahdata() throws SQLException {
        System.out.println("\n==================================");
        String text2 = "      Tambah Data Pendaftar";
        System.out.println(text2.toUpperCase());
        System.out.println("==================================");

        try {

            transaksi trans = new transaksi();
            // trans.IdPembeli();
            // Integer idpembeli = input.nextInt();
            // input.nextLine();
            trans.NamaPendaftar();
            String namaPendaftar = input.nextLine();
            trans.Tanggal();
            String tanggal = trans.tanggal;
            trans.pkt();
            trans.wkt();
            trans.kelas();
            trans.hrg();

            pembayaran bayar = new pembayaran(biaya1);
            bayar.MetodePembayaran();
            Integer.toString(biaya1);

            String sql = "INSERT INTO pendaftar ( tanggal, nama_pendaftar, paket, waktu, kelas, pembayaran, total_Pembayaran) VALUES ('"
                    + tanggal + "','" + namaPendaftar + "','" + paketnya + "','" + waktu + "','"
                    + sesi + "','" + metodenya + "','" + totalHarga + "')";

            Statement statement = conn.createStatement();
            statement.execute(sql);
            System.out.println("\nBerhasil input data");
            
            // Exception
        } catch (SQLException e) {
            System.err.println("\nTerjadi Kesalahan Input");
        } catch (InputMismatchException e) {
            System.err.println("\nInputlah dengan angka saja");
        }
    }
    

    private static void ubahdata() throws SQLException {
        System.out.println("\n==================================");
        String text3 = "        Ubah Data Pendaftar";
        System.out.println(text3.toUpperCase());
        System.out.println("==================================");

        try {
            try {
                lihatdata();
                {
                    System.out.print("\n> Masukkan ID Pendaftar yang akan di ubah atau update : ");
                    Integer idpendaftar = Integer.parseInt(inputt.nextLine());

                    String sql = "SELECT * FROM pendaftar WHERE id_Pendaftar = " + idpendaftar;

                    Statement statement = conn.createStatement();
                    ResultSet result = statement.executeQuery(sql);

                    if (result.next()) {

                        System.out.print("\nNama pendaftar [" + result.getString("nama_pendaftar") + "]\t: ");
                        String namaPendaftar = inputt.nextLine();

                        transaksi trans = new transaksi();
                        trans.Tanggal();
                        String tanggal = trans.tanggal;
                        trans.pkt();
                        trans.wkt();
                        trans.kelas();
                        trans.hrg();
                        pembayaran bayar = new pembayaran(biaya1);
                        bayar.MetodePembayaran();
                        Integer.toString(biaya1);

                        sql = "UPDATE pendaftar SET tanggal='" + tanggal + "',nama_pendaftar='" + namaPendaftar
                                + "',paket = '"
                                + paketnya + "',waktu= '" + waktu + "', kelas='" + sesi + "', pembayaran='"
                                + metodenya + "', total_Pembayaran='" + totalHarga + "' WHERE id_Pendaftar='" + idpendaftar
                                + "'";
                        // System.out.println(sql);

                        if (statement.executeUpdate(sql) > 0) {
                            System.out.println("\nBerhasil memperbaharui data pembeli (id_Pembeli " + idpendaftar + ")");
                        }
                    }
                    statement.close();
                }
                // Exception
            } catch (SQLException e) {
                System.err.println("\nTerjadi kesalahan dalam mengedit data");
                System.err.println(e.getMessage());
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void hapusdata() {
        System.out.println("\n==================================");
        String text4 = "         Hapus Data Pendaftar";
        System.out.println(text4.toUpperCase());
        System.out.println("==================================");

        try {
            try {
                lihatdata();
                System.out.print("\n> Ketik ID pendaftar yang akan Anda Hapus : ");
                Integer idpendaftar = Integer.parseInt(inputt.nextLine());

                String sql = "DELETE FROM pendaftar WHERE id_Pendaftar = " + idpendaftar;
                Statement statement = conn.createStatement();
                // ResultSet result = statement.executeQuery(sql);

                if (statement.executeUpdate(sql) > 0) {
                    System.out.println("\nBerhasil menghapus data pendaftar (ID pendaftar " + idpendaftar + ")");
                }
                // Exception
            } catch (SQLException e) {
                System.out.println("\nTerjadi kesalahan dalam menghapus data pembeli");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void caridata() throws SQLException {
        System.out.println("\n==================================");
        String text5 = "         Cari Data Pendaftar";
        System.out.println(text5.toUpperCase());
        System.out.println("==================================");

        System.out.print("\nMasukkan nama pendaftar : ");

        String keyword = inputt.nextLine();
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM pendaftar WHERE nama_pendaftar LIKE '%" + keyword + "%'";
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            System.out.print("\nTanggal transaksi\t: ");
            System.out.print(result.getString("tanggal"));
            System.out.print("\nID Pendaftar\t\t: ");
            System.out.print(result.getString("id_pendaftar"));
            System.out.print("\nNama Pendaftar\t\t: ");
            System.out.print(result.getString("nama_pendaftar"));
            System.out.print("\n paket \t\t: ");
            System.out.print(result.getString("paket"));
            System.out.print("\nwaktu\t\t\t: ");
            System.out.print(result.getString("waktu"));
            System.out.print("\nkelas\t\t\t: ");
            System.out.print(result.getString("kelas"));
            System.out.print("\nMetode pembayaran\t: ");
            System.out.print(result.getString("pembayaran"));
            System.out.print("\nTotal pembayaran\t: ");
            System.out.print(result.getInt("total_Pembayaran"));
            System.out.print("\n");
        }
    }
}
