package mx.com.axity.persistence;

import mx.com.axity.model.KeyBoardDO;
import mx.com.axity.model.MouseDO;
import org.springframework.data.repository.CrudRepository;

public interface KeyBoardDAO extends CrudRepository<KeyBoardDO, Long> {

    KeyBoardDO findByIdkeyboard(int idkeyboard);
}
