
public abstract class Usuario {
    private final String nome;
    private String email;
    private int itensEmprestados;


    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.itensEmprestados = 0;
    }

    public String getNome() {
        return nome;
    }
    public String getEmail() {return email;}

    public abstract int getLimiteItens();

    public int getItensEmprestados() { return itensEmprestados; }

    public boolean podeEmprestar() {
        return itensEmprestados < getLimiteItens();
    }

    public void registrarEmprestimo() {
        itensEmprestados++;
    }

    public void registrarDevolucao() {
        if (itensEmprestados > 0) {
            itensEmprestados--;
        }
    }
}
