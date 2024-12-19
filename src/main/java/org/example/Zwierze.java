package org.example;

import java.util.ArrayList;
import java.util.List;

public interface Zwierze {

    int liczbaLap ();
    String wydawanyDzwiek ();
    String nazwa();

    public static void main(String[] args) {

        List<Zwierze> listaZwierzat = new ArrayList<>();
        listaZwierzat.add(new Pies());
        listaZwierzat.add(new Pies());
        listaZwierzat.add(new Pies());
        listaZwierzat.add(new Kot());
        listaZwierzat.add(new Kot());
        listaZwierzat.add(new Kot());
        listaZwierzat.add(new Koala());
        listaZwierzat.add(new Koala());
        listaZwierzat.add(new Koala());
        listaZwierzat.add(new Stonoga());
        listaZwierzat.add(new Stonoga());
        listaZwierzat.add(new Stonoga());

        for (Zwierze zwierze: listaZwierzat) {
            System.out.println("Nazwa: " + zwierze.nazwa() + " Wydawany dzwiek: " + zwierze.wydawanyDzwiek() +" Liczba lap: " + zwierze.liczbaLap());
        }

    }

    class Pies implements Zwierze {

        @Override
        public int liczbaLap() {
            return 4;
        }
        @Override
        public String wydawanyDzwiek() {
            return "Hau hau";
        }
        @Override
        public String nazwa() {
            return "Pies";
        }
    }
    class Kot implements Zwierze {

        @Override
        public int liczbaLap() {
            return 4;
        }
        @Override
        public String wydawanyDzwiek() {
            return "Miau miau";
        }

        @Override
        public String nazwa() {
            return "Kot";
        }
    }
    class Koala implements Zwierze {

        @Override
        public int liczbaLap() {
            return 4;
        }

        @Override
        public String wydawanyDzwiek() {
            return "Gu gu";
        }

        @Override
        public String nazwa() {
            return "Koala";
        }
    }
    class Stonoga implements Zwierze {

        @Override
        public int liczbaLap () {
            return 100;
        }
        @Override
        public String wydawanyDzwiek () {
            return "Szururu";
        }

        @Override
        public String nazwa() {
            return "Stonoga";
        }
    }


}
