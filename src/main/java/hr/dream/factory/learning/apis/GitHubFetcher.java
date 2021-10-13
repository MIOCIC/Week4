package hr.dream.factory.learning.apis;
import feign.Feign;
import feign.Param;
import feign.RequestLine;
import feign.gson.GsonDecoder;

import java.util.List;

interface GitHubApi {
    @RequestLine("GET /users/{owner}/repos")
    List<Repo> repos(@Param("owner") String owner);

    @RequestLine("GET /repos/{owner}/{repo}/commits")
    List<Commit> commits(@Param("owner") String owner, @Param("repo") String repo);

    @RequestLine("GET /repos/{owner}/{repo}/commits/{commitSha}")
    CommitDetails commitDetails(@Param("owner") String owner, @Param("repo") String repo, @Param("commitSha") String commitSha);
}

//https://api.github.com/repos/MIOCIC/Week4/contributors

/*class MyApp2 {
    public static void main(String... args) {
        GitHubApi github = Feign.builder()
                .decoder(new GsonDecoder())
                .target(GitHubApi.class, "https://api.github.com");

        // Fetch and print a list of the contributors to this library.
        List<Repo> repos = github.repos("MIOCIC");
        List<Contributor> contributors = github.contributors("MIOCIC", "Week4");
        for (Repo repo : repos) {
            System.out.println(repo.login + " " + repo.name + " " + repo.full_name + " " + repo.url );
        }
    }
}

 */
public class GitHubFetcher {
    private GitHubApi api;
    public GitHubFetcher(){
        this.api = Feign.builder()
                .decoder(new GsonDecoder())
                .target(GitHubApi.class, "https://api.github.com");
    }
    public List<Repo> fetchAllReposForUser(String user){
        return this.api.repos(user);
    }
    public List<Commit> getCommit(String user, String repo){
        return this.api.commits(user, repo);

    }

    public CommitDetails getSingleCommit(String user, String repo, String commitSha){
        /*List<Commit> commitList = getCommit(user, repo);
        Commit commit = commitList.stream()
                .filter(t -> t.sha.equals(commitSha))
                .findFirst()
                .orElse(null);
        return commit;*/
        return this.api.commitDetails(user,repo,commitSha);
    }

}

class Commit {
    String sha;
}

class Owner {
    String login;
}

class Repo {
    Owner owner;
    String name;
    String full_name;
    String url;
}






