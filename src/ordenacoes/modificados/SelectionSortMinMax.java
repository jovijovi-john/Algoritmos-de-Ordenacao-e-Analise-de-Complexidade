package ordenacoes.modificados;

import main.Item;

public class SelectionSortMinMax {

    public static void sort(Item<?, ?>[] vetor, int order){

        for (int i = 0, j = vetor.length - 1; i < j; i++, j--){

            // j começa como ultima posição e vai iterando ate a metade do array
            // j começa como a primeira posição e vai iterando ate a metade do array
            // quando i for igual a j, quer dizer que ambos chegaram a metade do array
            // logo esse for tem complexidade n / 2

            Item<?, ?> min = vetor[i]; // minimo começa como o elemento i atual
            Item<?, ?> max = vetor[i]; // maximo também começa como o elemento i atual

            int min_i = i; // iniciando o indice do min
            int max_i = i; // iniciando o indice do max

            /* lembrando que como j está iterando do final do vetor ate o meio, e a cada iteração
             está sendo decrementado, a ultima posição do array irá guardar o maior elemento.
             Na segunda iteração, a penultima posição vai guardar o segundo maior, e assim vai.

             Logo, nao precisamos iterar ate a ultima posição sempre, haja vista que se o ultimo
             elemento já é o maior na segunda iteração, precisamos colocar o segundo maior na
             penultima posição. Alem disso, se ja sabemos que a ultima posicao tem o maior elemento,
             nao precisamos mais verificar se ele é o maior a cada iteração.
             */
            for (int k = i; k <= j; k++){
                if (order > 0) {
                    if (vetor[k].comparar(max.getChave()) > 0){ // se o elemento atual for maior que o maior elemento
                        max = vetor[k]; // maior elemento
                        max_i = k; // indice do maior elemento
                    } else if (vetor[k].comparar(min.getChave()) < 0) { // se o elemento atual for menor que o menor elemento
                        min = vetor[k]; // menor elemento
                        min_i = k; // indice do menor elemento
                    }
                } else {
                    if (vetor[k].comparar(max.getChave()) < 0){ // se o elemento atual for menor que o maior elemento
                        max = vetor[k]; // maior elemento
                        max_i = k; // indice do maior elemento
                    } else if (vetor[k].comparar(min.getChave()) > 0) { // se o elemento atual for maior que o menor elemento
                        min = vetor[k]; // menor elemento
                        min_i = k; // indice do menor elemento
                    }
                }
            }

            // colocando o menor elemento atual na posição i
            Item <?, ?> tempMin = vetor[min_i];
            vetor[min_i] = vetor[i];
            vetor[i] = tempMin;


            // Shifting the max. The equal condition
            // happens if we shifted the max to arr[min_i]
            // in the previous swap.

            // como já trocamos o menor com o i, a posição do menor agora ta guardando outro valor
            // se essa posição do menor já for nosso maior elemento, coloque ela na posição j
            if (vetor[min_i] == max) {
                Item<?, ?> temp = vetor[min_i];
                vetor[min_i] = vetor[j];
                vetor[j] = temp;
            } else {
                // se o maior não está na posição que era o minimo, entao coloca o maior na posição j
                Item<?, ?> tempMax = vetor[max_i];
                vetor[max_i] = vetor[j];
                vetor[j] = tempMax;
            }
        }
    }
}
