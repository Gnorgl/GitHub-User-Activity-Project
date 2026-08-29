package githubactivity;

public class GitHubActivity {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Error: Please provide a GitHub username.");
            System.out.println("Usage: java -jar githubactivity.jar <username>");
            System.exit(1);
        }

        String username = args[0];
        System.out.println("Fetching GitHub Activity for username: " + username);

        try {
            GitHubApiClient client = new GitHubApiClient();
            String jsonResponse = client.fetchUserEvents(username);
            System.out.println("Rar Response received successfully!");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred while fetching activity: " + e.getMessage());
        }
    }
}
