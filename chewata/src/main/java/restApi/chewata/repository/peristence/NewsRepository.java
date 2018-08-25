package restApi.chewata.repository.peristence;

import org.springframework.data.jpa.repository.JpaRepository;
import restApi.chewata.repository.entity.News;

public interface NewsRepository extends JpaRepository<News, Long> {
}
