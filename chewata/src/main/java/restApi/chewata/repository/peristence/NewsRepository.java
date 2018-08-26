package restApi.chewata.repository.peristence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restApi.chewata.repository.entity.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

}

