package mx.com.axity.persistence;

import mx.com.axity.model.MonitorDO;
import mx.com.axity.model.MouseDO;
import org.springframework.data.repository.CrudRepository;

public interface MouseDAO extends CrudRepository<MouseDO, Long> {

    MouseDO findByIdmouse(int idmouse);
}
