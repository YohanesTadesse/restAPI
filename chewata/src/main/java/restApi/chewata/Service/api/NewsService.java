package restApi.chewata.Service.api;

import restApi.chewata.model.News;

import java.util.List;

public interface NewsService {
    List<News> getLatestNews();
    void createNews(restApi.chewata.repository.entity.News news);
}
