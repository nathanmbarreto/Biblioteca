public class Livro extends ItemBiblioteca implements Emprestavel {

    private final String autor;
    private Usuario emprestadoPara;

    public Livro(String codigo, String titulo, String autor) {
        super(codigo, titulo, true);
        this.autor = autor;
    }

    @Override
    public int prazo() {
        return 14;
    }

    @Override
    public double multaCentavos() {
        return 50;
    }

    @Override
    public boolean emprestar(Usuario usuario) {
        if (!isDisponivel()) {
            System.out.println("Livro já emprestado");
            return false;
        }
        marcarComoEmprestado();
        this.emprestadoPara = usuario;
        System.out.println("Livro " + getTitulo() + " emprestado para " + usuario.getNome());
        return true;
    }

    @Override
    public boolean devolver() {
        if (isDisponivel()) {
            System.out.println("Livro não estava emprestado.");
            return false;
        }
        marcarComoDisponive();
        this.emprestadoPara = null;
        System.out.println("Livro \"" + getTitulo() + "\" devolvido com sucesso.");
        return true;
    }

    @Override
    public int getPrazoEmprestimoDias() {
        return prazo();
    }

    @Override
    public double getMultaPorDia() {
        return multaCentavos() / 100.0;
    }
}
