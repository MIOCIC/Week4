package hr.dream.factory.learning.apis;
import feign.Feign;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.gson.GsonDecoder;

import java.util.ArrayList;
import java.util.List;

interface GitHubApi {

    @Headers("Authorization: {token}")
    @RequestLine("GET /users/{owner}/repos?page={page}")
    List<Repo> repos(@Param("owner") String owner, @Param("token") String token, @Param("page") int page);

    @Headers("Authorization: {token}")
    @RequestLine("GET /repos/{owner}/{repo}/commits?page={page}&author={owner}")
    List<Commit> commits(@Param("owner") String owner, @Param("repo") String repo, @Param("token") String token, @Param("page") int page);

    @Headers("Authorization: {token}")
    @RequestLine("GET /repos/{owner}/{repo}/commits/{commitSha}")
    CommitDetails commitDetails(@Param("owner") String owner, @Param("repo") String repo, @Param("commitSha") String commitSha, @Param("token") String token);
}

//https://api.github.com/repos/MIOCIC/Week4/contributors

public class GitHubFetcher {
    private GitHubApi api;
    private String token = "token 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";
    public GitHubFetcher(){
        this.api = Feign.builder()
                .decoder(new GsonDecoder())
                .target(GitHubApi.class, "https://api.github.com");
    }
    public List<Repo> fetchAllReposForUser(String user){
        List<Repo> repoList = new ArrayList<>();
        int page = 1;
        List<Repo> repos = this.api.repos(user, token, page);

        while (!repos.isEmpty()) {
            repoList.addAll(repos);
            page++;
            repos = this.api.repos(user, token, page);
        }
        return repoList;
    }


    public List<Commit> getCommit(String user, String repo){
        List<Commit> commitList = new ArrayList<>();
        int page = 1;
        List<Commit> commits = this.api.commits(user, repo, token, page);

        while (true) {
            if (!!commits.isEmpty()) break;
            commitList.addAll(commits);
            page++;
            commits = this.api.commits(user, repo, token, page);
        }
        return commitList;
    }

    public CommitDetails getSingleCommit(String user, String repo, String commitSha){
        return this.api.commitDetails(user,repo,commitSha, token);
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






