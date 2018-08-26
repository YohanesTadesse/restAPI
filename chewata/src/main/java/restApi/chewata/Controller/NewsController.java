package restApi.chewata.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restApi.chewata.Service.api.NewsService;
import restApi.chewata.model.Adaptor.NewsAdaptor;
import restApi.chewata.model.News;

import javax.websocket.server.PathParam;
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

    @PutMapping(path = "/latest", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateNews(@RequestBody final News news) {
//        TODO: is picture also changed => check note no. 1 => PERFORMANCE
            return newsService.updateNews(NewsAdaptor.adapt(news));
    }

    @DeleteMapping(path = "/latest{id}")
    public ResponseEntity deleteNews(@PathParam("id") final Long id) {
        newsService.deleteNews(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/latest{id}")
    public News getNewsById(@PathParam("id") final Long id) {
        return newsService.findNewsById(id);
    }

}
