package mx.com.axity.services.facade;

import mx.com.axity.commons.to.KeyBoardTO;
import mx.com.axity.commons.to.MouseTO;

public interface IkeyboardFacade {
    KeyBoardTO getKeyBoardById(int idkeyboard);
}
