package mx.com.axity.services.facade.impl;

import mx.com.axity.commons.to.ComputerTO;
import mx.com.axity.commons.to.OrdersTO;
import mx.com.axity.services.facade.IcomputerFacade;
import mx.com.axity.services.facade.IordersFacade;
import mx.com.axity.services.service.IcomputerService;
import mx.com.axity.services.service.IordersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class computerFacade implements IcomputerFacade {

    @Autowired
    private IcomputerService computerService;

    @Override
    public ComputerTO getComputerById(int idcomputer) {
        return this.computerService.getComputeryId(idcomputer);
    }

    @Override
    public int saveComputer(ComputerTO computer) {
        return this.computerService.saveComputer(computer);
    }
}
