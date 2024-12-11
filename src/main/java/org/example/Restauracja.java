package org.example;

import java.util.*;

public class Restauracja {

    enum PizzaType {
        pepperoni, hawajska, serowa
    }

    enum Skladnik {
        ciasto, sos, ser, salami, ananas, pieczarki, kurczak, arugula
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj rodzaj pizzy: pepperoni, hawajska, serowa. ");
        String nazwaPizzy = scanner.nextLine();

        try {
            PizzaType pizzaType = PizzaType.valueOf(nazwaPizzy);
            Kelner kelner = new Kelner();

            List<Skladnik> skladniki = kelner.przyniesPizze(pizzaType);

            System.out.println("Twoja pizza zawiera skladniki: ");
            for (Skladnik skladnik : skladniki) {
                System.out.println(skladnik.name().substring(0, 1).repeat(10) + " " + "(" + skladnik.name() + ")");
            }
        } catch (RuntimeException e) {
            System.out.println("Nie mozna zrobic pizzy ");
        }
    }

    public static class Kelner {
        Kuchnia kuchnia = new Kuchnia();

        public static List<Skladnik> przyniesPizze(PizzaType rodziajPizzy) {
            return Kuchnia.zrobPizze(rodziajPizzy);
        }
    }

    public static class Kuchnia {
        static Map<Skladnik, Integer> spizarnia = new EnumMap<>(Skladnik.class);

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

        public static void pobieranieSkladnikow(Skladnik skladnik) {
            int ilosc = spizarnia.getOrDefault(skladnik, 0);
            if (ilosc > 0) {
                spizarnia.put(skladnik, ilosc - 1);
            } else {
                throw new RuntimeException("Brak skladnika: " + skladnik.name());
            }
        }


        public static List<Skladnik> zrobPizze(PizzaType rodzajPizzy) {
            List<Skladnik> skladniki = new ArrayList<>();

            switch (rodzajPizzy) {
                case pepperoni -> {
                    skladniki.add(Skladnik.ciasto);
                    skladniki.add(Skladnik.sos);
                    skladniki.add(Skladnik.ser);
                    skladniki.add(Skladnik.pieczarki);
                    skladniki.add(Skladnik.salami);
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



