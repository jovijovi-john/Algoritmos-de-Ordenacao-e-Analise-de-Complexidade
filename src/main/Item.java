package main;

public class Item <K, V> implements Comparable {
    private K chave;
    private V valor;

    public Item (K chave, V valor){
        this.chave = chave;
        this.valor = valor;
    }

    public <K> int comparar(K chave2) {
        return this.comparacao(this.chave, chave2);
    }

    public <K> int comparacao(K chave1, K chave2){

        if (chave1 instanceof Integer){
            return Integer.compare((Integer) chave1, (Integer) chave2);
        } else if (chave1 instanceof Double){
            return Double.compare((Double) chave1, (Double) chave2);
        } else {
            return ((String) chave1).compareTo((String) chave2);
        }
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public K getChave() {
        return chave;
    }

    @Override
    public String toString() {
        return
                "chave: " + chave +
                "    |    valor: " + valor;
    }
}
