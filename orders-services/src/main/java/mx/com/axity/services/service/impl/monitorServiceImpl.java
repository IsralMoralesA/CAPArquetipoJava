package mx.com.axity.services.service.impl;

import mx.com.axity.commons.to.ComputerTO;
import mx.com.axity.commons.to.MonitorTO;
import mx.com.axity.model.ComputerDO;
import mx.com.axity.model.MonitorDO;
import mx.com.axity.persistence.ComputerDAO;
import mx.com.axity.persistence.MonitorDAO;
import mx.com.axity.services.service.IcomputerService;
import mx.com.axity.services.service.ImonitorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
public class monitorServiceImpl implements ImonitorService {

    static final Logger LOG = LogManager.getLogger(monitorServiceImpl.class);

    @Autowired
    MonitorDAO monitorDAO;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public MonitorTO getMonitorById(int idmonitor) {
        LOG.info("Consultando monitor");
        MonitorDO monitorDO = this.monitorDAO.findByIdmonitor(idmonitor);
        Type DAOType = new TypeToken<MonitorTO>() {}.getType();
        MonitorTO monitorTO = this.modelMapper.map(monitorDO, DAOType);
        LOG.info("Se retornan {} elementos", monitorTO);
        return monitorTO;
    }
}
