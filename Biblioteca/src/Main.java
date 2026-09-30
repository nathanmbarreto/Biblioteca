import model.*;
import service.Biblioteca;


public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca("Barreto Library");

        Livro cleanCode = new Livro("L001", "Clean Code", "Robert C. Martin");
        Livro refactoring = new Livro("L002", "Refactoring", "Martin Fowler");
        Livro domainDriven = new Livro("L003", "Domain-Driven Design", "Eric Evans");
        Livro effectiveJava = new Livro("L004", "Effective Java", "Joshua Bloch");
        Revista darkKnight = new Revista("R001", "O cavaleiros das Trevas", "Frank Miller");

        biblioteca.cadastrarItem(cleanCode);
        biblioteca.cadastrarItem(refactoring);
        biblioteca.cadastrarItem(domainDriven);
        biblioteca.cadastrarItem(effectiveJava);
        biblioteca.cadastrarItem(darkKnight);

        Aluno ana = new Aluno("Ana", "ana@email.com");
        biblioteca.cadastrarUsuario(ana);
        Professor jorge = new Professor("Jorge", "professorjorge@email.com");


        System.out.println("--------------------- EMPRESTAR LIVROS---------------------");
        biblioteca.emprestar("L001", ana);
        biblioteca.emprestar("L001", ana);
        biblioteca.emprestar("L002", ana);
        biblioteca.emprestar("L003", ana);
        biblioteca.emprestar("R001", jorge);
        biblioteca.emprestar("L004", ana);
        biblioteca.devolver("L001", ana, 16);
        biblioteca.devolver("L001", ana, 16);
        biblioteca.emprestar("L004", ana);
        biblioteca.devolver("R001", jorge, 8);



//        System.out.println("--------------------- TESTE DVD---------------------");
//        model.DVD cronicasDeNarnia= new model.DVD("D001", "As crônicas de Nárnia");
//        biblioteca.cadastrarItem(cronicasDeNarnia);
//        biblioteca.emprestar("D001", jorge);
//        biblioteca.devolver("D001", jorge, 5);


        System.out.println("--------------------- LISTAR ACERVO---------------------");
        biblioteca.listarAcervo();

    }
}