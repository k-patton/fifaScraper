package fifa.scraper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/fifa")
public interface FifaController {

    @GetMapping("/")
    ResponseEntity<List<String>> getFifaResults();

}
