public interface Emprestavel {

    boolean emprestar(Usuario usuario);
    boolean devolver();
    int getPrazoEmprestimoDias();
    double getMultaPorDia();

}
