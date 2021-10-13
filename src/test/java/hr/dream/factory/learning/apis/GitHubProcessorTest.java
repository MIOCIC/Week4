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
        System.out.println(gitHubProcessor.countTotalStats(user));
    }
}