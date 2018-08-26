package restApi.chewata.Service.api;

import org.springframework.http.ResponseEntity;
import restApi.chewata.model.News;

import java.util.List;

public interface NewsService {
    List<News> getLatestNews();
    void createNews(restApi.chewata.repository.entity.News news);
    News findNewsById(Long id);
    void deleteNews(Long id);
    ResponseEntity updateNews(restApi.chewata.repository.entity.News request);
}
