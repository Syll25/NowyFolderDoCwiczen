package org.example;

public class Zatrudnienie {

    public static void main(String[] args) {

        Kontrakt kontraktUOP = new UOP (6000);
        Pracownik pracownik = new Pracownik(kontraktUOP, 10);

        System.out.println(pracownik.kontrakt.trescUmowy());
        System.out.println("Roczne wynagrodzenie po odjeciu dni urlopowych:  " + pracownik.wynagrodzenieRoczne());

    }

    public static abstract class Kontrakt {

        public abstract String tytul();

        public abstract String trescUmowy();

        public abstract double wynagrodzenie();

        public abstract String dataZawarciaUmowy();

    }

    public static class UOP extends Kontrakt {
        private double wynagrodzenie;

        public UOP(double wynagrodzenie) {
            this.wynagrodzenie = wynagrodzenie;
        }

        @Override
        public String tytul() {
            return "Umowa o prace.";
        }

        @Override
        public String trescUmowy() {
            return "Zatrudnienie na umowe o prace";
        }

        @Override
        public double wynagrodzenie() {
            return wynagrodzenie;
        }

        @Override
        public String dataZawarciaUmowy() {
            return " 1 Marca 2024 ";
        }
    }

    public static class UOD extends Kontrakt {
        private double wynagrodzenie;

        public UOD(double wynagrodzenie) {
            this.wynagrodzenie = wynagrodzenie;
        }

        @Override
        public String tytul() {
            return "Umowa o dzielo.";
        }

        @Override
        public String trescUmowy() {
            return "Zatrudnienie na umowe o dzielo";
        }

        @Override
        public double wynagrodzenie() {
            return wynagrodzenie;
        }

        @Override
        public String dataZawarciaUmowy() {
            return "1 Sierpnia 2020";
        }
    }

    public static class JDG extends Kontrakt {
        private double wynagrodzenie;

        public JDG(double wynagrodzenie) {
            this.wynagrodzenie = wynagrodzenie;
        }

        @Override
        public String tytul() {
            return "Jednoosobowa dzialalnosc gospodarcza. ";
        }

        @Override
        public String trescUmowy() {
            return "Zatrudnienie jako jednoosobowa dzialnosc gospodarcza";
        }

        @Override
        public double wynagrodzenie() {
            return wynagrodzenie;
        }

        @Override
        public String dataZawarciaUmowy() {
            return "10 lipca 2010";
        }
    }

    public static class Pracownik {

        private Kontrakt kontrakt;
        private int dniUrlopowe;

        public Pracownik(Kontrakt kontrakt, int dniUrlopowe) {
            this.kontrakt = kontrakt;
            this.dniUrlopowe = dniUrlopowe;
        }

        public double wynagrodzenieRoczne () {

            int dniRoboczeWMiesiacu = 22;
            int dniRoboczeWRoku = dniRoboczeWMiesiacu * 12;

            double wynagrodzenieMiesieczne = kontrakt.wynagrodzenie();
            double wynagrodzenieRoczne = wynagrodzenieMiesieczne * 12;
            double wynagrodzenieDzienne = wynagrodzenieRoczne / dniRoboczeWRoku;

            double poOdjeciuDniUrlopowych = wynagrodzenieDzienne * dniUrlopowe;
            return wynagrodzenieRoczne - poOdjeciuDniUrlopowych;
            }
        }

    }

