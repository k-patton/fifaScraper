package fifa.scraper.controller.support;




import fifa.scraper.controller.FifaController;
import fifa.scraper.formatter.FormatData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/fifa")
public class DefaultFifaController implements FifaController {

    private static final Logger LOG = LogManager.getLogger(DefaultFifaController.class);

    @Autowired
    private FormatData formattedData;


    public ResponseEntity<List<String>> getFifaResults() {
        List<String> fifaResults = formattedData.getResults();
        LOG.info("This is in ResponseEntity getFifaResults() method");
        LOG.debug(" This is in SayResults() {}");
        return ResponseEntity.ok(fifaResults);
    }

}
