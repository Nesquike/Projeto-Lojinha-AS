package br.com.lojinha.model;

public class ItemPedido extends BaseEntity {
    private Long Quantidade;
    private Double Preco_venda;
    private Pedido pedido;
    private Produto produto;

    /**
     * Construtor padrão que será utilizado quando os dados forem preenchidos pelos setters.
     * O id será gerado pelo método gerarIdUnico.
     */
    public ItemPedido() {
        super();
    }

    /**
     * Construtor completo utilizado para criar a relação com os dados já definidos.
     * O id será gerado automaticamente pelo método gerarIdUnico.
     */
    public ItemPedido(Long Quantidade, Double Preco_venda, Pedido pedido, Produto produto) {
        super();
        setQuantidade(Quantidade);
        setPrecoVenda(Preco_venda);
        setPedido(pedido);
        setProduto(produto);
    }

    /**
     * Getters e Setters
     */
    public Long getQuantidade() { return Quantidade; }
    public void setQuantidade(Long Quantidade) {
        validarQuantidade(Quantidade);
        this.Quantidade = Quantidade;
    }

    public Double getPrecoVenda() { return Preco_venda; }
    public void setPrecoVenda(Double Preco_venda) {
        validarPrecoVenda(Preco_venda);
        this.Preco_venda = Preco_venda;
    }

    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido pedido) {
        validarPedido(pedido);
        this.pedido = pedido;
    }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) {
        validarProduto(produto);
        this.produto = produto;
    }

    /**
     * Métodos de validação simples.
     */
    private void validarQuantidade(Long Quantidade) {
        if(Quantidade == null || Quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade não pode ser nula ou negativa.");
        }
    }

    private void validarPrecoVenda(Double Preco_venda) {
        if(Preco_venda == null || Preco_venda <= 0) {
            throw new IllegalArgumentException("Preço de venda não pode ser nulo ou negativo.");
        }
    }

    private void validarPedido(Pedido pedido) {
        if(pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo.");
        }
    }

    private void validarProduto(Produto produto) {
        if(produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo.");
        }
    }
    
    /**
     * Método para imprimir os dados do ItemPedido.
     */
    @Override
    public void mostrarDados() {
        System.out.println("=== ITEM DE PEDIDO ===");
        System.out.println("- ID do pedido:" + pedido.getId());
        System.out.println("- ID do produto:" + produto.getId());
        System.out.println("- Quantidade:" + Quantidade);
        System.out.println("- Preço de venda:" + Preco_venda);
    }
}