import java.util.Scanner;

public class GajiKaryawan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Array gaji pokok: indeks 0 = A, 1 = B, 2 = C
        int[] gaji = {5000000, 6500000, 9500000};

        // Array persen lembur: indeks 0 = 1 jam, ... indeks 4 = >= 5 jam
        int[] lembur = {30, 32, 34, 36, 38};

        System.out.print("Masukkan Golongan (A/B/C): ");
        String golongan = input.next().toUpperCase();

        System.out.print("Masukkan Jam Lembur: ");
        int jamLembur = input.nextInt();

        int gajiPokok = 0;
        boolean golonganValid = true;

        // Mengambil gaji pokok dari array sesuai golongan
        if (golongan.equals("A")) {
            gajiPokok = gaji[0];
        } else if (golongan.equals("B")) {
            gajiPokok = gaji[1];
        } else if (golongan.equals("C")) {
            gajiPokok = gaji[2];
        } else {
            golonganValid = false;
        }

        if (!golonganValid) {
            System.out.println("Golongan tidak valid!");
        } else {
            int persenLembur = 0;

            // Menentukan persen lembur dari array berdasarkan jam lembur
            if (jamLembur <= 0) {
                persenLembur = 0;
            } else if (jamLembur == 1) {
                persenLembur = lembur[0];
            } else if (jamLembur == 2) {
                persenLembur = lembur[1];
            } else if (jamLembur == 3) {
                persenLembur = lembur[2];
            } else if (jamLembur == 4) {
                persenLembur = lembur[3];
            } else { // jamLembur >= 5
                persenLembur = lembur[4];
            }

            // Operator aritmatika: hitung gaji lembur dan total gaji
            double gajiLembur = gajiPokok * persenLembur / 100.0;
            double totalGaji = gajiPokok + gajiLembur;

            System.out.println("\n===== SLIP GAJI =====");
            System.out.println("Golongan      : " + golongan);
            System.out.println("Gaji Pokok    : Rp. " + String.format("%,d", gajiPokok));
            System.out.println("Jam Lembur    : " + jamLembur + " jam");
            System.out.println("Persen Lembur : " + persenLembur + "%");
            System.out.println("Gaji Lembur   : Rp. " + String.format("%,.0f", gajiLembur));
            System.out.println("Total Gaji    : Rp. " + String.format("%,.0f", totalGaji));
        }

        input.close();
    }
}