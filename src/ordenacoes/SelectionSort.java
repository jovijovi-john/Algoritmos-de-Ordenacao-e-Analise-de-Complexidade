package ordenacoes;
import main.Item;

public class SelectionSort {

    public static void sort (Item<?, ?>[] vetor, int order) {

        // order > 0     ===     Crescente
        // order < 0     ===     Decrescente

        for (int i = 0; i < vetor.length; i++){
            int min = i; // minimo começando com a posição i
            for (int j = i + 1; j < vetor.length; j++){
                // como o minimo já é a primeira posição, podemos começar as verificações após ela
                // ou seja, com i + 1
                if (order > 0) { // verificando se a ordem escolhida é a crescente
                    if (vetor[min].comparar(vetor[j].getChave()) > 0) {
                        min = j;
                    }
                } else { // se nao for, é a decrescente
                    if (vetor[min].comparar(vetor[j].getChave()) < 0){
                        min = j;
                    }
                }
            }

            // Colocando o menor na posição i atual
            Item<?, ?> tempMin = vetor[min];
            vetor[min] = vetor[i];
            vetor[i] = tempMin;
        }
    }
}
