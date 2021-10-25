package hr.dream.factory.learning.models;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;

public class RuneWordScrapper {
    public static void main(String[] args) throws Exception {
     RuneWordScrapper runeWordScrapper = new RuneWordScrapper();
     runeWordScrapper.scrape();
    }
    public void scrape() throws Exception {
        Document runewordPage = Jsoup.parse(new URL("https://diablo2.diablowiki.net/Runewords"), 10_000);
        Elements parentOfTable = runewordPage.getElementsByAttributeValue("id", "mw-content-text");

        if (parentOfTable.size() != 1) {
            throw new RuntimeException("wrong element!");
        }
        Element parentOfTableElement = parentOfTable.get(0);

        Elements maybeCorrect = parentOfTableElement.getElementsByAttributeValue("style", "border-collapse: collapse; border: 1px solid #4D0B0B; background: #2D0606; line-height: 14px; font-size: 10px; color: white; clear:right;");

        Element tableBody = maybeCorrect.get(0).getElementsByTag("tbody").get(0);
        System.out.println("test");
    }

}
