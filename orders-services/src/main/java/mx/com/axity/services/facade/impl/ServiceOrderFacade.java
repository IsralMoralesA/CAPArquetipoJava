package mx.com.axity.services.facade.impl;

import mx.com.axity.commons.to.ComputerTO;
import mx.com.axity.commons.to.OrdersTO;
import mx.com.axity.commons.to.ServiceOrderTO;
import mx.com.axity.model.ServiceOrderDO;
import mx.com.axity.services.facade.IordersFacade;
import mx.com.axity.services.facade.IserviceorderFacade;
import mx.com.axity.services.service.IordersService;
import mx.com.axity.services.service.IserviceorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceOrderFacade implements IserviceorderFacade {

    @Autowired
    private IserviceorderService serviceorderService;


    @Override
    public ServiceOrderTO getServiceOrderById(int serviceorder) {
        return this.serviceorderService.getSerivceOrderById(serviceorder);
    }

    @Override
    public List<ServiceOrderTO> getAllServiceOrder() {
        return this.serviceorderService.getAllServiceOrders();
    }

    @Override
    public List<ServiceOrderTO> getAllServiceOrderByOrderId(int idorder) {
        return this.serviceorderService.getAllServiceOrderByIdOrder(idorder);
    }

    @Override
    public String saveNewComputerInOrder(int idorder, ComputerTO computer) {
        return this.serviceorderService.saveNewComputerInOrder(idorder,computer);
    }
}
