package br.com.lojinha.model;

public class Produto extends BaseEntity {
    private String nome;
    private Double Preco_Venda;
    private Long Estoque_Qtd;

    /**
     * Construtor padrão utilizado para gerar um produto vazio que será populado depois.
     * O id será gerado pelo método gerarIdUnico.
     */
    public Produto() {
        super();
    }

    /**
     * Construtor completo para produto não registrado.
     * O id será gerado automaticamente pelo método gerarIdUnico.
     */
    public Produto(String nome, Double Preco_Venda, Long Estoque_Qtd) {
        super();
        setNome(nome);
        setPrecoVenda(Preco_Venda);
        setEstoqueQtd(Estoque_Qtd);
    }

    /**
     * Construtor completo para produto já registrado.
     */
    public Produto(String id, String nome, Double Preco_Venda, Long Estoque_Qtd) {
        super(id);
        setNome(nome);
        setPrecoVenda(Preco_Venda);
        setEstoqueQtd(Estoque_Qtd);
    }

    /**
     * Getters e Setters
     */
    public String getNome() { return nome; }
    public void setNome(String nome) {
        validarNome(nome);
        this.nome = nome;
    }

    public Double getPrecoVenda() { return Preco_Venda; }
    public void setPrecoVenda(Double Preco_Venda) {
        validarPrecoVenda(Preco_Venda);
        this.Preco_Venda = Preco_Venda;
    }

    public Long getEstoqueQtd() { return Estoque_Qtd; }
    public void setEstoqueQtd(Long Estoque_Qtd) {
        validarEstoqueQtd(Estoque_Qtd);
        this.Estoque_Qtd = Estoque_Qtd;
    }

    /**
     * Métodos de validação simples.
     */
    private void validarNome(String nome) {
        if(nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do produto não pode estar em branco.");
        }
    }

    private void validarPrecoVenda(Double Preco_Venda) {
        if(Preco_Venda == null || Preco_Venda <= 0) {
            throw new IllegalArgumentException("O Preco de venda está inválido.");
        }
    }

    private void validarEstoqueQtd(Long Estoque_Qtd) {
        if(Estoque_Qtd == null || Estoque_Qtd < 0) {
            throw new IllegalArgumentException("Quantidade em estoque inválida.");
        }
    }

    /**
     * Método para imprimir os dados do Produto.
     */
    @Override
    public void mostrarDados() {
        System.out.println("=== PRODUTO ===");
        System.out.println("- ID do produto:" + id);
        System.out.println("- Nome:" + nome);
        System.out.println("- Preço de venda:" + Preco_Venda);
        System.out.println("- Quantidade no Estoque:" + Estoque_Qtd);
    }
}