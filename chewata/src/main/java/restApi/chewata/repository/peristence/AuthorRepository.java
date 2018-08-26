package restApi.chewata.repository.peristence;

import org.springframework.data.jpa.repository.JpaRepository;
import restApi.chewata.repository.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
