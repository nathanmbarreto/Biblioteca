//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca("Barreto Livrary");

        Livro cleanCode = new Livro("L001", "Clean Code", "Robert C. Martin");
        Livro refactoring = new Livro("L002", "Refactoring", "Martin Fowler");
        Livro domainDriven = new Livro("L003", "Domain-Driven Design", "Eric Evans");
        Livro effectiveJava = new Livro("L004", "Effective Java", "Joshua Bloch");


        biblioteca.cadastrarItem(cleanCode);
        biblioteca.cadastrarItem(refactoring);
        biblioteca.cadastrarItem(domainDriven);
        biblioteca.cadastrarItem(effectiveJava);

        Aluno ana = new Aluno("Ana", "ana@email.com");
        biblioteca.cadastrarUsuario(ana);


        System.out.println("--------------------- EMPRESTAR LIVROS---------------------");
        biblioteca.emprestar("L001", ana);
        biblioteca.emprestar("L002", ana);
        biblioteca.emprestar("L003", ana);
        biblioteca.emprestar("L004", ana);
        biblioteca.devolver("L001", ana);
        biblioteca.emprestar("L004", ana);

        System.out.println("--------------------- LISTAR ACERVO---------------------");
        biblioteca.listarAcervo();
    }
}