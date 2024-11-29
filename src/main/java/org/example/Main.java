package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[] tablicaJednowymiarowa = {2, 3, 4};
        List<Integer> wynik = naszaMetoda(tablicaJednowymiarowa);

        System.out.println("Liczby parzyste dla jednowymiarowej tablicy: ");
        for (int i = 0; i < wynik.size(); i++) {
            System.out.println(wynik.get(i));
        }

        int sumaJednowymiarowa = sumaParzystychJednowymiarowej(tablicaJednowymiarowa);
        System.out.println("Suma liczb parzystych dla tablicy jednowymiarowej: " + sumaJednowymiarowa);

        int[][][][] tablicaCzterowymiarowa = {
                {{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}},
                {{{9, 10}, {11, 12}}, {{13, 14}, {15, 16}}}
        };
        List<Integer> wynikDlaCztero = naszaMetodaCzterowTablicy(tablicaCzterowymiarowa);

        int sumaCzterowymiarowa = sumaParzystychCzterowymiarowej(tablicaCzterowymiarowa);
        System.out.println("Suma liczb parzystych dla tablicy czterowymiarowe: " + sumaCzterowymiarowa);

        int [][][][][][][] tablicaSiedmiowymiarowa = {
                {
                        {{{{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}}},
                                {{{{9, 10}, {11, 12}}, {{13, 14}, {15, 16}}}}}
                },
                {
                        {{{{{17, 18}, {19, 20}}, {{21, 22}, {23, 24}}}},
                                {{{{25, 26}, {27, 28}}, {{29, 30}, {31, 32}}}}}
                }
        };
        List<Integer> wynikDlaSiedmio = naszaMetodaSiedmioTablicy(tablicaSiedmiowymiarowa);

        int sumaSiedmiowymiarowa = sumaParzystychSiedmiowymiarowej(tablicaSiedmiowymiarowa);
        System.out.println("Suma liczb parzystych dla tablicy siedmiowymiarowej: " + sumaSiedmiowymiarowa);

        System.out.println("Liczby parzyste dla czterowymiarowej tablicy: ");
        for (int i = 0; i < wynikDlaCztero.size(); i++) {
            System.out.println(wynikDlaCztero.get(i));
        }

        System.out.println("Liczby parzyste dla siedmiowymiarowej tablicy: ");
        for (int i = 0; i < wynikDlaSiedmio.size(); i++) {
            System.out.println(wynikDlaSiedmio.get(i));
        }
    }

    public static List<Integer> naszaMetoda(int[] tablica) {
        List<Integer> name = new ArrayList<>();

        for (int i = 0; i < tablica.length; i++) {
            if (czyParzysta(tablica[i])) {
                name.add(tablica[i]);
            }
        }
        return name;
    }

    public static boolean czyParzysta(int pojed) {
        if (pojed % 2 != 0) {
            return false;
        } else return true;
    }
    //    public static boolean czyParzysta(int pojed) {
    //    return pojed % 2 == 0;
    //}

    public static List<Integer> naszaMetodaCzterowTablicy(int[][][][] czteroTablica) {
        List<Integer> nameCzterowymiarowe = new ArrayList<>();

        for (int i = 0; i < czteroTablica.length; i++) {
            for (int j = 0; j < czteroTablica[i].length; j++) {
                for (int k = 0; k < czteroTablica[i][j].length; k++) {
                    for (int l = 0; l < czteroTablica[i][j][k].length; l++) {
                        if (czyParzysta(czteroTablica[i][j][k][l])) {
                            nameCzterowymiarowe.add(czteroTablica[i][j][k][l]);
                        }
                    }
                }
            }
        }
        return nameCzterowymiarowe;
    }

    public static List<Integer> naszaMetodaSiedmioTablicy(int[][][][][][][] siedmioTablica) {
        List<Integer> nameSiedmiowymiarowe = new ArrayList<>();

        for (int i = 0; i < siedmioTablica.length; i++) {
            for (int j = 0; j < siedmioTablica[i].length; j++) {
                for (int k = 0; k < siedmioTablica[i][j].length; k++) {
                    for (int l = 0; l < siedmioTablica[i][j][k].length; l++) {
                        for (int m = 0; m < siedmioTablica[i][j][k][l].length; m++) {
                            for (int n = 0; n < siedmioTablica[i][j][k][l][m].length; n++) {
                                for (int o = 0; o < siedmioTablica[i][j][k][l][m][n].length; o++) {
                                    if (czyParzysta(siedmioTablica[i][j][k][l][m][n][o])) {
                                        nameSiedmiowymiarowe.add(siedmioTablica[i][j][k][l][m][n][o]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return nameSiedmiowymiarowe;
    }

    public static int sumaParzystychJednowymiarowej(int[] tablica) {
        int suma = 0;

        for (int i = 0; i < tablica.length; i++) {
            if (czyParzysta(tablica[i])) {
                suma += tablica[i];
            }
        }
        return suma;
    }

    public static int sumaParzystychCzterowymiarowej(int[][][][] czteroTablica) {
        int suma = 0;

        for (int i = 0; i < czteroTablica.length; i++) {
            for (int j = 0; j < czteroTablica[i].length; j++) {
                for (int k = 0; k < czteroTablica[i][j].length; k++) {
                    for (int l = 0; l < czteroTablica[i][j][k].length; l++) {
                        if (czyParzysta(czteroTablica[i][j][k][l])) {
                            suma += czteroTablica[i][j][k][l];
                        }
                    }
                }
            }
        }
        return suma;
    }

    public static int sumaParzystychSiedmiowymiarowej(int[][][][][][][] siedmioTablica) {
        int suma = 0;

        for (int i = 0; i < siedmioTablica.length; i++) {
            for (int j = 0; j < siedmioTablica[i].length; j++) {
                for (int k = 0; k < siedmioTablica[i][j].length; k++) {
                    for (int l = 0; l < siedmioTablica[i][j][k].length; l++) {
                        for (int m = 0; m < siedmioTablica[i][j][k][l].length; m++) {
                            for (int n = 0; n < siedmioTablica[i][j][k][l][m].length; n++) {
                                for (int o = 0; o < siedmioTablica[i][j][k][l][m][n].length; o++) {
                                    if (czyParzysta(siedmioTablica[i][j][k][l][m][n][o])) {
                                        suma += siedmioTablica[i][j][k][l][m][n][o];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return suma;
    }
}



