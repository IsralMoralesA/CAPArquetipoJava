package mx.com.axity.services.service;

import mx.com.axity.commons.to.OrdersTO;
import mx.com.axity.model.OrdersDO;

import java.util.List;

public interface IordersService {

    List<OrdersTO> getAllOrders();
    OrdersTO getOrdersById(int idorder);

    String saveOrder(OrdersDO order);
}
