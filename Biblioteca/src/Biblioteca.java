public class Biblioteca {
    private final String nome;

    private final ItemBiblioteca[] item;
    private int totalItens;

    private final Usuario[] usuarios;
    private int totalUsuarios;

    public Biblioteca(String nome, ItemBiblioteca[] item, int totalItens, Usuario[] usuarios, int totalUsuarios) {
        if(nome == null || nome.isBlank()){
            throw new IllegalArgumentException("Biblioteca precisa ser nomeada");
        }
        this.nome = nome;
        this.item = new ItemBiblioteca[Config.CAPACIDADE_ITENS];
        this.totalItens = 0;
        this.usuarios = new Usuario[Config.CAPACIDADE_USUARIOS];
        this.totalUsuarios = 0;
    }

    public void cadastrarItem(ItemBiblioteca novoItem){
        if(novoItem == null){
            throw new IllegalArgumentException("Item não pode ser null.");
        }
        if(totalItens >= item.length){
            throw new IllegalStateException("Capacidade maxima atingida.");
        }
        item[totalItens] = novoItem;
        totalItens++;
    }

    public void cadastrarUsuario(Usuario usuario){
        if(usuario == null){
            throw new IllegalArgumentException("Usuario não pode ser null.");
        }
        if(totalUsuarios >= usuarios.length){
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

    public boolean emprestar(String codigoItem, Usuario usuario){
        ItemBiblioteca item = buscarItemPorCodigo(codigoItem);

        if(item == null){
            System.out.println("ERRO! Item não encontrado: " + codigoItem);
        }
        if(usuario == null){
            System.out.println("ERRO! Usuario não encontrado: " + codigoItem);
        }

    item.marcarComoEmprestado();
        System.out.println("Item "+item.getTitulo() + "emrprestado para: "+ usuario.getNome());
        return true;
    }


    public boolean devolver(String codigoItem){
        ItemBiblioteca item = buscarItemPorCodigo(codigoItem);

        item.marcarComoDisponive();
        System.out.println(item.getTitulo() + "devolvido com sucesso.");
        return true;
    }

}
