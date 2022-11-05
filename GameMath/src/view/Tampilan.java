/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import data.user;
import soal.Pengurangan;
import soal.Penjumlahan;
import soal.soal;
import java.util.Scanner;
/**
 *
 * @author AMEL
 */
public class Tampilan {
    user data = new user();
    soal soal = new soal();
    Scanner input = new Scanner(System.in);
    Scanner inputs = new Scanner(System.in);
    Penjumlahan tambah = new Penjumlahan();
    Pengurangan kurang = new Pengurangan();
    
    public static void main(String[] args) {
        new Tampilan().tampilanAwal();
    }

    private void tampilanAwal() {
        System.out.println("**********************");
        System.out.println("Game Math");
        System.out.println("**********************");
        System.out.println("Masukkan Nama : ");
        String nama = input.nextLine();
        user awal = new user();
        data.setNama(nama);
        this.tampilanMenu();
    }
    
    public void tampilanMenu(){
        data.reset();
        soal.reset();
        int pilihan = 0;
        
        while (pilihan < 1 || pilihan > 3) {
            System.out.println("**********************");
            System.out.println("Game Math");
            System.out.println("**********************");

            System.out.println("Menu : ");
            System.out.println("1. Penjumlahan");
            System.out.println("2. Pengurangan");
            System.out.println("3. Keluar");
            System.out.println();
            
            System.out.printf("Pilih Nomor Menu : ");
            pilihan = this.input.nextInt();
            
            switch (pilihan){
                case 1 :
                    this.soalPenjumlahan();
                    break;
                case 2 :
                    this.soalPengurangan();
                    break;
                case 3 :
                    System.exit(0);
                    break;
                default :
                    break;
            }
        }
    }

    public void soalPenjumlahan() {
        System.out.println("**********************");
        System.out.println("Game Math - Penjumlahan");
        System.out.println("**********************");
        
        boolean X = true;
        while (X == true){
            this.cetakSoalPenjumlahan();
        }
    }

    public void soalPengurangan() {
        System.out.println("**********************");
        System.out.println("Game Math - Pengurangan");
        System.out.println("**********************");
        
        boolean X = true;
        while (X == true){
            this.cetakSoalPengurangan();
        }
    }

    public void cetakSoalPenjumlahan() {
        int X = 0;
        int Y = 0;
        if (data.getSkor() <= 100) {
            soal.setLevel(1);
        } else if (data.getSkor() <= 200) {
            soal.setLevel(2);
        } else if (data.getSkor() <= 300) {
            soal.setLevel(3);
        } else if (data.getSkor() >= 300) {
            System.out.println("Selamat " + data.getNama()
                    +", Anada telah menyelesaikan ssoal penjumlahan dengan baik. Silakan dicoba soal pengurangan ya");
            this.tampilanMenu();
        }
        switch (soal.getLevel()) {
            case 1 :
                X = soal.randomAngka(0, 10);
                Y = soal.randomAngka(0, 10);
                break;
            case 2 :
                X = soal.randomAngka(-10, -1);
                Y = soal.randomAngka(-10, -1);
                break;
            case 3 :
                X = soal.randomAngka(-10, 10);
                X = soal.randomAngka(-10, 10);
                break;
            default :
                break;
        }
        String Xs = String.valueOf(X);
        String Ys = String.valueOf(Y);
        if (X < 0) {
            Xs = "(" + String.valueOf(X) + ")";
        }
        if (Y < 0) {
            Ys = "(" + String.valueOf(Y) + ")";
        }
        
        System.out.println("Berapakah hasil dari " + Xs + " + " + Ys + " ?");
        
        System.out.printf("Jawab : ");
        int jawaban = 0;
        
        if (inputs.hasNextInt()){
            jawaban += inputs.nextInt();
        } else {
            jawaban += 0;
        }
        
        if (jawaban != (tambah.getJawaban(X, Y))) {
            data.setLives(data.getLives() - 1);
            data.setSkor(data.getSkor() - 2);
            if (data.getSkor() > 100 && data.getSkor() <= 200){
                soal.setLevel(2);
            } else if (data.getSkor() > 200 && data.getSkor() <= 300){
                soal.setLevel(3);
            } else {
                soal.setLevel(1);
            }
            System.out.println("Wah, salah deh"
                    + "[Skor : " + data.getSkor() + "]"
                    + "[Lives : " + data.getLives() + "]"
                    + "[Level : " + soal.getLevel()+ "]");
        } else {
            data.setSkor(data.getSkor() + 5);
            if (data.getSkor() > 100 && data.getSkor() <= 200){
                soal.setLevel(2);
            } else if (data.getSkor() > 200 && data.getSkor() <= 300) {
                soal.setLevel(3);
            }
            System.out.println("Selamat " + data.getNama() + ", Anda Benar!"
                    + "[Skor : " + data.getSkor() + "]"
                    + "[Lives : " + data.getLives() + "]"
                    + "[Level : " + soal.getLevel()+ "]");
            System.out.println("---------------------------");
        }
        if (data.getLives() == 0) {
            System.out.println("Hai "
                    + data.getNama()
                    + ", Jangan menyerah ya untuk mencoba lagi.");
            this.tampilanMenu();
        }
    }

