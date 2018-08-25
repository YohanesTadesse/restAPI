package restApi.chewata.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restApi.chewata.Service.api.NewsService;
import restApi.chewata.model.Adaptor.NewsAdaptor;
import restApi.chewata.model.News;
import restApi.chewata.repository.peristence.NewsRepository;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> getLatestNews() {
        return NewsAdaptor.adapt(newsRepository.findAll());
    }

    @Override
    public void createNews(restApi.chewata.repository.entity.News news) {
        newsRepository.save(news);
    }
}
