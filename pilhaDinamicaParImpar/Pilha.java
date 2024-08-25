package pilhaDinamicaParImpar;
public class Pilha {
    No topo;

    public Pilha() {
        this.topo = null;
    }public void empilhar(int dado) {
        No novoNo = new No(dado);
        novoNo.proximo = topo;
        topo = novoNo;
    }public int remover() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha está vazia");
        }
        int dado = topo.dado;
        topo = topo.proximo;
        return dado;
    }public boolean isEmpty() {
        return topo == null;
    }public void imprimirPilha() {
        No atual = topo;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }public int tamanho() {
        int tamanho = 0;
        No atual = topo;
        while (atual != null) {
            tamanho++;
            atual = atual.proximo;
        }
        return tamanho;
    }
}