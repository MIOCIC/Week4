package hr.dream.factory.learning.apis;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class GitHubFetcherTest extends TestCase {

    @Test
    public void testFetchAllReposForUser() {
        GitHubFetcher fetcher = new GitHubFetcher();
        String user = "Smthng0";
        List<Repo> repos = fetcher.fetchAllReposForUser(user);
        for (Repo repo : repos) {
            System.out.println(repo.owner.login + " " + repo.name + " " + repo.full_name + " " + repo.url );
        }
    }

 /*   public void testToken() {
        GitHubFetcher gitHubFetcher = new GitHubFetcher();
        gitHubFetcher.fetchAllReposForUser("MIOCIC", "token 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");
    }*/
}