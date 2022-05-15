package main;
import java.util.Arrays;
import java.util.Random;

import generators.AlphaNumericStringGenerator;
import ordenacoes.*;
import ordenacoes.modificados.MergeSortInsertion;
import ordenacoes.modificados.SelectionSortMinMax;


public class Main {

    public static void main (String [] args) {

        Random random = new Random();

        /* -------------------------------------------------------------------------------
        //key: String, value: Double


        Item<String, Double > [] vetorGenerics = new Item[100];
        for (int i = 0; i < vetorGenerics.length; i++){
            String chave = AlphaNumericStringGenerator.generateRandomString(10);
            Double valor = random.nextDouble() * 100;
            vetorGenerics[i] = new Item<>(chave, valor);
        }

        QuickSort.sort(vetorGenerics, 0, vetorGenerics.length - 1, -1);

        for (int j = 0; j < vetorGenerics.length; j++){
            System.out.println(vetorGenerics[j].toString());
        }
        //*/

        /* ---------------------------------------------------------------------------------
        // key: Double, value: String

        Item<Double, String > [] vetorGenerics = new Item[100];
        for (int i = 0; i < vetorGenerics.length; i++){
            Double chave = random.nextDouble() * 100;
            String valor = AlphaNumericStringGenerator.generateRandomString(10);
            vetorGenerics[i] = new Item<>(chave, valor);
        }

        QuickSort.sort(vetorGenerics, 0, vetorGenerics.length -1, -1);

        for (int j = 0; j < vetorGenerics.length; j++){
            System.out.println(vetorGenerics[j].toString());
        }
        */

        /* key: Double, value: Integer -------------------------------------------------------------

        Item<Double, Integer> [] vetorGenerics = new Item[100];

        for (int i = 0; i < vetorGenerics.length; i++){
            Double chave = random.nextDouble() * 100;
            Integer valor = random.nextInt(100);
            vetorGenerics[i] = new Item<>(chave, valor);
        }
        QuickSort.sort(vetorGenerics, 0, vetorGenerics.length -1, -1);

        for (int j = 0; j < vetorGenerics.length; j++){
            System.out.println(vetorGenerics[j].toString());
        }

        */

    }
}
