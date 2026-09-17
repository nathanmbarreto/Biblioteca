public class Professor extends Usuario{
    public Professor(String nome, int quantidadeEmprestada) {
        super(nome, quantidadeEmprestada);
    }

    @Override
    public int getLimiteItens(){return 5;}
}
