public class ValidaCPF {

  public static boolean isCPF(String cpf) {
      // Remove caracteres não numéricos
      cpf = cpf.replaceAll("\\D", "");

      // Verifica se o CPF tem 11 dígitos
      if (cpf.length() != 11) {
          return false;
      }

      // Verifica se todos os dígitos são iguais
      if (cpf.matches("(\\d)\\1{10}")) {
          return false;
      }

      try {
          // Cálculo do primeiro dígito verificador
          int firstVerifierDigit = calculateVerifierDigit(cpf, 9);
          // Cálculo do segundo dígito verificador
          int secondVerifierDigit = calculateVerifierDigit(cpf, 10);

          // Verifica se os dígitos verificadores estão corretos
          return cpf.charAt(9) == Character.forDigit(firstVerifierDigit, 10) &&
                 cpf.charAt(10) == Character.forDigit(secondVerifierDigit, 10);
      } catch (NumberFormatException e) {
          return false;
      }
  }

  private static int calculateVerifierDigit(String cpf, int length) {
      int sum = 0;
      for (int i = 0; i < length; i++) {
          sum += Character.getNumericValue(cpf.charAt(i)) * ((length + 1) - i);
      }
      int verifierDigit = 11 - (sum % 11);
      return (verifierDigit >= 10) ? 0 : verifierDigit;
  }

  public static void main(String[] args) {
      // Teste com alguns CPFs
      String[] cpfs = {
          "123.456.789-09",
          "111.444.777-35",
          "123.456.789-00",
          "111.111.111-11"
      };

      for (String cpf : cpfs) {
          System.out.println("CPF " + cpf + " é válido? " + isCPF(cpf));
      }
  }
}
