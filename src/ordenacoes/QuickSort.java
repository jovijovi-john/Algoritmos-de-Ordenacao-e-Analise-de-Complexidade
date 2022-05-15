package ordenacoes;
import main.Item;

import java.util.Arrays;

public class QuickSort {
    public static Item<?, ?> [] sort(Item<?, ?>[] vetor, int inicio, int fim, int order){

        if (inicio < fim) {
            int posicao_pivo = particiona(vetor, inicio, fim, order);
            sort(vetor, inicio, posicao_pivo - 1, order);
            sort(vetor, posicao_pivo + 1, fim, order);
        }

        return vetor;
    }

    public static int particiona (Item<?, ?> [] vetor, int inicio, int fim, int order) {

        Item<?, ?> pivo = vetor[fim];
        int i = inicio;

        for (int j = inicio; j < fim; j++){
            if (order > 0){
                if (vetor[j].comparar(pivo.getChave()) <= 0){
                    Item<?, ?> temp = vetor[j];
                    vetor[j] = vetor[i];
                    vetor[i] = temp;
                    i++;
                }
            } else {

                if (vetor[j].comparar(pivo.getChave()) >= 0){
                    Item<?, ?> temp = vetor[j];
                    vetor[j] = vetor[i];
                    vetor[i] = temp;
                    i++;
                }
            }
        }

        Item<?, ?> temp2 = vetor[i];
        vetor[i] = vetor[fim];
        vetor[fim] = temp2;

        return i;
    }
}
