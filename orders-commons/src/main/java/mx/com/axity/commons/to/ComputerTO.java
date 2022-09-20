package mx.com.axity.commons.to;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ComputerTO implements Serializable {

    private int idcomputer;
    private String brand;
    private String serialnumber;
    private int idmonitor;
    private int idmouse;
    private int idkeyboard;
    private MonitorTO monitor;
    private MouseTO mouse;
    private KeyBoardTO keyboard;

}
