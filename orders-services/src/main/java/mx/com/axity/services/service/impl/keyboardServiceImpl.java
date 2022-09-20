package mx.com.axity.services.service.impl;

import mx.com.axity.commons.to.KeyBoardTO;
import mx.com.axity.commons.to.MouseTO;
import mx.com.axity.model.KeyBoardDO;
import mx.com.axity.model.MouseDO;
import mx.com.axity.persistence.KeyBoardDAO;
import mx.com.axity.persistence.MouseDAO;
import mx.com.axity.services.service.IkeyboardService;
import mx.com.axity.services.service.ImouseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
public class keyboardServiceImpl implements IkeyboardService {

    static final Logger LOG = LogManager.getLogger(keyboardServiceImpl.class);

    @Autowired
    KeyBoardDAO keyboardDAO;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public KeyBoardTO getKeyBoardById(int idkeyboard) {
        LOG.info("Consultando keyboard");
        KeyBoardDO keyboardDO = this.keyboardDAO.findByIdkeyboard(idkeyboard);
        Type DAOType = new TypeToken<KeyBoardTO>() {}.getType();
        KeyBoardTO keyboardTO = this.modelMapper.map(keyboardDO, DAOType);
        LOG.info("Se retornan {} elementos", keyboardTO);
        return keyboardTO;
    }
}
