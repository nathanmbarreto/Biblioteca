public class Aluno extends Usuario{
    public Aluno(String nome, String email) {
        super(nome, email);
    }

    @Override
    public int getLimiteItens(){ return 3;}
}
