package mx.com.axity.persistence;

import mx.com.axity.model.OrdersDO;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface OrdersDAO extends CrudRepository<OrdersDO, Long> {

    OrdersDO findByIdorder(int idorder);
}
