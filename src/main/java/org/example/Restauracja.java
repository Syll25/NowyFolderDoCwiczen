package org.example;

import java.util.*;

public class Restauracja {

    Kelner kelner;

    public Restauracja() {
        this.kelner = new Kelner(new Kuchnia());
    }

    enum PizzaType {
        pepperoni, hawajska, serowa
    }

    enum Skladnik {
        ciasto, sos, ser, salami, ananas, pieczarki, kurczak, arugula
    }

    public static void main(String[] args) {
        Restauracja restauracja = new Restauracja();
        restauracja.otworz();

    }

    void otworz() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj rodzaj pizzy: pepperoni, hawajska, serowa. ");
        String nazwaPizzy = scanner.nextLine();

        try {
            PizzaType pizzaType = PizzaType.valueOf(nazwaPizzy);
            List<Skladnik> skladniki = kelner.przyniesPizze(pizzaType);

            System.out.println("Twoja pizza zawiera skladniki: ");
            for (Skladnik skladnik : skladniki.reversed()) {
                System.out.println(skladnik.name().substring(0, 1).repeat(10) + " " + "(" + skladnik.name() + ")");
            }
        } catch (RuntimeException e) {
            System.out.println("Nie mozna zrobic pizzy (" + e.getMessage() + ")");
        }
    }

    public static class Kelner {

        private final Kuchnia kuchnia;

        public Kelner(Kuchnia kuchnia) {
            this.kuchnia = kuchnia;
        }

        public List<Skladnik> przyniesPizze(PizzaType rodziajPizzy) {

            // wyliczyć rachunek
            return kuchnia.zrobPizze(rodziajPizzy);
        }
    }

    public static class Kuchnia {
        static Map<Skladnik, Integer> spizarnia = new HashMap<>();

        public Kuchnia() {

            spizarnia.put(Skladnik.ciasto, 5);
            spizarnia.put(Skladnik.sos, 10);
            spizarnia.put(Skladnik.ser, 15);
            spizarnia.put(Skladnik.salami, 8);
            spizarnia.put(Skladnik.ananas, 20);
            spizarnia.put(Skladnik.pieczarki, 12);
            spizarnia.put(Skladnik.kurczak, 5);
            spizarnia.put(Skladnik.arugula, 11);

        }

        public static Skladnik pobieranieSkladnikow(Skladnik skladnik) {

            int ilosc = spizarnia.getOrDefault(skladnik, 0);
            if (ilosc > 0) {
                spizarnia.put(skladnik, ilosc - 1);
            } else {
                throw new RuntimeException("Brak skladnika: " + skladnik.name());
            }
            return skladnik;
        }


        public List<Skladnik> zrobPizze(PizzaType rodzajPizzy) {
            List<Skladnik> skladniki = new ArrayList<>();

            switch (rodzajPizzy) {
                case pepperoni -> {

                    skladniki.add(pobieranieSkladnikow(Skladnik.ciasto));
                    skladniki.add(pobieranieSkladnikow(Skladnik.sos));
                    skladniki.add(pobieranieSkladnikow(Skladnik.ser));
                    skladniki.add(pobieranieSkladnikow(Skladnik.pieczarki));
                    skladniki.add(pobieranieSkladnikow(Skladnik.salami));
                }
                case hawajska -> {
                    skladniki.add(Skladnik.ciasto);
                    skladniki.add(Skladnik.sos);
                    skladniki.add(Skladnik.kurczak);
                    skladniki.add(Skladnik.ser);
                    skladniki.add(Skladnik.ananas);
                    skladniki.add(Skladnik.arugula);
                }
                case serowa -> {
                    skladniki.add(Skladnik.ciasto);
                    skladniki.add(Skladnik.sos);
                    skladniki.add(Skladnik.ser);
                }
                default -> throw new IllegalArgumentException("Nie ma takiej pizzy");
            }
            for (Skladnik skladnik : skladniki) {
                pobieranieSkladnikow(skladnik);

            }
            return skladniki;
        }

    }

}



