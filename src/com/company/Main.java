package com.company;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void pilihan(){
        System.out.println("Choose Your Music");
        System.out.println(" 1. Input Lagu ");
        System.out.println(" 2. Hapus Lagu ");
        System.out.println(" 3. Play Lagu ");
        System.out.println(" 4. keluar ");
    }

    public static void main(String[] args) {
        LinkedList<PlayListLagu> playListLagus = new LinkedList<PlayListLagu>();
        Scanner input = new Scanner(System.in);
        boolean kondisi = true;

        while (kondisi){
            pilihan();
            switch (input.nextInt()){
                case 1 :
                    System.out.println("Masukan Judul Lagu");
                    String JudulLagu = input.next();
                    String singer = input.next();
                    playListLagus.addLast(new PlayListLagu(JudulLagu,singer));
                    break;
                case 2 :
                    System.out.println("1. hapus lagu terakhir");
                    System.out.println("2. hapus lagu berdasarkan judul");
                    int hapus = input.nextInt();
                    if (hapus == 1){
                        playListLagus.removeLast();
                    }else if ( hapus == 2) {
                        String hapusJudul = input.next();
                        removeByTitle(playListLagus, hapusJudul);}
                    break;

                case 3 :
                    print(playListLagus);
                    break;

                case 4 :
                    break;

            }
        }
    }

    // mencetak head ke tail, dan tail ke head
    private static void print(LinkedList<PlayListLagu> playListLagus) {
        ListIterator<PlayListLagu>iterator = playListLagus.listIterator();

        while (iterator.hasNext()){
            if (iterator.hasPrevious()){
                System.out.print(", "+iterator.next());
            }
            else {
                System.out.print(iterator.next());
            }
        }
        iterator.previous();
        while (iterator.hasPrevious()){
            System.out.print(", "+ iterator.previous());
        }
        System.out.println();
    }

    // untuk mencari judul lagu yg diinput user
    public static void removeByTitle(LinkedList<PlayListLagu> playListLagus, String hapusJudul) {
        ListIterator<PlayListLagu> iterator = playListLagus.listIterator();

        while (iterator.hasNext()){
            PlayListLagu playListLagu = iterator.next();
            if (playListLagu.getSongTitle().equalsIgnoreCase(hapusJudul)){
                iterator.remove();
            }
        }
    }
}
