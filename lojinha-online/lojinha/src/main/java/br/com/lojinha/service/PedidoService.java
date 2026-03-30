package br.com.lojinha.service;

import br.com.lojinha.model.ItemPedido;
import br.com.lojinha.model.Produto;
import br.com.lojinha.model.Pedido;
import br.com.lojinha.model.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Service;

/**
 * Service responsável por gerenciar pedidos.
 */
@Service
public class PedidoService {
    @JsonManagedReference
    private List<Pedido> pedidos = new ArrayList<>();
    private final ProdutoService produtoService;

    /**
     * Injeta o ProdutoService para a verificação de estoque durante a criação de pedidos.
     * @param produtoService Service de produtos a ser injetado.
     */
    @Autowired
    public PedidoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    /**
     * Retorna lista completa de pedidos.
     * @return lista de pedidos registrados.
     */
    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    /**
     * Busca um pedido pelo ID.
     * @param id id do pedido a ser buscado.
     * @return O pedido ou lança uma exceção caso nada seja encontrado.
     */
    public Pedido buscarPorId(String id) {
        for(Pedido pedido : pedidos) {
            if(pedido.getId().equals(id)) {
                return pedido;
            }
        }
        throw new IllegalArgumentException("Pedido não encontrado.");
    }

    /**
     * Cria um novo pedido em tempo de execução
     * @param cliente Cliente responsável pela criação do pedido;
     * @param produto Produto a ser adicionado no pedido.
     * @param quantidade Quantidade do produto a ser adicionado no pedido.
     * @return o pedido criado.
     */
    public Pedido criarPedido(Cliente cliente, Produto produto, Long quantidade) {
        if(!produtoService.verificarEstoque(produto)) {
            throw new IllegalArgumentException("Produto fora de estoque.");
        }

        Pedido pedido = new Pedido(LocalDate.now(), Pedido.StatusPedido.PENDENTE, cliente);
        ItemPedido item = new ItemPedido(quantidade, produto.getPrecoVenda(), pedido, produto);
        
        pedido.adicionarItem(item);
        pedidos.add(pedido);
        return pedido;
    }
}