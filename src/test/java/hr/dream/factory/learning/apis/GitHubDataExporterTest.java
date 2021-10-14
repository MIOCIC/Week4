package hr.dream.factory.learning.apis;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class GitHubDataExporterTest extends TestCase {

    public void testExportToFile() throws Exception {
        //String[] users = {"MIOCIC", "Smthng0"};
        String[] users = {"MIOCIC", "Smthng0", "fr33d00m"};
        GitHubProcessor gitHubProcessor = new GitHubProcessor();
        List<GitHubData> gitHubDataList = new ArrayList<>();
        for(String user : users){
            List<Repo> repos = gitHubProcessor.gitHubFetcher.fetchAllReposForUser(user);
            gitHubDataList.add(gitHubProcessor.convert(repos, gitHubProcessor.countTotalStats(user, repos)));
        }
        GitHubDataExporter gitHubDataExporter = new GitHubDataExporter();
        String filename = "csvTest.csv";
        gitHubDataExporter.exportToFile(filename, gitHubDataList);
    }
}