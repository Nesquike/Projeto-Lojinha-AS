package br.com.lojinha.controller;

import br.com.lojinha.model.Pagamento;
import br.com.lojinha.model.Pedido;
import br.com.lojinha.model.Pagamento.MetodoPag;
import br.com.lojinha.service.PagamentoService;
import br.com.lojinha.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável pelos endpoints do Pagamento.
 */
@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
    private final PagamentoService pagamentoService;
    private final PedidoService pedidoService;

    /**
     * Injeta as dependências do PagamentoService e PedidoService.
     * @param pagamentoService Service de pagamentos a ser injetado.
     * @param pedidoService Service de pedidos a ser injetado.
     */
    @Autowired
    public PagamentoController(PagamentoService pagamentoService,
        PedidoService pedidoService) {

        this.pagamentoService = pagamentoService;
        this.pedidoService = pedidoService;
    }

    /**
     * Retorna a lista completa de pagamentos.
     * @return Lista de pagamentos registrados.
     */
    @GetMapping
    public List<Pagamento> listarPagamentos() {
        return pagamentoService.listarPagamentos();
    }

    /**
     * Busca o pedido pelo id e faz a solicitação do pagamento.
     * @param idPedido Id do pedido a ser buscado.
     * @param metodo_pg Método de pagamento escolhido.
     * @return O pagamento com status APROVADO ou lança exceção caso recusado.
     */
    @PostMapping
    public Pagamento solicitarPagamento(
        @RequestParam String idPedido,
        @RequestParam MetodoPag metodo_pg) {

        Pedido pedido = pedidoService.buscarPorId(idPedido);
        return pagamentoService.solicitarPagamento(pedido, metodo_pg);
    }
}