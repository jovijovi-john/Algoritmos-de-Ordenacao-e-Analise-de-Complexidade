package ordenacoes;

import main.Item;

public class MergeSort {

    public static void sort(Item<?, ?>[] vetor, int ordem){
        Item<?, ?> [] auxiliar = new Item<?, ?> [vetor.length];
        mergeSort(vetor, auxiliar, 0, vetor.length - 1, ordem);
    }

    public static void mergeSort(Item<?, ?>[] vetor, Item<?, ?>[] vetor_aux, int inicio, int fim, int ordem){
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(vetor, vetor_aux, inicio, meio, ordem);
            mergeSort(vetor, vetor_aux, meio + 1, fim, ordem);
            Merge(vetor, vetor_aux, inicio, meio, fim, ordem);
        }
    }
    public static void Merge(Item<?, ?>[] vetor, Item<?, ?>[] vetor_aux, int inicio, int meio, int fim, int ordem){

//    Copiando os elementos de vetor para o auxiliar
        for (int k = inicio; k <= fim; k++){
            vetor_aux[k] = vetor[k];
        }

        int i = inicio;
        int j = meio + 1;

        for (int l = inicio; l <= fim; l++){
//          Se a pilha da esquerda não tem mais elementos menores,
//          copia tudo da direita, joga no vetor, depois disso joga os da esquerda
            if (i > meio) {
//                recebendo os elementos da direita do vetor,
//                uma vez que todos eles são menores que os elementos da esquerda.
                vetor[l] = vetor_aux[j++];
            } else if (j > fim) {
//              Se a pilha da direita não tem elementos menores que a da esquerda
//              copia tudo da esquerda, joga no vetor, e depois joga os da esquerda
                vetor[l] = vetor_aux[i++];
            } else if ((vetor_aux[i].comparar(vetor_aux[j].getChave()) < 0) && ordem > 0) {
//              Se o top da pilha da esquerda for menor que a da direita,
//              o vetor receberá esse elemento
                vetor[l] = vetor_aux[i++];
            } else if ((vetor_aux[i].comparar(vetor_aux[j].getChave()) > 0) && ordem <= 0) {
//              Se o top da pilha da esquerda for menor que a da direita,
//              o vetor receberá esse elemento
                vetor[l] = vetor_aux[i++];
            } else {
//              Se o topo da pilha da direita for menor que a esquerda
//              o vetor receberá esse elemento
                vetor[l] = vetor_aux[j++];
            }
        }
    }
}

