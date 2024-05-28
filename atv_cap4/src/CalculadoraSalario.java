public class CalculadoraSalario {

    public static double calcularSalarioLiquido(double salarioBruto, double descontoINSS, double outrosDescontos) {
        double baseCalculoIRRF = salarioBruto - descontoINSS;
        double irrf = calcularIRRF(baseCalculoIRRF);
        return salarioBruto - descontoINSS - irrf - outrosDescontos;
    }

    private static double calcularIRRF(double baseCalculo) {
        double irrf;

        if (baseCalculo <= 1903.98) {
            irrf = 0.0;
        } else if (baseCalculo <= 2826.65) {
            irrf = (baseCalculo * 0.075) - 142.80;
        } else if (baseCalculo <= 3751.05) {
            irrf = (baseCalculo * 0.15) - 354.80;
        } else if (baseCalculo <= 4664.68) {
            irrf = (baseCalculo * 0.225) - 636.13;
        } else {
            irrf = (baseCalculo * 0.275) - 869.36;
        }

        return irrf;
    }
}
