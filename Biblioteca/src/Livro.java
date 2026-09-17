public class Livro extends ItemBiblioteca{

    private final String autor;

    public Livro(String codigo, String titulo, boolean disponivel, String autor) {
        super(codigo, titulo, true);
        this.autor = autor;
    }
    @Override
    public int prazo(){return 14;}

    @Override
    public double multaCentavos(){return 50;}
}
