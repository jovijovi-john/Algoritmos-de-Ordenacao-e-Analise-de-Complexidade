package ordenacoes;
import main.Item;

import java.util.Arrays;

public class HeapSort {

    static long comparacoes = 0;
    static long atribuicoes = 0;

    public static void maxHeap(Item<?, ?>[] vetor, int tamanho, int order) {
        for (int i = tamanho / 2 - 1; i >= 0; i--) {
            aplicarHeap(vetor, tamanho, i, order);
        }
    }

    public static Item<?, ?>[] sort(Item<?, ?>[] vetor, int order) {

        long start = System.nanoTime();

        int tamanho = vetor.length;
        atribuicoes++;

        maxHeap(vetor, tamanho, order);

        for (int j = tamanho - 1; j > 0; j--) {
            // trocando a primeira com a ultima posição do vetor
            Item<?, ?> aux = vetor[0];
            vetor[0] = vetor[j];
            vetor[j] = aux;

            atribuicoes += 3;

            aplicarHeap(vetor, j, 0, order);
        }
        long end = System.nanoTime();
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Atribuições: " + atribuicoes);
        System.out.println("Tempo: " + (end - start));



        return vetor;
    }

    public static void aplicarHeap(Item<?, ?> [] vetor, int tamanho_vetor, int i, int order){
        //Fazendo com que o vetor se adeque à propriedade do MaxHeap ou do MinHeap
        int raiz = i;
        int esquerda = (2 * i) + 1;
        int direita = (2 * i) + 2;

        //Verificando se a ordem será a crescente ou a decrescente
        if (order > 0) {
            //Verificando se os elementos filhos são maiores que o elemento pai

            if (esquerda < tamanho_vetor && vetor[esquerda].comparar(vetor[raiz].getChave()) > 0) {
                raiz = esquerda;
                atribuicoes++;
            }
            if (direita < tamanho_vetor && vetor[direita].comparar(vetor[raiz].getChave()) > 0){
                raiz = direita;
                atribuicoes++;
            }

            comparacoes += 2;
        } else {
            //Verificando se os elementos filhos são menores que o elemento pai

            if (esquerda < tamanho_vetor && vetor[esquerda].comparar(vetor[raiz].getChave()) < 0) {
                raiz = esquerda;
                atribuicoes++;
            }
            if (direita < tamanho_vetor && vetor[direita].comparar(vetor[raiz].getChave()) < 0){
                raiz = direita;
                atribuicoes++;
            }

            comparacoes += 2;
        }

        //Realizando a troca entre a raiz e seu elemento filho, se necessário
        if (raiz != i) {
            Item<?, ?> aux = vetor[i];
            vetor[i] = vetor[raiz];
            vetor[raiz] = aux;

            atribuicoes++;

            aplicarHeap(vetor, tamanho_vetor, raiz, order);
        }
        comparacoes++;
    }
}
