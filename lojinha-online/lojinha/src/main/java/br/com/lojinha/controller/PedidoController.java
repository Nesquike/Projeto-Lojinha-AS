package br.com.lojinha.controller;

import br.com.lojinha.model.Pedido;
import br.com.lojinha.model.Cliente;
import br.com.lojinha.model.Produto;
import br.com.lojinha.service.PedidoService;
import br.com.lojinha.service.ClienteService;
import br.com.lojinha.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável pelos endpoints de Pedido.
 */
@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    /**
     * Injeta as dependências do PedidoService, ClienteService e ProdutoService.
     * @param pedidoService Service de pedidos a ser injetado.
     * @param clienteService Service de clientes a ser injetado.
     * @param produtoService Service de produtos a ser injetado.
     */
    @Autowired
    public PedidoController(
        PedidoService pedidoService, 
        ClienteService clienteService, 
        ProdutoService produtoService) {

        this.pedidoService = pedidoService;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
    }

    /**
     * Retorna a lista completa de pedidos.
     * @return Lista de pedidos registrados.
     */
    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    /**
     * Cria um novo pedido em tempo de execução.
     * @param cpfCliente CPF do cliente responsável pelo pedido.
     * @param nomeProduto Nome do produto a ser adicionado ao pedido.
     * @param quantidade Quantidade de produtos a ser adicionada ao pedido.
     * @return O pedido criado.
     */
    @PostMapping
    public Pedido criarPedido(
        @RequestParam String cpfCliente,
        @RequestParam String nomeProduto,
        @RequestParam Long quantidade) {

        Cliente cliente = clienteService.buscarCPF(cpfCliente);
        Produto produto = produtoService.buscarProduto(nomeProduto);

        return pedidoService.criarPedido(cliente, produto, quantidade);
    }
}