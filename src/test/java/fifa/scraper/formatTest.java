package fifa.scraper;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan("com.scholastic.ecms.logging.poc.server3")
public class formatTest implements CommandLineRunner {

    @Autowired
    private FifaData fifaData;

    private static Elements teamName;
    private static Elements score;

    private static final Logger LOG = LogManager.getLogger(dataTest.class);


    public static void main(String[] args) {
        SpringApplication.run(formatTest.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Welcome to the formatTest");

        // We call this first to populate the object with all of the web scraped data.
        fifaData.getData();

        if (fifaData.getTeams().isPresent()) {
            teamName = fifaData.getTeams().get();
        };


        if (fifaData.getScores() != null) {
            score = fifaData.getScores();
        }

        List<String> teamList = new ArrayList<>();
        List<String> scoreList = new ArrayList<>();

        for (Element element : teamName) {
            String temp = element.ownText();
            System.out.println(temp);
            if (temp.length() > 3) {
                teamList.add(temp);
            }
        }

        for(Element element : score) {
            String temp = element.ownText();
            System.out.println(temp);
            if(temp.length() < 5) {
                scoreList.add(temp);
            }
        }

        int teamCounter = 0;

        List<String> teamsAndScores = new ArrayList<>();

        for(int i = 0; i < scoreList.size(); i++) {
            System.out.println(teamList.get(teamCounter) + " vs. " +
                    teamList.get(teamCounter + 1) + ": " + scoreList.get(i));

            teamsAndScores.add(teamList.get(teamCounter) + " vs. " +
                    teamList.get(teamCounter + 1) + ": " + scoreList.get(i));

            teamCounter = teamCounter +2;
        }

        for(String element: teamsAndScores) {
            System.out.println(element);
        }

    }

}
