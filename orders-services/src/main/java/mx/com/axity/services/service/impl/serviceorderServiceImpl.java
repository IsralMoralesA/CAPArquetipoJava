package mx.com.axity.services.service.impl;

import mx.com.axity.commons.to.ComputerTO;
import mx.com.axity.commons.to.OrdersTO;
import mx.com.axity.commons.to.ServiceOrderTO;
import mx.com.axity.model.OrdersDO;
import mx.com.axity.model.ServiceOrderDO;
import mx.com.axity.persistence.OrdersDAO;
import mx.com.axity.persistence.ServiceOrderDAO;
import mx.com.axity.services.service.IordersService;
import mx.com.axity.services.service.IserviceorderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class serviceorderServiceImpl implements IserviceorderService {

    static final Logger LOG = LogManager.getLogger(serviceorderServiceImpl.class);

    @Autowired
    ServiceOrderDAO serviceorderDAO;

    @Autowired
    computerServiceImpl computerService;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<ServiceOrderTO> getAllServiceOrders() {
        LOG.info("Consultando All Service Orders");
        List<ServiceOrderDO> serviceorderDO =(List<ServiceOrderDO>) this.serviceorderDAO.findAll();
        Type DAOType = new TypeToken<List<ServiceOrderTO>>() {}.getType();
        List<ServiceOrderTO> serviceorderTO = this.modelMapper.map(serviceorderDO, DAOType);
        for (ServiceOrderTO serviceorder: serviceorderTO) {
            serviceorder.setComputer(computerService.getComputeryId(serviceorder.getIdcomputer()));
        }
        LOG.info("Se retornan {} elementos", serviceorderTO.size());
        return serviceorderTO;
    }

    @Override
    public List<ServiceOrderTO> getAllServiceOrderByIdOrder(int idorder) {
        LOG.info("Consultando All Service Orders by Id Orders");
        List<ServiceOrderDO> serviceorderDO =(List<ServiceOrderDO>) this.serviceorderDAO.findAllByIdorder(idorder);
        Type DAOType = new TypeToken<List<ServiceOrderTO>>() {}.getType();
        List<ServiceOrderTO> serviceorderTO = this.modelMapper.map(serviceorderDO, DAOType);
        for (ServiceOrderTO serviceorder: serviceorderTO) {
            serviceorder.setComputer(computerService.getComputeryId(serviceorder.getIdcomputer()));
        }
        LOG.info("Se retornan {} elementos", serviceorderTO.size());
        return serviceorderTO;
    }

    @Override
    public ServiceOrderTO getSerivceOrderById(int serviceid) {
        LOG.info("Consultando Service Orders by Id ");
        ServiceOrderDO serviceorderDO = this.serviceorderDAO.findByIdserviceorder(serviceid);
        Type DAOType = new TypeToken<ServiceOrderTO>() {}.getType();
        ServiceOrderTO serviceorderTO = this.modelMapper.map(serviceorderDO, DAOType);
        serviceorderTO.setComputer(computerService.getComputeryId(serviceorderTO.getIdcomputer()));
        LOG.info("Se retornan {} elementos", serviceorderTO);
        return serviceorderTO;
    }

    @Override
    public String saveNewComputerInOrder(int idorder, ComputerTO computer) {
        if (getAllServiceOrderByIdOrder(idorder).size() > 4){
            return "La orden no puede tener mas de 5 computadoras, error";
        }else{
            int idcomputer = computerService.saveComputer(computer);
            ServiceOrderDO serviceorderDo = new ServiceOrderDO();
            serviceorderDo.setIdorder(idorder);
            serviceorderDo.setIdcomputer(idcomputer);
            serviceorderDAO.save(serviceorderDo);
            return "Se agrego correctamente la computadora al orden";
        }
    }
}
