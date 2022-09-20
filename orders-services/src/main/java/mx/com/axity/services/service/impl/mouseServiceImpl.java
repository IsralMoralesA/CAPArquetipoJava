package mx.com.axity.services.service.impl;

import mx.com.axity.commons.to.MonitorTO;
import mx.com.axity.commons.to.MouseTO;
import mx.com.axity.model.MonitorDO;
import mx.com.axity.model.MouseDO;
import mx.com.axity.persistence.MonitorDAO;
import mx.com.axity.persistence.MouseDAO;
import mx.com.axity.services.service.ImonitorService;
import mx.com.axity.services.service.ImouseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
public class mouseServiceImpl implements ImouseService {

    static final Logger LOG = LogManager.getLogger(mouseServiceImpl.class);

    @Autowired
    MouseDAO mouseDAO;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public MouseTO getMouseById(int idmouse) {
        LOG.info("Consultando mouse");
        MouseDO mouseDO = this.mouseDAO.findByIdmouse(idmouse);
        Type DAOType = new TypeToken<MouseTO>() {}.getType();
        MouseTO mouseTO = this.modelMapper.map(mouseDO, DAOType);
        LOG.info("Se retornan {} elementos", mouseTO);
        return mouseTO;
    }
}
