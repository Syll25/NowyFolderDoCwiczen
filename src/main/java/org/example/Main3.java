package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main3 {


    public static void main(String[] args) {

        User user = new User("Jacek", User.TypUmowy.JDG, User.Wiek.sredni, User.Plec.mezczyzna);
        User user2 = new User("Jola", User.TypUmowy.UOP, User.Wiek.zaawansowany, User.Plec.kobieta);
        User user3 = new User("Mateusz", User.TypUmowy.ZLECENIE, User.Wiek.poczatkujacy, User.Plec.mezczyzna);

        User[] users = {user, user2, user3};

        List<User> przypisaniUzytkownicy = metodaZwracania(users);

        for (int i = 0; i < przypisaniUzytkownicy.size(); i++) {
            System.out.println("Pracownik o imieniu: " + przypisaniUzytkownicy.get(i).imie + ". Wiek: " + przypisaniUzytkownicy.get(i).wiek + ". Płeć: " + przypisaniUzytkownicy.get(i).plec);
        }
    }

    public static class User {
        public String imie;
        public TypUmowy umowa;
        public Wiek wiek;
        public Plec plec;

        enum TypUmowy {JDG, ZLECENIE, UOP}

        enum Wiek {
            poczatkujacy(18),
            sredni(40),
            zaawansowany(60);

            private int zakresWiekowy;

            Wiek(int zakresWiekowy) {
                this.zakresWiekowy = zakresWiekowy;
            }
        }

        enum Plec {kobieta, mezczyzna}

        public User(String imie, TypUmowy umowa, Wiek wiek, Plec plec) {
            this.imie = imie;
            this.umowa = umowa;
            this.wiek = wiek;
            this.plec = plec;
        }
    }

    public static List<User> metodaZwracania(User[] users) {
        List<User> finalni = new ArrayList<>();

        for (int i = 0; i < users.length; i++) {
            if (users[i].umowa == User.TypUmowy.UOP) {
                finalni.add(users[i]);
            }
        }
        return finalni;

    }

}
