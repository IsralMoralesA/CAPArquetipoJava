package mx.com.axity.persistence;

import mx.com.axity.model.ComputerDO;
import mx.com.axity.model.OrdersDO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComputerDAO extends CrudRepository<ComputerDO, Long> {

    ComputerDO findByIdcomputer(int idcomputer);

}
