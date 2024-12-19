package org.example;

public class Figury {

    public static void main(String[] args) {
        Figura figura = new Kwadrat(3, "czerwony");
        double wynik = figura.poleFigury();
        System.out.println(wynik);
        System.out.println(figura.color());

        figura = new Prostokat(3, 5);
        double wynik2 = figura.poleFigury();
        System.out.println(wynik2);
        Figura prostokat1 = new Prostokat(6, 9);
        double wynik3 = prostokat1.poleFigury();
        System.out.println(wynik3);

        Figura kolo = new Kolo("niebieski", 3);
        double wynik4 = kolo.poleFigury();
        System.out.println(wynik4);

    }

    static class Kwadrat extends Figura {
        private final int i;

        public Kwadrat(int i, String color) {
            super(color);
            this.i = i;

        }

        public double poleFigury() {
            return i * i;
        }

    }

    static class Kolo extends Figura {

        private double promien;
        public Kolo(String color, double promien) {
            super(color);
            this.promien = promien;
        }

        @Override
        public double poleFigury() {
            return Math.PI * promien * promien ;
        }
    }

    static class Trojkat extends Figura {

        public Trojkat(String color) {
            super(color);
        }

        @Override
        public double poleFigury() {
            return 0;
        }
    }

    static class Prostokat extends Figura {

        private final int i;
        private final int j;

        public Prostokat(int i, int j) {
            super("pink");
            this.i = i;
            this.j = j;
        }

        public double poleFigury() {
            return i * j;
        }
    }

    static abstract class Figura {

        public Figura (String color) {
            this.color = color;
        }
        private String color;

        public abstract double poleFigury();

        public String color() {
            return color;
        }


    }


}
