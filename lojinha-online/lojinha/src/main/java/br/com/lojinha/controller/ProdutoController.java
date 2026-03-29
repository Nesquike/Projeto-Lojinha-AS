package br.com.lojinha.controller;

import br.com.lojinha.model.Produto;
import br.com.lojinha.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável pelos endpoints de Produto.
 */
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    /**
     * Injeta dependência do ProdutoService.
     * @param produtoService Service de produtos a ser injetado.
     */
    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    /**
     * Retorna a lista completa de produtos.
     * @return Lista de produtos registrados.
     */
    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    /**
     * Busca um produto específico pelo nome.
     * @param nome Nome do produto a ser buscado.
     * @return Produto encontrado.
     */
    @GetMapping("/{nome}")
    public Produto buscarProduto(@PathVariable String nome) {
        return produtoService.buscarProduto(nome);
    }

    /**
     * Registra um novo produto em tempo de execução.
     * @param produto Objeto produto a ser adicionado.
     */
    @PostMapping
    public void adicionarProduto(@RequestBody Produto produto) {
        produtoService.adicionarProduto(
            produto.getNome(),
            produto.getPrecoVenda(),
            produto.getEstoqueQtd()
        );
    }
}