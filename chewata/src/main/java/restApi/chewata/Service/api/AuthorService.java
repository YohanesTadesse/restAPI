package restApi.chewata.Service.api;


import org.springframework.http.ResponseEntity;
import restApi.chewata.repository.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();
    void newAuthor(restApi.chewata.repository.entity.Author author);
    Author findAuthorById(Long id);
    void deleteAuthor(Long id);
    ResponseEntity updateAuthor(restApi.chewata.repository.entity.Author request);
}
