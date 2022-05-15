package ordenacoes;

import main.Item;

public class InsertionSort {

    static long comparacoes = 0;
    static long atribuicoes = 0;

    public static long[] sort(Item<?, ?>[] vetor, int order){
        //Percorrendo o vetor e guardando o valor da chave a cada iteração
        for (int i = 1; i < vetor.length; i++){
            Item<?, ?> chave = vetor[i];
            int j = i - 1;
            atribuicoes += 2;

            //Verificando se a ordem será crescente ou decrescente
            if (order > 0) {
                //loop que irá verificar se os elementos do vetor são maiores que o elemento chave
                while( j >= 0 && vetor[j].comparar(chave.getChave()) > 0){
                    vetor[j + 1] = vetor[j];
                    j--;
                    atribuicoes += 2;
                }
                comparacoes ++;
            } else {
                //loop que irá verificar se os elementos do vetor são menores que o elemento chave
                while( j >= 0 && vetor[j].comparar(chave.getChave()) < 0){
                    vetor[j + 1] = vetor[j];
                    j--;
                    atribuicoes += 2;
                }
                comparacoes ++;
            }
            //Definindo a chave na posição correta, onde todos os elementos < i sao menores que a chave e
            // todos até i sao maiores que a chave;
            vetor[j + 1] = chave;
            atribuicoes++;
        }

        return new long[]{ comparacoes, atribuicoes };
    }
}