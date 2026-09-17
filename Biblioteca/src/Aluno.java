public class Aluno extends Usuario{
    public Aluno(String nome, int quantidadeEmprestada) {
        super(nome, quantidadeEmprestada);
    }

    @Override
    public int getLimiteItens(){ return 3;}
}
