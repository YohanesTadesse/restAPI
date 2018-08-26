package restApi.chewata.Service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import restApi.chewata.Service.api.AuthorService;
import restApi.chewata.repository.entity.Author;
import restApi.chewata.repository.peristence.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;
    @Override
    public List<Author> getAllAuthors() {
        return repository.findAll();
    }

    @Override
    public void newAuthor(Author author) {
        repository.save(author);
    }

    @Override
    public Author findAuthorById(Long id) {
        Optional<Author> op = repository.findById(id);
        return op.isPresent() ? op.get() : null;
    }

    @Override
    public void deleteAuthor(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ResponseEntity updateAuthor(Author request) {
        Optional<restApi.chewata.repository.entity.Author> news = repository.findById(request.getId());
        if (! news.isPresent())
            return ResponseEntity.notFound().build();
        else {
            restApi.chewata.repository.entity.Author entity = news.get();
            entity.setTitle(request.getTitle());
            entity.setImage(request.getImage());
            entity.setCompany(request.getCompany());
            entity.setName(request.getName());
            repository.save(entity);
            return ResponseEntity.ok().build();
        }
    }
}
