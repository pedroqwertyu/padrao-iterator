interface IteratorPattern {
    boolean hasNext();
    Object next();
}

interface Iterado {
    IteratorPattern criarIterator();
}

class MeuIterator implements IteratorPattern {
    private String[] elementos;
    private int indice = 0;

    public MeuIterator(String[] elementos) {
        this.elementos = elementos;
    }

    @Override
    public boolean hasNext() {
        return indice < elementos.length;
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return elementos[indice++];
        }
        return null;
    }
}

class MinhaColecao implements Iterado {
    private String[] elementos;

    public MinhaColecao(String[] elementos) {
        this.elementos = elementos;
    }

    @Override
    public IteratorPattern criarIterator() {
        return new MeuIterator(elementos);
    }
}

public class App {
    public static void main(String[] args) {
        String[] dados = {"dados", "dados 1", "dados 2", "dados 3"};

        Iterado minhaColecao = new MinhaColecao(dados);

        IteratorPattern iterator = minhaColecao.criarIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}