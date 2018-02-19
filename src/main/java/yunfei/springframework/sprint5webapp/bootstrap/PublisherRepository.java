package yunfei.springframework.sprint5webapp.bootstrap;

import org.springframework.data.repository.CrudRepository;
import yunfei.springframework.sprint5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
