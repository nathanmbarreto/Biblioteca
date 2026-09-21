public class Professor extends Usuario{
    public Professor(String nome, String email) {
        super(nome, email);
    }

    @Override
    public int getLimiteItens(){return 5;}
}
