package mx.com.axity.services.facade.impl;

import mx.com.axity.commons.to.OrdersTO;
import mx.com.axity.model.OrdersDO;
import mx.com.axity.services.facade.IordersFacade;
import mx.com.axity.services.service.IordersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ordersFacade implements IordersFacade {

    @Autowired
    private IordersService ordersService;

    public List<OrdersTO> getAllOrders() {
        return this.ordersService.getAllOrders();
    }

    @Override
    public OrdersTO getOrdersById(int idorder) {
        return this.ordersService.getOrdersById(idorder);
    }

    @Override
    public String saveOrder(OrdersDO order) {
        return this.ordersService.saveOrder(order);
    }
}
