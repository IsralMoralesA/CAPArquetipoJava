package mx.com.axity.services.facade.impl;

import mx.com.axity.commons.to.KeyBoardTO;
import mx.com.axity.commons.to.MouseTO;
import mx.com.axity.services.facade.IkeyboardFacade;
import mx.com.axity.services.facade.ImouseFacade;
import mx.com.axity.services.service.IkeyboardService;
import mx.com.axity.services.service.ImouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class keyboardFacade implements IkeyboardFacade {

    @Autowired
    private IkeyboardService keyboardService;

    @Override
    public KeyBoardTO getKeyBoardById(int idkeyboard) {
        return this.keyboardService.getKeyBoardById(idkeyboard);
    }
}
