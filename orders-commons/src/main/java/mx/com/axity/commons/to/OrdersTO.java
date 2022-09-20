package mx.com.axity.commons.to;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class OrdersTO implements Serializable {

    private int idorder;
    private String dateorder;
    private String customername;
    private int countComputers;
    private List<ServiceOrderTO> serviceOrderTOS;

}