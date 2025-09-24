public class PilhaInt {
    public int[] elementos;
    public Integer tamanho;

    public PilhaInt(int capacidade) {
        this.elementos = new int [capacidade];
        this.tamanho = 0;
    }

    public int tamanho(){
        return  this.tamanho;
    }

    public boolean estaVazia(){
        return this.tamanho == 0;
    }

    public boolean estaCheia(){
        return tamanho == elementos.length;
    }

    public boolean empilhar(int elemento){
        if (!estaCheia()){
            this.elementos[this.tamanho] = elemento;
            tamanho++;
            return true;
        }
        return false;
    }

    public void listar(){
        for (int i = 0; i < tamanho; i++){
            System.out.println(elementos[i]);
        }
    }

    public Integer desempilhar(){
        if (!estaVazia()){
            tamanho--;
            return elementos[tamanho];
        }return null;

    }

    public Integer espiar() {
        if (!estaVazia()) {
            return elementos[tamanho - 1];
        }return null;
    }
}
