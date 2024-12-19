package org.example;

public class AverageCalculator {

  public static void main(String[] args) {
    System.out.println("Średnia wynosi: " + calculateAverage(new int[]{2, 4, 6, 8, 10}) + " oczekiwana: " + 6.0);
    System.out.println("Średnia wynosi: " + calculateAverage(new int[]{1, 2}) + " oczekiwana: " + 1.5);
  }

  public static double calculateAverage(int[] array) {
    int srednia = 0;

    for (int i = 0; i <= array.length; i++) {
      srednia += i;
    }

    double wynik = srednia / array.length;

    return srednia;
  }
}
