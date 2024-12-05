package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main3 {


    public static void main(String[] args) {

        User user1 = new User("Jacek", User.TypUmowy.JDG, 45, User.Plec.mezczyzna);
        User user2 = new User("Jola", User.TypUmowy.UOP, 35, User.Plec.kobieta);
        User user3 = new User("Mateusz", User.TypUmowy.ZLECENIE, 18, User.Plec.mezczyzna);
        User user4 = new User("Ilona", User.TypUmowy.ZLECENIE, 25, User.Plec.kobieta);

        User[] users = {user1, user2, user3, user4};

        List<User> przypisaniUzytkownicy = metodaZwracania(users, 30, 40, User.TypUmowy.UOP, User.Plec.kobieta);

        przypisaniUzytkownicy.forEach(user ->
                System.out.println("Imie pracownika: " + user.imie + "\nWiek: " + user.wiek + "\nTyp umowy: " + user.umowa)
        );
    }

    public static class User {
        public String imie;
        public TypUmowy umowa;
        public int wiek;
        public Plec plec;

        enum TypUmowy {JDG, ZLECENIE, UOP}

        enum Plec {kobieta, mezczyzna}

        public User(String imie, TypUmowy umowa, int wiek, Plec plec) {
            this.imie = imie;
            this.umowa = umowa;
            this.wiek = wiek;
            this.plec = plec;
        }
    }

    public static List<User> metodaZwracania(User[] users, int wiekMin, int wiekMax, User.TypUmowy typUmowy, User.Plec plec) {

        return Arrays.stream(users)
                .filter(user -> user.wiek >= wiekMin && user.wiek <= wiekMax)
                .filter(user -> user.plec == plec)
                .filter(user -> user.umowa == typUmowy)
                .collect(Collectors.toList());

    }

}
