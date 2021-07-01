import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import java.util.Random;

public class SignIn {
    public static void main(String[] args) throws UnirestException {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://picsart.com/sign-up")
                .header("Content-Type", "application/json")
                .header("Cookie", "UI=eyJpZCI6MzYyODMwODk0MDE1MTAxLCJrZXkiOiI2ZDdiYzg4MC0yMzljLTQxMjgtYjU1ZS" +
                        "04Yjk3NjY1OTM3ZTciLCJuYW1lIjoiIiwidXNlcm5hbWUiOiJlZWVlc3Nzc2RkZGQiLCJwaG90byI6Imh0dHBzOi8vY2RuMT" +
                        "kwLnBpY3NhcnQuY29tLzIzMjgwNDY2MTAwNzkwMC5wbmciLCJlbWFpbCI6ImVlZWVzc3NzZGRkZEBnbWFpbC5jb20iLCJlbWFp" +
                        "bF9lbmNvZGVkIjoiYWYzMzdhN2YwNGJkOWU2ZmEzNjhiODFjMzgxN2Q5ZGNkMTE0OTZiOCIsImlzX2FjdGl2YXRlZCI6ZmFsc2Us" +
                        "ImlzX25ldyI6ZmFsc2UsImlzVHJpYWxVc2VkIjpmYWxzZSwiZW1haWxfdmVyaWZpY2F0aW9uX25lZWRlZCI6dHJ1ZX0%3D; " +
                        "badges=j%3A%7B%22VIP%22%3A%22https%3A%2F%2Fcdn130.picsart.com%2F267273314017201.png%22%2C%22Master%20" +
                        "Storyteller%22%3A%22https%3A%2F%2Fpastatic.picsart.com%2Fmasterstoryteller.png%22%2C%22Master%20Contributor" +
                        "%22%3A%22https%3A%2F%2Fpastatic.picsart.com%2Fmastercontributor.png%22%2C%22Celebrity%22%3A%22https%3A%2F%2" +
                        "Fcdn130.picsart.com%2F267273314017201.png%22%2C%22Brands%22%3A%22https%3A%2F%2Fcdn130.picsart.com%" +
                        "2F267273314017201.png%22%2C%22subscribed%22%3A%22https%3A%2F%2Fcdn140.picsart.com%2F270126459015201.png%22%7D;" +
                        " expraftryer=1; gtm_user_id=362830894015101; sid=s%3AXSj4yWNdUTPzSpI9fkp5dryiJQiU-uH6." +
                        "d7q6kQdT4qu6Aczbn%2ByUignnx6KVQmTuBxWs7MmFeGk; user_email=eeeessssdddd%40gmail.com; " +
                        "user_key=6d7bc880-239c-4128-b55e-8b97665937e7")
                .body("{\"email\": \"" + getSaltString() + "@gmail.com\" ,\n \"password\": \"As123456*\"\n}")
                .asString();
        System.out.println(response.getBody());

        String jsonString2 = response.getBody();
        JSONObject jsonObject = new JSONObject(jsonString2);
        String key = jsonObject.getString("key");
        System.out.println("Keyn esa "+key);
    }
    public static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

}
