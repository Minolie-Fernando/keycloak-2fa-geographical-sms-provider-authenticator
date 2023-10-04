package dasniko.keycloak.authenticator.gateway;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

public class ExternalSMSService {
    private final HttpClient client;

    public ExternalSMSService() {
        this.client = HttpClient.newHttpClient();
    }

    public String post(String url, JSONObject jsonObject) throws IOException, InterruptedException {
    String requestBody = jsonObject.toString();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .POST(HttpRequest.BodyPublishers.ofString(requestBody))
            .header("Content-Type", "application/json")
            .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    if (response.statusCode() != 200) {
        throw new IOException("Failed to call external API: " + response.statusCode());
    }

    return response.body();
}
}
