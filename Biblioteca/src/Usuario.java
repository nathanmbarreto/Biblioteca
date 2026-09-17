
public abstract class Usuario {
    private final String nome;
    private int quantidadeEmprestada;

    public Usuario(String nome, int quantidadeEmprestada) {
        this.nome = nome;
        this.quantidadeEmprestada = 0;
    }

    public String getNome() {
        return nome;
    }

    public abstract int getLimiteItens();
}
