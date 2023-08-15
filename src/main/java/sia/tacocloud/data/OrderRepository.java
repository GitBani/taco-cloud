package sia.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

}
