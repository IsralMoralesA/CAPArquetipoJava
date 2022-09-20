package mx.com.axity.services.service;

import mx.com.axity.commons.to.ComputerTO;
import mx.com.axity.commons.to.OrdersTO;
import mx.com.axity.commons.to.ServiceOrderTO;

import java.util.List;

public interface IserviceorderService {

    List<ServiceOrderTO> getAllServiceOrders();
    List<ServiceOrderTO> getAllServiceOrderByIdOrder(int idorder);
    ServiceOrderTO getSerivceOrderById(int serviceid);
    String saveNewComputerInOrder(int idorder, ComputerTO computer);
}
