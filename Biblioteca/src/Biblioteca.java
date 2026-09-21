public class Biblioteca {
    private final String nome;

    private final ItemBiblioteca[] item;
    private int totalItens;

    private final Usuario[] usuarios;
    private int totalUsuarios;

    public Biblioteca(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Biblioteca precisa ser nomeada");
        }
        this.nome = nome;
        this.item = new ItemBiblioteca[Config.CAPACIDADE_ITENS];
        this.totalItens = 0;
        this.usuarios = new Usuario[Config.CAPACIDADE_USUARIOS];
        this.totalUsuarios = 0;
    }


    public void cadastrarItem(ItemBiblioteca novoItem) {
        if (novoItem == null) {
            throw new IllegalArgumentException("Item não pode ser null.");
        }
        if (totalItens >= item.length) {
            throw new IllegalStateException("Capacidade maxima atingida.");
        }
        item[totalItens] = novoItem;
        totalItens++;
    }

    public void cadastrarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario não pode ser null.");
        }
        if (totalUsuarios >= usuarios.length) {
            throw new IllegalStateException("Máximo de usuários permitidos.");
        }
        usuarios[totalUsuarios] = usuario;
        totalUsuarios++;
    }

    public ItemBiblioteca buscarItemPorCodigo(String codigo) {
        for (int i = 0; i < totalItens; i++) {
            if (item[i].getCodigo().equals(codigo)) {   // equals, nunca ==
                return item[i];
            }
        }
        return null;
    }

    public boolean emprestar(String codigoItem, Usuario usuario) {
        ItemBiblioteca item = buscarItemPorCodigo(codigoItem);

        if (item == null) {
            System.out.println("ERRO! Item não encontrado: " + codigoItem);
            return false;
        }
        if (usuario == null) {
            System.out.println("ERRO! Usuário inválido.");
            return false;
        }

        if (!usuario.podeEmprestar()) {
            System.out.println("Usuário " + usuario.getNome() + " já atingiu o limite de empréstimos.");
            return false;
        }

        if (item instanceof Emprestavel emprestavel) {
            if (emprestavel.emprestar(usuario)) {
                usuario.registrarEmprestimo();
                return true;
            }
        }

        System.out.println("Item \"" + item.getTitulo() + "\" não pode ser emprestado (consulta local).");
        return false;
    }


    public boolean devolver(String codigoItem, Usuario usuario) {
        ItemBiblioteca item = buscarItemPorCodigo(codigoItem);

        if (item == null) {
            System.out.println("ERRO! Item não encontrado: " + codigoItem);
            return false;
        }

        if (item instanceof Emprestavel emprestavel) {
            if (emprestavel.devolver()) {
                usuario.registrarDevolucao();
                return true;
            }
        }

        return false;
    }

    public void listarAcervo() {
        System.out.println("Itens cadastrados: (" + totalItens + ") itens");
        for (int i = 0; i < totalItens; i++) {
            ItemBiblioteca listarItem = item[i];
            System.out.println(listarItem.getTitulo());
        }

    }


}
