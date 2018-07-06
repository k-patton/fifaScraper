package fifa.scraper;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FifaData {

    private static final Logger LOG = LogManager.getLogger(FifaData.class);

    Elements teamName;
    Elements score;

    public void getData() {
        System.out.println("Welcome to the FifaData class and the getData() method");

        try

        {
            LOG.info("This is in the try block of getData()");
            Document doc = Jsoup.connect("https://www.fifa.com/worldcup/matches/").get();


            teamName = doc.getElementsByClass("fi-t__nText");

            score = doc.getElementsByClass("fi-s__scoreText");
            Elements allInfo = doc.getElementsByClass("fi-mu__m");

        } catch (Exception err) {

            LOG.error("Something went wrong with getting fifa info", err);

        }

    }

    public Optional<Elements> getTeams(){
        return Optional.ofNullable(teamName);
    }

    public Elements getScores(){
        return score;
    }


}
