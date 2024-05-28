import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Consultar CEP
        System.out.print("Digite o CEP para consulta: ");
        String cep = scanner.nextLine();
        ConsultaCEP consultaCEP = new ConsultaCEP();
        String enderecoJson = consultaCEP.getEndereco(cep);
        System.out.println("Endereço associado ao CEP:\n" + enderecoJson);

        // Validar CPF
        System.out.print("\nDigite o CPF para validação: ");
        String cpf = scanner.nextLine();
        boolean cpfValido = ValidaCPF.isCPF(cpf);
        if (cpfValido) {
            System.out.println("CPF VÁLIDO");
        } else {
            System.out.println("CPF INVÁLIDO");
        }
       

        // Calcular salário líquido
        System.out.print("\nDigite o valor do salário bruto: ");
        double salarioBruto = scanner.nextDouble();
        System.out.print("Digite o desconto do INSS: ");
        double descontoINSS = scanner.nextDouble();
        System.out.print("Digite o valor total de outros descontos: ");
        double outrosDescontos = scanner.nextDouble();
        double salarioLiquido = CalculadoraSalario.calcularSalarioLiquido(salarioBruto, descontoINSS, outrosDescontos);
        System.out.println("Salário Líquido: " + salarioLiquido);
       

        scanner.close();
    }
}
