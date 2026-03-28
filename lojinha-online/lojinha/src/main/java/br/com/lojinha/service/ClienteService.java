package br.com.lojinha.service;

import br.com.lojinha.model.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 * Service responsável pela gestão dos clientes.
 * Os clientes estáticos são incializados diretamente nessa classe.
 */
public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();

    /**
     * Construtor que incializa os clientes estáticos do sistema.
     */
    public ClienteService() {
        clientes.add(new Cliente("João Silva", "12345678901", "joao@email.com", "Rua A, 123"));
        clientes.add(new Cliente("Maria Souza", "98765432100", "maria@email.com", "Rua B, 456"));
        clientes.add(new Cliente("Carlos Lima", "11122233344", "carlos@email.com", "Rua C, 789"));
    }

    /**
     * Retorna a lista completa de clientes.
     * @return lista de clientes cadastrados.
     */
    public List<Cliente> listarClientes() {
        return clientes;
    }

    /**
     * Busca um cliente pelo CPF.
     * @param cpf CPF do cliente a ser buscado.
     * @return o cliente encontrado ou null se não existir.
     */
    public Cliente buscarCPF(String cpf) {
        for(Cliente cliente : clientes) {
            if(cliente.getCPF().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    /**
     * Cadastra novo cliente em tempo de execução;
     * @param nome Nome do cliente;
     * @param cpf CPF do cliente;
     * @param email Email do cliente;
     * @param endereco Endereço do cliente.
     */
    public void cadastrarCliente(String nome, String cpf, String email, String endereco) {
        validarCPFCPF(cpf);
        clientes.add(new Cliente(nome, cpf, email, endereco));
    }

    /**
     * Verifica se já existe um cliente com o CPF informado.
     * @param cpf CPF a ser validado.
     */
    public void validarCPFCPF(String cpf) {
        if(buscarCPF(cpf) != null) {
            throw new IllegalArgumentException("Esse cpf já foi cadastrado.");
        }
    }
}
