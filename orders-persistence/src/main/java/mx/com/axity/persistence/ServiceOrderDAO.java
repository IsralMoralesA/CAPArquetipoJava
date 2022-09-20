package mx.com.axity.persistence;

import mx.com.axity.model.OrdersDO;
import mx.com.axity.model.ServiceOrderDO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceOrderDAO extends CrudRepository<ServiceOrderDO, Long> {

    ServiceOrderDO findByIdserviceorder(int idorder);
    List<ServiceOrderDO> findAllByIdorder(int idorder);
}
