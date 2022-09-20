package mx.com.axity.services.facade.impl;

import mx.com.axity.commons.to.ComputerTO;
import mx.com.axity.commons.to.MonitorTO;
import mx.com.axity.services.facade.IcomputerFacade;
import mx.com.axity.services.facade.ImonitorFacade;
import mx.com.axity.services.service.IcomputerService;
import mx.com.axity.services.service.ImonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class monitorFacade implements ImonitorFacade {

    @Autowired
    private ImonitorService monitorService;

    @Override
    public MonitorTO getMonitorById(int idmonitor) {
        return this.monitorService.getMonitorById(idmonitor);
    }
}
