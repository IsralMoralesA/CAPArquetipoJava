package mx.com.axity.commons.to;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ServiceOrderTO implements Serializable {

    private int idserviceorder;
    private int idorder;
    private int idcomputer;
    private ComputerTO computer;
}
