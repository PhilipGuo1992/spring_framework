package yunfei.springframework.sprint5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import yunfei.springframework.sprint5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
