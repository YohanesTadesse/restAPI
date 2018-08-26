package restApi.chewata.model.Adaptor;

import restApi.chewata.model.Author;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorAdaptor {
    public static Author adapt(final restApi.chewata.repository.entity.Author entity) {
        return new Author(
                entity.getId(),
                entity.getName(),
                entity.getTitle(),
                entity.getImage(),
                entity.getCompany(),
                entity.getCreatedDate(),
                entity.getLastModifiedDate());
    }

    public static restApi.chewata.repository.entity.Author adapt(final Author model) {
        return new restApi.chewata.repository.entity.Author(
                model.getId(),
                model.getName(),
                model.getTitle(),
                model.getImage(),
                model.getCompany(),
                model.getCreatedDate(),
                model.getLastModifiedDate());
    }

    public static List<Author> adapt(final List<restApi.chewata.repository.entity.Author> entities) {
        return entities.stream().map(AuthorAdaptor::adapt).collect(Collectors.toList());
    }

//    public static List<restApi.chewata.repository.entity.Author> adapt(final List<Author> entities) {
//        return entities.stream().map(AuthorAdaptor::adapt).collect(Collectors.toList());
//
//    }

}
