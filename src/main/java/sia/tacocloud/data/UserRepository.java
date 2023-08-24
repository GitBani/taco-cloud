package sia.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
