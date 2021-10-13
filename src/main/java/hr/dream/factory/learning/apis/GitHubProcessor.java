package hr.dream.factory.learning.apis;

import java.util.List;

public class GitHubProcessor {

    public int fetchAllCommitsForUser(String user){
        int i = 0;
        GitHubFetcher gitHubFetcher = new GitHubFetcher();
        List<Repo> repoList = gitHubFetcher.fetchAllReposForUser(user);
        for (Repo repo: repoList) {
            List<Commit> commitList = gitHubFetcher.getCommit(user, repo.name);
            i += commitList.size();
        }
        return i;
    }

    public int countTotalStats(String user){
        int i = 0;
        GitHubFetcher gitHubFetcher = new GitHubFetcher();
        List<Repo> repoList = gitHubFetcher.fetchAllReposForUser(user);
        for (Repo repo: repoList) {
            List<Commit> commitList = gitHubFetcher.getCommit(user, repo.name);
            for (Commit commit : commitList){
                CommitDetails commitDetails = gitHubFetcher.getSingleCommit(user, repo.name, commit.sha);
                i+=commitDetails.stats.total;
            }
        }

        return i;
    }
}
