package br.com.lojinha.model;

public class Cliente extends BaseEntity {
    private String nome;
    private String cpf;
    private String email;
    private String endereco;

    /**
     *Construtor vazio para gerar novo cliente
     */
    public Cliente() {}

    /**
     * Construtor completo para cliente já cadastrado
     */
    public Cliente(String nome, String cpf, String email, String endereco) {
        setNome(nome);
        setCPF(cpf);
        setEmail(email);
        setEndereco(endereco);
    }

    /**
     * Getters e Setters
     */
    public String getNome() { return nome; }
    public void setNome(String nome) { 
        validarNome(nome);
        this.nome = nome; 
    }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { 
        validarEmail(email);
        this.email =  email; 
    }
    
    public String getCPF() { return cpf; }
    public void setCPF(String cpf) { 
        validarCPF(cpf);
        this.cpf = cpf; 
    }
    
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { 
        validarEndereco(endereco);
        this.endereco = endereco; 
    }
    
    /**
     * Métodos de validação simples
     */
    private void validarNome(String nome) {
        if(nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode estar vazio.");
        }
    }

    private void validarCPF(String cpf) {
        if(cpf == null || cpf.isBlank() || cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido!");
        }
    }

    private void validarEmail(String email) {
        if(email == null || email.isBlank() || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido!");
        }
    }

    private void validarEndereco(String endereco) {
        if(endereco == null || endereco.isBlank()) {
            throw new IllegalArgumentException("O endereco não pode estar vazio.");
        }
    }

    /**
     * Método para imprimir dados do cliente
     * O método para mascarar o valor do CPF do cliente ainda será desenvolvido
     */
    @Override
    public void mostrarDados() {
        System.out.println("=== CLIENTE ===");
        System.out.println("- Nome:" + nome);
        System.out.println("- CPF:" + cpf);
        System.out.println("- Email:" + email);
        System.out.println("- Endereço: " + endereco);
    }
}