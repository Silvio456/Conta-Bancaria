import java.util.Scanner;

public class MainConta {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        ContaBancaria conta1 = new ContaBancaria();
        conta1.agencia = "0001";
        conta1.numeroDaConta = "12345678-9";
        conta1.saldo = 1548.25f;

        ContaBancaria conta2 = new ContaBancaria();
        conta2.agencia = "0002";
        conta2.numeroDaConta = "98765432-1";
        conta2.saldo = 7599.09f;

        ContaBancaria contaAtual;

        int opcao = 0;
        while (opcao != 1 && opcao != 2) {
            System.out.println("Qual conta deseja acessar?");
            System.out.println("""
                    1 - Conta 1
                    2 - conta 2
                    """);

            opcao = ler.nextInt();
            ler.nextLine();
            
        }

        if (opcao == 1){
            contaAtual = conta1;
        } else {
            contaAtual = conta2;
        }
        
        System.out.println("""
                ==========================
                    SISTEMA BANCÁRIO
                ==========================
                Bem-vindo, por favor informe seus dados.
                """);
        System.out.println("Qual o nome do titular da conta?");
        contaAtual.titularDaConta = ler.nextLine();

        System.out.println("Qual o CPF do titular?");
        while (!contaAtual.verificar(ler.nextLine())) {
            System.out.print("CPF inválido! Digite novamente: ");
        }

        System.out.println("Sucesso ao entrar na conta! Essas são suas informações:");
        System.out.printf("""

                Agência: %s
                Número da conta: %s
                Titular da conta: %s
                CPF: %s
                Seu saldo é de: R$ %.2f

                """, contaAtual.agencia, contaAtual.numeroDaConta, contaAtual.titularDaConta, contaAtual.CPF, contaAtual.saldo);

        System.out.println("Qual ação deseja realizar?");

        System.out.println("""
                |===================|
                 1 - Sacar
                 2 - Depositar
                 3 - Consultar informações
                 0 - Sair
                |===================|
                """);

        do {

            switch (opcao = ler.nextInt()) {
                case 1:
                    System.out.println("Quanto deseja sacar?");
                    contaAtual.sacar(ler.nextFloat());
                    System.out.printf("Seu saldo atual é de %.2f\n", contaAtual.saldo);
                    break;

                case 2:
                    System.out.println("Quanto deseja depositar?");
                    contaAtual.depositar(ler.nextFloat());
                    System.out.printf("Seu saldo atual é de %.2f\n", contaAtual.saldo);
                    break;

                case 3:
                    contaAtual.consultar();
                    break;
                case 0:
                    contaAtual.consultar();
                    System.out.println("Saindo da conta...");
                    return;

                default:
                    System.out.println("Não é uma opção válida, digite novamente.");
                    break;
            }
            System.out.println("""
                    |===================|
                     1 - Sacar
                     2 - Depositar
                     3 - Consultar informações
                     0 - Sair
                    |===================|
                    """);
        } while (opcao != 0);

        ler.close();
    }
}