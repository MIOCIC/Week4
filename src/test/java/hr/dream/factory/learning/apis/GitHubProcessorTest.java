package hr.dream.factory.learning.apis;

import junit.framework.TestCase;

public class GitHubProcessorTest extends TestCase {

    public void testFetchAllCommitsForUser() {
        String user = "MIOCIC";
        GitHubProcessor gitHubProcessor = new GitHubProcessor();
        System.out.println(gitHubProcessor.fetchAllCommitsForUser(user));
    }


    public void testCountTotalStats() {
        String user = "MIOCIC";
        GitHubProcessor gitHubProcessor = new GitHubProcessor();
        System.out.println("total: " + gitHubProcessor.countTotalStats(user).get(0) + " additions:" + gitHubProcessor.countTotalStats(user).get(1) + " deletions:" + gitHubProcessor.countTotalStats(user).get(2) );
    }


    public void testGetForRepo() {
        String user = "MIOCIC";
        Repo repo = new Repo();
        repo.name = "Week4";
        GitHubProcessor gitHubProcessor = new GitHubProcessor();
        System.out.println(gitHubProcessor.getForRepo(user, repo));

    }
}