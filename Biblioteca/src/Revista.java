public class Revista extends ItemBiblioteca implements Emprestavel {

    private final String autor;
    private Usuario emprestadoPara;

    public Revista(String codigo, String titulo, String autor) {
        super(codigo, titulo, true);
        this.autor = autor;
    }

    @Override
    public int prazo() {
        return 7; // revistas têm prazo menor
    }

    @Override
    public double multaCentavos() {
        return 100; // multa de 1 real por dia
    }

    @Override
    public boolean emprestar(Usuario usuario) {
        if (!isDisponivel()) {
            System.out.println("Revista já está emprestada.");
            return false;
        }
        marcarComoEmprestado();
        this.emprestadoPara = usuario;
        System.out.println("Revista \"" + getTitulo() + "\" emprestada para " + usuario.getNome());
        return true;
    }

    @Override
    public boolean devolver() {
        if (isDisponivel()) {
            System.out.println("Revista não estava emprestada.");
            return false;
        }
        marcarComoDisponive();
        this.emprestadoPara = null;
        System.out.println("Revista \"" + getTitulo() + "\" devolvida com sucesso.");
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
