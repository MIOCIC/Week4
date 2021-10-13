package hr.dream.factory.learning.apis;

import junit.framework.TestCase;

import java.util.List;

public class GitHubFetcherTest extends TestCase {

    public void testFetchAllReposForUser() {
        GitHubFetcher fetcher = new GitHubFetcher();
        String user = "MIOCIC";
        List<Repo> repos = fetcher.fetchAllReposForUser(user);
        for (Repo repo : repos) {
            System.out.println(repo.owner.login + " " + repo.name + " " + repo.full_name + " " + repo.url );
        }
    }
}