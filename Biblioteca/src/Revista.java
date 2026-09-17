public class Revista extends ItemBiblioteca{

    public final String autor;

    public Revista(String codigo, String titulo, boolean disponivel, String autor) {
        super(codigo, titulo, true);
        this.autor = autor;
    }

    @Override
    public int prazo(){return 7;}

    @Override
    public double multaCentavos(){return 100;}
}