    public void cetakSoalPengurangan() {
        int X = 0;
        int Y = 0;
        if (data.getSkor() <= 100) {
            soal.setLevel(1);
        } else if (data.getSkor() <= 200) {
            soal.setLevel(2);
        } else if (data.getSkor() <= 300) {
            soal.setLevel(3);
        } else if (data.getSkor() >= 300) {
            System.out.println("Selamat " + data.getNama()
                    +", Anada telah menyelesaikan ssoal penjumlahan dengan baik. Silakan dicoba soal pengurangan ya");
            this.tampilanMenu();
        }
        switch (soal.getLevel()) {
            case 1 :
                X = soal.randomAngka(0, 10);
                Y = soal.randomAngka(0, 10);
                break;
            case 2 :
                X = soal.randomAngka(-10, -1);
                Y = soal.randomAngka(-10, -1);
                break;
            case 3 :
                X = soal.randomAngka(-10, 10);
                X = soal.randomAngka(-10, 10);
                break;
            default :
                break;
        }
        String Xs = String.valueOf(X);
        String Ys = String.valueOf(Y);
        if (X < 0) {
            Xs = "(" + String.valueOf(X) + ")";
        }
        if (Y < 0) {
            Ys = "(" + String.valueOf(Y) + ")";
        }
        
        System.out.println("Berapakah hasil dari " + Xs + " - " + Ys + " ?");
        
        System.out.printf("Jawab : ");
        int jawaban = 0;
        
        if (inputs.hasNextInt()){
            jawaban += inputs.nextInt();
        } else {
            jawaban += 0;
        }
        
        if (jawaban != (kurang.getJawaban(X, Y))) {
            data.setLives(data.getLives() - 1);
            data.setSkor(data.getSkor() - 2);
            if (data.getSkor() > 100 && data.getSkor() <= 200){
                soal.setLevel(2);
            } else if (data.getSkor() > 200 && data.getSkor() <= 300){
                soal.setLevel(3);
            } else {
                soal.setLevel(1);
            }
            System.out.println("Wah, salah deh"
                    + "[Skor : " + data.getSkor() + "]"
                    + "[Lives : " + data.getLives() + "]"
                    + "[Level : " + soal.getLevel()+ "]");
        } else {
            data.setSkor(data.getSkor() + 5);
            if (data.getSkor() > 100 && data.getSkor() <= 200){
                soal.setLevel(2);
            } else if (data.getSkor() > 200 && data.getSkor() <= 300) {
                soal.setLevel(3);
            }
            System.out.println("Selamat " + data.getNama() + ", Anda Benar!"
                    + "[Skor : " + data.getSkor() + "]"
                    + "[Lives : " + data.getLives() + "]"
                    + "[Level : " + soal.getLevel()+ "]");
        }
        if (data.getLives() == 0) {
            System.out.println("Hai "
                    + data.getNama()
                    + ", Jangan menyerah ya untuk mencoba lagi.");
            this.tampilanMenu();
        }
    }
}
