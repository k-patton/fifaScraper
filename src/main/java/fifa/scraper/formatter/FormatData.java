package fifa.scraper.formatter;

import fifa.scraper.data.FifaData;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FormatData {

    private static final Logger LOG = LogManager.getLogger(FormatData.class);


    @Autowired
    private FifaData fifaData;

    private static Elements teamName;
    private static Elements score;
    public List<String> teamsAndScores = new ArrayList<>();



    private void formatData() {

        teamsAndScores.clear();

        // We call this first to populate the object with all of the web scraped data.
        fifaData.getData();

        if (fifaData.getTeams().isPresent()) {
            teamName = fifaData.getTeams().get();
        }


        if (fifaData.getScores() != null) {
            score = fifaData.getScores();
        }

        List<String> teamList = new ArrayList<>();
        List<String> scoreList = new ArrayList<>();

        for (Element element : teamName) {
            String temp = element.ownText();
            if (temp.length() > 3) {
                teamList.add(temp);
            }
        }

        for (Element element : score) {
            String temp = element.ownText();
            if (temp.length() < 5) {
                scoreList.add(temp);
            }
        }

        int teamCounter = 0;


        for (int i = 0; i < scoreList.size(); i++) {
            teamsAndScores.add(teamList.get(teamCounter) + " vs. " +
                    teamList.get(teamCounter + 1)+ ": " + scoreList.get(i));

            teamCounter = teamCounter + 2;
        }
    }

    public List<String> getResults() {
        formatData();
        LOG.debug("log FormatData/getResults");
        return teamsAndScores;
    }


}
