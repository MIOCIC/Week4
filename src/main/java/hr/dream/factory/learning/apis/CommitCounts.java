package hr.dream.factory.learning.apis;

import com.opencsv.CSVWriter;
import com.sun.tools.hat.internal.parser.Reader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CommitCounts {
    int totals;
    int additions;
    int deletions;

    public int getTotals() {
        return totals;
    }

    public void setTotals(int totals) {
        this.totals = totals;
    }

    public int getAdditions() {
        return additions;
    }

    public void setAdditions(int additions) {
        this.additions = additions;
    }

    public int getDeletions() {
        return deletions;
    }

    public void setDeletions(int deletions) {
        this.deletions = deletions;
    }

}

class GitHubData {
    String user;
    int publicRepoCount;
    CommitCounts commitCounts;

    public GitHubData() {
        commitCounts = new CommitCounts();
    }

    public String[] convertToRowData() {
        String[] results = new String[6];
        results[0] = user;
        results[1] = Integer.toString(publicRepoCount);
        results[2] = Integer.toString(commitCounts.totals);
        results[3] = Integer.toString(commitCounts.additions);
        results[4] = Integer.toString(commitCounts.deletions);
        results[5] = Integer.toString(commitCounts.additions -commitCounts.deletions);
        return results;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getPublicRepoCount() {
        return publicRepoCount;
    }

    public void setPublicRepoCount(int publicRepoCount) {
        this.publicRepoCount = publicRepoCount;
    }

    public CommitCounts getCommitCounts() {
        return commitCounts;
    }

    public void setCommitCounts(CommitCounts commitCounts) {
        this.commitCounts = commitCounts;
    }

}

