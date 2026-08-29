package githubactivity;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubApiClient {
    private final HttpClient httpClient = HttpClient.newHttpClient();

    public String fetchUserEvents(String username) throws Exception {
        String url = "https://api.github.com/users/" + username + "/events";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", "Java-GitHub-Activity-CLI") // Required by GitHub API
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 404) {
            throw new IllegalArgumentException("User '" + username + "' not found.");
        } else if (response.statusCode() != 200) {
            throw new RuntimeException("API request failed with status code: " + response.statusCode());
        }

        return response.body();
    }
}