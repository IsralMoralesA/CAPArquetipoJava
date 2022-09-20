package mx.com.axity.services.facade.impl;

import mx.com.axity.commons.to.MonitorTO;
import mx.com.axity.commons.to.MouseTO;
import mx.com.axity.services.facade.ImonitorFacade;
import mx.com.axity.services.facade.ImouseFacade;
import mx.com.axity.services.service.ImonitorService;
import mx.com.axity.services.service.ImouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class mouseFacade implements ImouseFacade {

    @Autowired
    private ImouseService mouseService;

    @Override
    public MouseTO getMouseById(int idmouse) {
        return this.mouseService.getMouseById(idmouse);
    }
}
