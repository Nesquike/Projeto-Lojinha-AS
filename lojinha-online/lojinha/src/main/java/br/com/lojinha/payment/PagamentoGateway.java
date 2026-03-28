package br.com.lojinha.payment;

/**
 * Classe responsável pela comunicação com o sistema de pagamento externo.
 * 
 * O padrão Singleton é utilizado aqui para garantir que exista apenas uma
 * instância e conexão com o gateway de pagamento durante toda a execução
 * do sistema. Isso evita múltiplas conexões desnecessárias com o serviço
 * externo, centralizando e controlando o ponto de comunicação.
 */
public class PagamentoGateway {
    //Única instância da classe.
    private static PagamentoGateway instancia;

    /**
     * Construtor privado.
     * Impede que outras classes instanciem diretamente.
     */
    private PagamentoGateway() {
        System.out.println("Conexão com o gateway de pagamento estabelecida.");
    }

    /**
     * Ponto global de acesso à instância única.
     * Cria a instância apenas na primeira chamada.
     * @return a instância única de PagamentoGateway.
     */
    public static PagamentoGateway getInstancia() {
        if(instancia == null) {
            instancia = new PagamentoGateway();
        }
        return instancia;
    }

    /**
     * Processa o pagamento simulando a comunicação com o sistema externo.
     * @param valor Valor total do pagamento a ser processado.
     * @return true se o pagamento for aprovado, false se foi recusado.
     */
    public boolean processarPagamento(Double valor) {
        System.out.println("Processando pagamento de R$" + valor + "...");
        //Essa simulação aprova qualquer pagamento acima de 0.
        return valor > 0;
    }
}
