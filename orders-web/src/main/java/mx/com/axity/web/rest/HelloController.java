package mx.com.axity.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mx.com.axity.commons.to.ComputerTO;
import mx.com.axity.commons.to.OrdersTO;
import mx.com.axity.model.ComputerDO;
import mx.com.axity.model.OrdersDO;
import mx.com.axity.persistence.ComputerDAO;
import mx.com.axity.services.facade.IcomputerFacade;
import mx.com.axity.services.facade.IordersFacade;
import mx.com.axity.services.facade.IserviceorderFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("serviceorders/v1")
@Api(value="orders")
public class HelloController {

    static final Logger LOG = LogManager.getLogger(HelloController.class);

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    IordersFacade IordersFacade;

    @Autowired
    IserviceorderFacade IserviceorderFacade;


    @Autowired
    ComputerDAO computerDAO;

    @GetMapping(value = "/orders", produces = "application/json")
    @ApiOperation(value = "Buscar Ordenes",
            notes = "Retorna todas las ordenes",
            response = OrdersTO.class,
            produces = "application/json")
    public ResponseEntity<List<OrdersTO>> getAllOrders() {
        List<OrdersTO> orders = this.IordersFacade.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping(value = "/orders/{id}", produces = "application/json")
    @ApiOperation(value = "Buscar Orden por id",
            notes = "Regresa la orden por id",
            response = OrdersTO.class,
            produces = "application/json")
    public ResponseEntity<OrdersTO> getOrderById(@PathVariable("id") int id) {
        OrdersTO orders = this.IordersFacade.getOrdersById(id);
        if (orders != null){
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(orders, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/orders/{id}", produces = "application/json",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Ingresar una nueva Computadora a una orden",
            notes = "Ingresar una nueva computadora con teclado, monitor y mouse a una orden",
            response = ComputerTO.class,
            produces = "application/json")
    public ResponseEntity createNewComputerInOrder(@PathVariable("id") int id,@RequestBody ComputerTO computer) {
        String result = this.IserviceorderFacade.saveNewComputerInOrder(id,computer);
        return new ResponseEntity<>("{"+result+"}", HttpStatus.OK);
    }

    @PostMapping(value = "/orders/", produces = "application/json",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Ingresar una orden",
            notes = "Ingresar una nueva orden",
            response = OrdersDO.class,
            produces = "application/json")
    public ResponseEntity createOrder(@RequestBody OrdersDO order) {
        // = this.IcomputerFacade.saveComputer(id,computer);
        String result= IordersFacade.saveOrder(order);
        return new ResponseEntity<>("{"+result+"}", HttpStatus.OK);
    }

    @GetMapping(value = "/ping", produces = "application/json")
    @ApiOperation(value = "Ping",
            notes = "Pong",
            produces = "application/json")
    public ResponseEntity test() {
        return new ResponseEntity<>("{pong}", HttpStatus.OK);
    }
}
