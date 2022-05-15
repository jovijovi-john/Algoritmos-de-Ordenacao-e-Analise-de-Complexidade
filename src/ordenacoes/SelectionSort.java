package ordenacoes;
import main.Item;

public class SelectionSort {

    static int comparacoes = 0;
    static int atribuicoes = 0;

    public static void sort (Item<?, ?>[] vetor, int order) {

        // order > 0     ===     Crescente
        // order < 0     ===     Decrescente
        long start = System.nanoTime();

        for (int i = 0; i < vetor.length; i++){
            int min = i; // minimo começando com a posição i
            atribuicoes++;
            for (int j = i + 1; j < vetor.length; j++){
                // como o minimo já é a primeira posição, podemos começar as verificações após ela
                // ou seja, com i + 1
                if (order > 0) { // verificando se a ordem escolhida é a crescente
                    if (vetor[min].comparar(vetor[j].getChave()) > 0) {
                        min = j;
                        atribuicoes++;
                    }
                } else { // se nao for, é a decrescente
                    if (vetor[min].comparar(vetor[j].getChave()) < 0){
                        min = j;
                        atribuicoes++;
                    }
                }
                comparacoes++;
            }

            // Colocando o menor na posição i atual
            Item<?, ?> tempMin = vetor[min];
            vetor[min] = vetor[i];
            vetor[i] = tempMin;
            atribuicoes += 3;
        }

        long end = System.nanoTime();

        System.out.println("Comparações: " + comparacoes);
        System.out.println("Atribuiçõees: " + atribuicoes);
        System.out.println("Tempo: " + (end - start));
    }
}
