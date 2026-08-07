public class ContaBancaria {
    String agencia;
    String numeroDaConta;
    String titularDaConta;
    String CPF;
    float saldo;

    void sacar(float saque) {
        if (saque <= 0 || saque > this.saldo) {
            System.out.println("O valor solicitado não pode ser sacado, tente novamente.");
        } else {
            this.saldo -= saque;
        }
    }

    void depositar(float deposito) {
        if (deposito <= 0) {
            System.out.println("O valor solicitado não pode ser depositado, tente novamente.");
        } else {
            this.saldo += deposito;
        }
    }

    void consultar() {
        System.out.printf("""
                           
                Agência: %s
                Número da conta: %s
                Titular da conta: %s
                CPF: %s
                Seu saldo é de: R$ %.2f

                """, this.agencia, this.numeroDaConta, this.titularDaConta, this.CPF, this.saldo);
    }

    boolean verificar(String verificarCPF) {
        int soma = 0;
        int divisao = 0;

        verificarCPF = verificarCPF.replaceAll("\\D", "");
        
        if (verificarCPF.length() != 11) {
            return false;
        }

        char primeiro = verificarCPF.charAt(0);

        boolean todosIguais = true;

        for (int i = 1; i < verificarCPF.length(); i++) {
            if (verificarCPF.charAt(i) != primeiro) {
                todosIguais = false;
                break;
            }
        }

        if (todosIguais) {
            return false;
        }


        for (int i = 0, j = 10; i < 9; i++, j--) {
            soma += Character.getNumericValue(verificarCPF.charAt(i)) * j;
        }

        divisao = soma % 11;
        divisao = 11 - divisao;
        if (divisao == 10 || divisao == 11) {
            divisao = 0;
        }

        if (divisao != Character.getNumericValue(verificarCPF.charAt(9))) {
            return false;
        }

        soma = 0;
        divisao = 0;

        for (int i = 0, j = 11; i < 10; i++, j--) {
            soma += Character.getNumericValue(verificarCPF.charAt(i)) * j;
        }

        divisao = soma % 11;
        divisao = 11 - divisao;
        if (divisao == 10 || divisao == 11) {
            divisao = 0;
        }

        if (divisao != Character.getNumericValue(verificarCPF.charAt(10))) {
            return false;
        }
        this.CPF = verificarCPF;
        return true;
    }
}