package br.com.lojinha.service;

import br.com.lojinha.payment.PagamentoGateway;
import br.com.lojinha.model.ItemPedido;
import br.com.lojinha.model.Pagamento;
import br.com.lojinha.model.Pedido;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Service responsável por gerenciar pagamentos.
 */
@Service
public class PagamentoService {
    private List<Pagamento> pagamentos = new ArrayList<>();

    /**
     * Retorna a lista completa de pagamentos.
     * @return lista de pagamentos registrados.
     */
    public List<Pagamento> listarPagamentos() {
        return pagamentos;
    }

    /**
     * Faz a solicitação do pagamento e define status através do Singleton
     * @param pedido Pedido a ser pago.
     * @param metodo_pg Método de pagamento utilizado.
     * @return O pagamento aprovado ou rejeitado, ambos com método de pagamento,
     * valor total do pedido, status e o pedido em si.
     */
    public Pagamento solicitarPagamento(Pedido pedido, Pagamento.MetodoPag metodo_pg) {
        Double valorTotal = 0.0;
        for(ItemPedido item : pedido.getItens()) {
            valorTotal += item.getPrecoVenda() * item.getQuantidade();
        }

        boolean aprovado = PagamentoGateway.getInstancia().processarPagamento(valorTotal);

        Pagamento.StatusPag status = aprovado ? Pagamento.StatusPag.APROVADO : Pagamento.StatusPag.RECUSADO;
        Pagamento pagamento = new Pagamento(metodo_pg, valorTotal, status, pedido);

        return pagamento;
    }

    /**
     * Processa o pagamento e define o status do Pedido como APROVADO.
     * @param pedido Pedido a ser aprovado.
     */
    public void processarCompra(Pedido pedido) {
        pedido.setStatus(Pedido.StatusPedido.APROVADO);
    }

    /**
     * Finaliza a entrega e define o status do Pedido como ENTREGUE.
     * @param pedido Pedido a ser entregue.
     */
    public void finalizarCompra(Pedido pedido) {
        pedido.setStatus(Pedido.StatusPedido.ENTREGUE);
    }
}