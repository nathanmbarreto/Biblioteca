public abstract class ItemBiblioteca {
    private final String codigo;

    private final String titulo;
    private boolean disponivel;

    public ItemBiblioteca(String codigo, String titulo, boolean disponivel) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Código é obrigatório.");
        }
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo é obrigatório.");
        }
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true;

    }

    public String getCodigo() {return codigo;}

    public String getTitulo() {return titulo;}


    public boolean isDisponivel() { return disponivel; }

    protected void marcarComoEmprestado() { this.disponivel = false; }

    protected void marcarComoDisponive() { this.disponivel = true; }

    public abstract int prazo();
    public abstract double multaCentavos();
}

