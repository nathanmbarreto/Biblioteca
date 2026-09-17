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
}
