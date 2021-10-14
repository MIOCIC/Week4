package hr.dream.factory.learning.apis;

import java.util.ArrayList;
import java.util.List;

public class GitHubProcessor {
    GitHubFetcher gitHubFetcher;
    public GitHubProcessor() {
        this.gitHubFetcher = new GitHubFetcher();
}

    public int fetchAllCommitsForUser(String user){
        int i = 0;
        List<Repo> repoList = gitHubFetcher.fetchAllReposForUser(user);
        for (Repo repo: repoList) {
            List<Commit> commitList = gitHubFetcher.getCommit(user, repo.name);
            i += commitList.size();
        }
        return i;
    }

    public List<Integer> countTotalStats(String user){
        List<Repo> repoList = gitHubFetcher.fetchAllReposForUser(user);
        return countTotalStats(user, repoList);
    }

    public List<Integer> countTotalStats(String user, List<Repo> repos){
        int i = 0, j = 0, k = 0;
        for (Repo repo: repos) {
            List<Integer> forRepo = getForRepo(repo.owner.login, repo);
            i += forRepo.get(0);
            j += forRepo.get(1);
            k += forRepo.get(2);
        }
        List<Integer> integerList = new ArrayList<>();
        integerList.add(i);
        integerList.add(j);
        integerList.add(k);
        return integerList;
    }

    public GitHubData convert(List<Repo> repos, List<Integer> integerList) {
        //List<GitHubData> gitHubDataList = new ArrayList<>();
        GitHubData gitHubData = new GitHubData();
        gitHubData.publicRepoCount = repos.size();
        gitHubData.user = repos.get(0).owner.login;
        gitHubData.commitCounts.totals = integerList.get(0);
        gitHubData.commitCounts.additions = integerList.get(1);
        gitHubData.commitCounts.deletions = integerList.get(2);


        return gitHubData;
    }

    public List<Integer> getForRepo(String user, Repo repo) {
        List<Commit> commitList = gitHubFetcher.getCommit(user, repo.name);
        int i = 0, j = 0, k = 0;
        for (Commit commit : commitList){
            CommitDetails commitDetails = gitHubFetcher.getSingleCommit(user, repo.name, commit.sha);
            i +=commitDetails.stats.total;
            j +=commitDetails.stats.additions;
            k +=commitDetails.stats.deletions;
        }
        List<Integer> integerList = new ArrayList<>();
        integerList.add(i);
        integerList.add(j);
        integerList.add(k);
        return integerList;
    }
}
