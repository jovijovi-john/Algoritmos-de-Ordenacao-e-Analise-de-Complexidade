package ordenacoes;
import main.Item;

import java.util.Arrays;

public class QuickSort {

    static long comparacoes = 0;
    static long atribuicoes = 0;

    public static long[] sort(Item<?, ?>[] vetor, int inicio, int fim, int order){

        if (inicio < fim) {
            int posicao_pivo = particiona(vetor, inicio, fim, order);
            atribuicoes++;
            sort(vetor, inicio, posicao_pivo - 1, order);
            sort(vetor, posicao_pivo + 1, fim, order);
        }

        return new long[]{comparacoes, atribuicoes};
    }

    public static int particiona (Item<?, ?> [] vetor, int inicio, int fim, int order) {

        Item<?, ?> pivo = vetor[fim];
        int i = inicio;
        atribuicoes += 2;

        for (int j = inicio; j < fim; j++){
            if (order > 0){
                if (vetor[j].comparar(pivo.getChave()) <= 0){
                    Item<?, ?> temp = vetor[j];
                    vetor[j] = vetor[i];
                    vetor[i] = temp;
                    i++;
                    atribuicoes += 4;
                }
                comparacoes++;
            } else {

                if (vetor[j].comparar(pivo.getChave()) >= 0){
                    Item<?, ?> temp = vetor[j];
                    vetor[j] = vetor[i];
                    vetor[i] = temp;
                    i++;
                    atribuicoes += 4;
                }
                comparacoes++;
            }
        }

        Item<?, ?> temp2 = vetor[i];
        vetor[i] = vetor[fim];
        vetor[fim] = temp2;
        atribuicoes += 3;

        return i;
    }
}
