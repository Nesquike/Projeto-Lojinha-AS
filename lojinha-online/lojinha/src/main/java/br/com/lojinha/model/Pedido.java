package br.com.lojinha.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido extends BaseEntity {
    public enum StatusPedido { PENDENTE, APROVADO, CANCELADO, ENTREGUE }
    
    private LocalDate data_pedido;
    private StatusPedido Status_pedido;
    private Cliente cliente;

    /** 
     * Construtor padrão utilizado para criar um pedido vazio que será populado depois.
     * O id será gerado pelo método gerarIdUnico.
     */
    public Pedido() {
        super();
    }

    /** 
     * Construtor completo utilizado para pedido não registrado.
     *  O ID será gerado automaticamente pelo método gerarIdUnico.
     */
    public Pedido(LocalDate data_pedido, StatusPedido Status_pedido, Cliente cliente) {
        super();
        setData(data_pedido);
        setStatus(Status_pedido);
        setCliente(cliente);
    }

    /** 
     * Construtor completo para pedido já registrado.
     */
    public Pedido(String id, LocalDate data_pedido, StatusPedido Status_pedido, Cliente cliente) {
        super(id);
        setData(data_pedido);
        setStatus(Status_pedido);
        setCliente(cliente);
    }

    /**
     * Getters e Setters.
     */
    public LocalDate getData() { return data_pedido; }
    public void setData(LocalDate data_pedido) {
        validarData(data_pedido);
        this.data_pedido = data_pedido;
    }

    public StatusPedido getStatus() { return Status_pedido; }
    public void setStatus(StatusPedido Status_pedido) { 
        validarStatus(Status_pedido);
        this.Status_pedido = Status_pedido; 
    }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) {
        validarCliente(cliente);
        this.cliente = cliente; 
    }

    /**
     * Métodos de validação simples.
     */

    private void validarData(LocalDate data_pedido) {
        if(data_pedido == null) {
            throw new IllegalArgumentException("O pedido deve possuir uma data.");
        }

        if(data_pedido.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("A data do pedido não pode ser no futuro.");
        }
    }

    private void validarStatus(StatusPedido Status_pedido) {
        if(Status_pedido == null) {
            throw new IllegalArgumentException("O status do pedido está inválido.");
        }
    }

    private void validarCliente(Cliente cliente) {
        if(cliente == null) {
            throw new IllegalArgumentException("O cliente do pedido não foi encontrado.");
        }
    }

    /**
     * Composição com ItemPedido.
     */
    private List<ItemPedido> itens = new ArrayList<>();

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    /**
     * Método para imprimir dados do pedido.
     */
    @Override
    public void mostrarDados() {
        System.out.println("=== PEDIDO ===");
        System.out.println("- ID do pedido:" + id);
        System.out.println("- Data do pedido:" + data_pedido);
        System.out.println("- Status do pedido:" + Status_pedido);
        System.out.println("- CPF do cliente:" + cliente.getCPF());
    }
}