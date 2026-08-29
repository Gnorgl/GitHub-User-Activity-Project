package githubactivity;

public class GitHubEvent {
    private final String type;
    private final String repoName;
    private final String detail;

    public GitHubEvent(String type, String repoName, String detail) {
        this.type = type;
        this.repoName = repoName;
        this.detail = detail;
    }

    public String toDisplayString() {
        switch (type) {
            case "PushEvent":
                return "- Pushed " + detail + " commits to " + repoName;
            case "IssuesEvent":
                return "- " + capitalize(detail) + " an issue in " + repoName;
            case "WatchEvent":
                return "- Starred " + repoName;
            case "CreateEvent":
                return "- Created " + detail + " in " + repoName;
            default:
                return "- " + type + " in " + repoName;
        }
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
