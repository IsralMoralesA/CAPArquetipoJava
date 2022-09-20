package mx.com.axity.services.service.impl;

import mx.com.axity.commons.to.OrdersTO;
import mx.com.axity.commons.to.ServiceOrderTO;
import mx.com.axity.model.OrdersDO;
import mx.com.axity.persistence.OrdersDAO;
import mx.com.axity.services.service.IordersService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class ordersServiceImpl implements IordersService {

    static final Logger LOG = LogManager.getLogger(ordersServiceImpl.class);

    @Autowired
    OrdersDAO ordersDAO;

    @Autowired
    serviceorderServiceImpl serviceorder;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<OrdersTO> getAllOrders() {
        LOG.info("Consultando ordenes");
        List<OrdersDO> ordersDO =(List<OrdersDO>) this.ordersDAO.findAll();
        Type ordersDAOType = new TypeToken<List<OrdersTO>>() {}.getType();
        List<OrdersTO> ordersTO = this.modelMapper.map(ordersDO, ordersDAOType);
        for (OrdersTO order: ordersTO){
            order.setServiceOrderTOS(getAllServiceOrder(order.getIdorder()));
            order.setCountComputers(order.getServiceOrderTOS().size());
        }
        LOG.info("Se retornan {} elementos", ordersTO.size());
        return ordersTO;
    }

    @Override
    public OrdersTO getOrdersById(int idorder) {
        LOG.info("Consultando orden por id");
        OrdersDO ordersDO = this.ordersDAO.findByIdorder(idorder);
        if (ordersDO == null){
            LOG.info("Regresa NULL");
            return null;
        }else{
            Type ordersDAOType = new TypeToken<OrdersTO>() {}.getType();
            OrdersTO ordersTO = this.modelMapper.map(ordersDO, ordersDAOType);
            ordersTO.setServiceOrderTOS(getAllServiceOrder(ordersTO.getIdorder()));
            ordersTO.setCountComputers(ordersTO.getServiceOrderTOS().size());
            LOG.info("Se retornan elemento", ordersTO);
            return ordersTO;
        }
    }

    @Override
    public String saveOrder(OrdersDO order) {
        OrdersDO orderDO = new OrdersDO();
        orderDO.setCustomername(order.getCustomername());
        ordersDAO.save(orderDO);
        return "Orden guardada con exito, id: "+orderDO.getIdorder();
    }

    private List<ServiceOrderTO> getAllServiceOrder(int  idorder){
        return serviceorder.getAllServiceOrderByIdOrder(idorder);
    }

}
