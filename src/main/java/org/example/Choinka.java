package org.example;

public class Choinka {

    public static void main (String[] args) {
        int H = 10;
        int W = (H * 2) -1;

        for(int i = 0; i < H; i++) {

            int liczbaGwiazdek = wyliczanieGwiazdek(i);
            int liczbaSpacjiWPoziomie = W - liczbaGwiazdek;
            int liczbaSpacjiZLewej = liczbaSpacjiWPoziomie / 2;
            int liczbaSpacjiZPrawej = liczbaSpacjiZLewej;

            drukujSpacje(liczbaSpacjiZLewej);

            drukujGwiazdke(liczbaGwiazdek);

            drukujSpacje(liczbaSpacjiZPrawej);

            System.out.println();
        }

        int Pien = 5;
        int szerokoscPnia = 3;
        int liczbaSpacjiPniaZLewej = (W - szerokoscPnia) / 2;

        for (int i = 0; i < Pien; i++) {
            drukujSpacje(liczbaSpacjiPniaZLewej);
            drukujPien(szerokoscPnia);

            System.out.println();
        }
    }
    public static void drukujPien (int szerokoscPnia) {
        for (int i = 0; i < szerokoscPnia; i++) {
            System.out.print("x");
        }
    }

    public static int wyliczanieGwiazdek (int poziom) {
        return (poziom * 2) +1;
    }

    public static void drukujSpacje (int iloscSpacji) {
        for(int j = 0; j < iloscSpacji; j++) {
            System.out.print(" ");
        }
    }

    public static void drukujGwiazdke (int iloscGwiazdek) {
        for(int j = 0; j < iloscGwiazdek; j++){
            System.out.print("*");
        }
    }
}

