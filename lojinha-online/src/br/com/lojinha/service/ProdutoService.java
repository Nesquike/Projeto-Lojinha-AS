package br.com.lojinha.service;

import br.com.lojinha.model.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 * Service responsável pela gestão dos produtos.
 * Os produtos estáticos são inicializados diretamente nessa classe.
 */
public class ProdutoService {
    private List<Produto> produtos = new ArrayList<>();

    /**
     * Construtor que inicializa os produtos estáticos do sistema.
     */
    public ProdutoService() {
        produtos.add(new Produto("Camiseta Básica", 29.90, 100L));
        produtos.add(new Produto("Calça Jeans", 89.90, 50L));
        produtos.add(new Produto("Tênis Casual", 149.90, 30L));
        produtos.add(new Produto("Boné Aba Reta", 49.90, 75L));
        produtos.add(new Produto("Meia Kit 3 Pares", 19.90, 200L));
    }

    /**
     * Retorna lista completa de produtos.
     * @return lista de produtos registrados.
     */
    public List<Produto> listarProdutos() {
        return produtos;
    }

    /**
     * Busca um produto pelo nome.
     * @param nome Nome do produto a ser buscado.
     * @return o produto encontrado ou lança uma exceção se não existir.
     */
    public Produto buscarProduto(String nome) {
        for(Produto produto : produtos) {
            if(produto.getNome().equals(nome)) {
                return produto;
            }
        }
        throw new IllegalArgumentException("Produto não encontrado.");
    }

    /**
     * Registra novo produto em tempo de execução.
     * @param nome Nome do produto.
     * @param Preco_venda Preço do produto.
     * @param Estoque_Qtd Quantidade do produto no estoque.
     */
    public void adicionarProduto(String nome, Double Preco_venda, Long Estoque_Qtd) {
        validarNomeDuplicado(nome);
        produtos.add(new Produto(nome, Preco_venda, Estoque_Qtd));
    }

    /**
     * Verifica se o produto informado existe no estoque.
     * @param produto Produto a ser verificado.
     * @return true se o produto estiver disponível no estoque, false caso contrário.
     */
    public boolean verificarEstoque(Produto produto) {
        return produto.getEstoqueQtd() > 0;
    }

    /**
     * Verifica se já existe um produto com o nome informado.
     * @param nome Nome a ser validado.
     */
    private void validarNomeDuplicado(String nome) {
        for(Produto produto : produtos) {
            if(produto.getNome().equals(nome)) {
                throw new IllegalArgumentException("Já existe um produto com esse nome.");
            }
        }
    }
}