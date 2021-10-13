package hr.dream.factory.learning.apis;

public class CommitDetails extends Commit {
    Stats stats;
}

class Stats{
    int total;
    int additions;
    int deletions;
}
