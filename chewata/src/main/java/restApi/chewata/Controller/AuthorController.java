package restApi.chewata.Controller;

import lombok.RequiredArgsConstructor;
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
import restApi.chewata.Service.api.AuthorService;
import restApi.chewata.model.Adaptor.AuthorAdaptor;
import restApi.chewata.model.Author;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/author")
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping(path = "/")
    List<Author> getAllAuthors() {
       return AuthorAdaptor.adapt(authorService.getAllAuthors());
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    void newAuthor(@RequestBody final Author author) {
        authorService.newAuthor(AuthorAdaptor.adapt(author));
    }

    @GetMapping(path = "{id}")
    Author findAuthorById(@PathParam("id") Long id) {
        return AuthorAdaptor.adapt(authorService.findAuthorById(id));
    }

    @DeleteMapping(path = "/")
    void deleteAuthor(Long id) {
        authorService.deleteAuthor(id);
    }

    @PutMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity updateAuthor(final Author request) {
        return authorService.updateAuthor(AuthorAdaptor.adapt(request));
    }
}
