import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsultaCEP {
  private static final String API_URL = "https://viacep.com.br/ws/";
  
  public String getEndereco(String cep){
    try {
      
      URL url = new URL(API_URL + cep + "/json");
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.setRequestProperty("Accept", "application/json");

      if (connection.getResponseCode() != 200){
        throw new RuntimeException("HTTP error code : " + connection.getResponseCode());
      }

      BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
      String output;
      StringBuilder response = new StringBuilder();
      while ((output = br.readLine()) != null) {
        response.append(output);
      }

      connection.disconnect();
      return response.toString();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
  public static void main(String[] args) {
    ConsultaCEP consultaCEP = new ConsultaCEP();
    String cep = "01001000";
    String json = consultaCEP.getEndereco(cep);
    System.out.println(json);
  }
}