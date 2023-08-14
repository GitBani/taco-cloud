package sia.tacocloud.data;

import sia.tacocloud.TacoOrder;

public interface OrderRepository {

    TacoOrder save(TacoOrder tacoOrder);
}
