package ordenacoes;
import main.Item;

import java.util.Arrays;

public class HeapSort {

    public static void maxHeap(Item<?, ?>[] vetor, int tamanho, int order) {
        for (int i = tamanho / 2 - 1; i >= 0; i--) {
            aplicarHeap(vetor, tamanho, i, order);
        }
    }

    public static Item<?, ?>[] sort(Item<?, ?>[] vetor, int order) {
        int tamanho = vetor.length;
        maxHeap(vetor, tamanho, order);

        for (int j = tamanho - 1; j > 0; j--) {
            // trocando a primeira com a ultima posição do vetor
            Item<?, ?> aux = vetor[0];
            vetor[0] = vetor[j];
            vetor[j] = aux;
            aplicarHeap(vetor, j, 0, order);
        }

        return vetor;
    }

    public static void aplicarHeap(Item<?, ?> [] vetor, int tamanho_vetor, int i, int order){
        int raiz = i;
        int esquerda = (2 * i) + 1;
        int direita = (2 * i) + 2;

        if (order > 0) {
            if (esquerda < tamanho_vetor && vetor[esquerda].comparar(vetor[raiz].getChave()) > 0) {
                raiz = esquerda;
            }
            if (direita < tamanho_vetor && vetor[direita].comparar(vetor[raiz].getChave()) > 0){
                raiz = direita;
            }
        } else {
            if (esquerda < tamanho_vetor && vetor[esquerda].comparar(vetor[raiz].getChave()) < 0) {
                raiz = esquerda;
            }
            if (direita < tamanho_vetor && vetor[direita].comparar(vetor[raiz].getChave()) < 0){
                raiz = direita;
            }
        }

        if (raiz != i) {
            Item<?, ?> aux = vetor[i];
            vetor[i] = vetor[raiz];
            vetor[raiz] = aux;

            aplicarHeap(vetor, tamanho_vetor, raiz, order);
        }
    }
}
