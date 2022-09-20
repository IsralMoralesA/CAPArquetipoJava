package mx.com.axity.persistence;

import mx.com.axity.model.ComputerDO;
import mx.com.axity.model.MonitorDO;
import org.springframework.data.repository.CrudRepository;

public interface MonitorDAO extends CrudRepository<MonitorDO, Long> {

    MonitorDO findByIdmonitor(int idmonitor);
}
