package mx.com.axity.services.facade;

import mx.com.axity.commons.to.ComputerTO;
import mx.com.axity.commons.to.OrdersTO;

import java.util.List;

public interface IcomputerFacade {
    ComputerTO getComputerById(int idcomputer);

    int saveComputer(ComputerTO computer);
}
