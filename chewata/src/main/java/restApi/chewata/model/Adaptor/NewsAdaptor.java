package restApi.chewata.model.Adaptor;

import restApi.chewata.model.News;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class NewsAdaptor {

    private static final Date now = new Date();
    public static List<News> adapt(final List<restApi.chewata.repository.entity.News> entities) {
        return entities.stream().map(NewsAdaptor::adapt).collect(Collectors.toList());
    }

    public static News adapt(final restApi.chewata.repository.entity.News entity) {
       return new News(
               entity.getId(),
                entity.getTitle(),
                entity.getImage(),
                entity.getFileName(),
                entity.getAuthorId(),
                entity.getCreatedDate(),
                entity.getLastUpdatedDate());
    }
    public static restApi.chewata.repository.entity.News adapt(final News model) {
        return new restApi.chewata.repository.entity.News(
                model.getId(),
                model.getTitle(),
                model.getImage(),
                model.getFileName(),
                model.getAuthorId(),
                now,
                now);
    }
}
