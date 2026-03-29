package br.com.lojinha.controller;

import br.com.lojinha.model.Cliente;
import br.com.lojinha.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável pelos endpoints de Cliente.
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    /**
     * Injeta a dependência do ClienteService.
     * @param clienteService Service de clientes a ser injetado.
     */
    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /**
     * Retorna a lista completa de clientes.
     * @return Lista de clientes registrados.
     */
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    /**
     * Busca um cliente específico pelo CPF.
     * @param cpf CPF do cliente a ser buscado.
     * @return Cliente encontrado.
     */
    @GetMapping("/{cpf}")
    public Cliente buscarCliente(@PathVariable String cpf) {
        return clienteService.buscarCPF(cpf);
    }

    /**
     * Cadastra um cliente sem registro.
     * @param cliente Objeto cliente a ser cadastrado.
     */
    @PostMapping
    public void cadastrarCliente(@RequestBody Cliente cliente) {
        clienteService.cadastrarCliente(
            cliente.getNome(),
            cliente.getCPF(),
            cliente.getEmail(),
            cliente.getEndereco()
        );
    }
}