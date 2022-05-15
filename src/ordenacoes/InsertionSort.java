package ordenacoes;

import main.Item;

public class InsertionSort {

    public static void sort(Item<?, ?>[] vetor, int order){

        for (int i = 1; i < vetor.length; i++){
            Item<?, ?> chave = vetor[i];
            int j = i - 1;

            if (order > 0) {
                while( j >= 0 && vetor[j].comparar(chave.getChave()) > 0){
                    vetor[j + 1] = vetor[j];
                    j--;
                }
            } else {
                while( j >= 0 && vetor[j].comparar(chave.getChave()) < 0){
                    vetor[j + 1] = vetor[j];
                    j--;
                }
            }
            vetor[j + 1] = chave;
        }
    }
}