package hr.dream.factory.learning.apis;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GitHubDataExporter {

    public void exportToFile(String filename, List<GitHubData> dataToExport) throws Exception {
        File file = new File(filename);
        try (FileWriter outputfile = new FileWriter(file);
             CSVWriter writer = new CSVWriter(outputfile)) {
            String[] header = {"name", "repoCount", "totals", "additions", "deletions", "cleanAdds"};
            writer.writeNext(header);
            for (GitHubData gitHubData : dataToExport) {
                String[] data1 = gitHubData.convertToRowData();
                writer.writeNext(data1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
