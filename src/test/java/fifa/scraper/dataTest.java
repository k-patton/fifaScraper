package fifa.scraper;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class dataTest {
    private static final Logger LOG = LogManager.getLogger(dataTest.class);

    public static void main(String[] args) {

        System.out.println("Welcome to this test. I am running. Lalala");

        try

        {
            LOG.info("This is in the try block");
            Document doc = Jsoup.connect("https://www.fifa.com/worldcup/matches/").get();


            Elements teamName = doc.getElementsByClass("fi-t__nText");

            Elements score = doc.getElementsByClass("fi-s__scoreText");
            Elements allInfo = doc.getElementsByClass("fi-mu__m");

            for (Element element : teamName) {
                System.out.println(element);
            }

            for (Element element : score) {
                System.out.println(element);
            }

            LOG.info(teamName);
        } catch (Exception err) {

            LOG.error("Something went wrong with getting fifa info", err);

        }

    }

}
