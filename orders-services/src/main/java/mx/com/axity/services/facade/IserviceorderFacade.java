package mx.com.axity.services.facade;

import mx.com.axity.commons.to.ComputerTO;
import mx.com.axity.commons.to.OrdersTO;
import mx.com.axity.commons.to.ServiceOrderTO;
import mx.com.axity.model.ServiceOrderDO;

import java.util.List;

public interface IserviceorderFacade {


    ServiceOrderTO getServiceOrderById(int serviceorder);
    List<ServiceOrderTO> getAllServiceOrder();
    List<ServiceOrderTO> getAllServiceOrderByOrderId(int idorder);
    String saveNewComputerInOrder(int idorder, ComputerTO computer);

}
