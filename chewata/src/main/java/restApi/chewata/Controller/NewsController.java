package restApi.chewata.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import restApi.chewata.Service.api.NewsService;
import restApi.chewata.model.Adaptor.NewsAdaptor;
import restApi.chewata.model.News;

import java.util.List;

@RestController
@RequestMapping(path = "/news")
public class NewsController {

    @Autowired
    private NewsService newsService;
    @GetMapping(path = "ping")
    public String getString() {
        return "pong !";
    }

    @GetMapping(path = "/latest")
    public List<News> getLatestNews() {
      return newsService.getLatestNews();
    }

    @PostMapping(path = "/latest", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNews(@RequestBody final News news) {
        newsService.createNews(NewsAdaptor.adapt(news));
        return ResponseEntity.ok().build();
    }

}
