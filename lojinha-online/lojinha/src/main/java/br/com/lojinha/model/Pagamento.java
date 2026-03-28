package br.com.lojinha.model;

public class Pagamento extends BaseEntity {
    public enum StatusPag { APROVADO, RECUSADO }
    public enum MetodoPag { CARTAO_CREDITO, CARTAO_DEBITO, PIX, BOLETO}

    private MetodoPag metodo_pg;
    private StatusPag status_pg;
    private Double valor_total;
    private Pedido pedido;

    /**
     * Construtor padrão utilizado para gerar um pagamento vazio que será populado depois.
     * O id será gerado pelo método gerarIdUnico.
     */
    public Pagamento() {
        super();
    }

    /**
     * Construtor completo utilizado para pagamento não registrado.
     * O id será gerado automaticamente pelo método gerarIdUnico.
     */
    public Pagamento(MetodoPag metodo_pg, Double valor_total, StatusPag status_pg, Pedido pedido) {
        super();
        setMetodoPag(metodo_pg);
        setValorTotal(valor_total);
        setStatusPag(status_pg);
        setPedido(pedido);
    }

    /**
     * Construtor completo para pagamento já registrado.
     */
    public Pagamento(String id, MetodoPag metodo_pg, Double valor_total, StatusPag status_pg, Pedido pedido) {
        super(id);
        setMetodoPag(metodo_pg);
        setValorTotal(valor_total);
        setStatusPag(status_pg);
        setPedido(pedido);
    }

    /**
     * Getters e Setters.
     */
    public MetodoPag getMetodoPag() { return metodo_pg; }
    public void setMetodoPag(MetodoPag metodo_pg) {
        validarMetodoPag(metodo_pg);
        this.metodo_pg = metodo_pg;
    }

    public Double getValorTotal() { return valor_total; }
    public void setValorTotal(Double valor_total) {
        validarValorTotal(valor_total);
        this.valor_total = valor_total;
    }

    public StatusPag getStatusPag() { return status_pg; }
    public void setStatusPag(StatusPag status_pg) {
        validarStatusPag(status_pg);
        this.status_pg = status_pg;
    }

    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido pedido) {
        validarPedido(pedido);
        this.pedido = pedido;
    }

    /**
     * Métodos de validação simples.
     */
    private void validarMetodoPag(MetodoPag metodo_pg) {
        if(metodo_pg == null) {
            throw new IllegalArgumentException("Selecione um método de pagamento.");
        }
    }

    private void validarValorTotal(Double valor_total) {
        if(valor_total == null || valor_total <= 0) {
            throw new IllegalArgumentException("Valor total inválido.");
        }
    }

    private void validarStatusPag(StatusPag status_pg) {
        if(status_pg == null) {
            throw new IllegalArgumentException("O status está inválido.");
        }
    }

    private void validarPedido(Pedido pedido) {
        if(pedido == null) {
            throw new IllegalArgumentException("Pedido não encontrado.");
        }
    }

    /**
     * Método para imprimir dados do pagamento.
     */
    @Override
    public void mostrarDados() {
        System.out.println("=== PAGAMENTO ===");
        System.out.println("- ID do pagamento:" + id);
        System.out.println("- ID do pedido:" + pedido.getId());
        System.out.println("- Método de pagamento:" + metodo_pg);
        System.out.println("- Valor total:" + valor_total);
        System.out.println("- Status do pagamento:" + status_pg);
    }
}