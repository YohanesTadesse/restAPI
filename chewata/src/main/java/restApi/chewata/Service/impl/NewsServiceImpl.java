package restApi.chewata.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import restApi.chewata.Service.api.NewsService;
import restApi.chewata.model.Adaptor.NewsAdaptor;
import restApi.chewata.model.News;
import restApi.chewata.repository.peristence.NewsRepository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public News findNewsById(Long id) {
        Optional<restApi.chewata.repository.entity.News> op = newsRepository.findById(id);
        return op.isPresent() ? NewsAdaptor.adapt(op.get()) : null;
    }

    @Override
    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }

    @Override
    public ResponseEntity updateNews(restApi.chewata.repository.entity.News request) {
        Optional<restApi.chewata.repository.entity.News> news = newsRepository.findById(request.getId());
        if (! news.isPresent())
            return ResponseEntity.notFound().build();
        else {
            restApi.chewata.repository.entity.News entity = news.get();
            entity.setTitle(request.getTitle());
            entity.setImage(request.getImage());
            entity.setFileName(request.getFileName());
            newsRepository.save(entity);
            return ResponseEntity.ok().build();
        }
    }
}
