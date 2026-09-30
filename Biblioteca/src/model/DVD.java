package model;

public class DVD extends ItemBiblioteca implements Emprestavel {
    private Usuario emprestadoPara;

    public DVD(String codigo, String titulo) {
        super(codigo, titulo, true);
    }


    @Override
    public int prazo(){
        return 3;
    }

    @Override
    public double multaCentavos() {
        return 100;
    }

    @Override
    public boolean emprestar(Usuario usuario){
        if(!isDisponivel()){
            System.out.println("DVD " + getTitulo() +" indisponível para empréstimo.");
        return false;
        }
        marcarComoEmprestado();
        this.emprestadoPara = usuario;
        System.out.println("DVD "+ getTitulo()+ " emprestado para: " + usuario.getNome());
        return true;
    }

    @Override
    public boolean devolver() {
        if(isDisponivel()){
            System.out.println("DVD não estava emprestado.");
            return false;
        }
        marcarComoDisponive();
        this.emprestadoPara = null;
        System.out.println("DVD " + getTitulo() + " devolvido com sucesso.");
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
