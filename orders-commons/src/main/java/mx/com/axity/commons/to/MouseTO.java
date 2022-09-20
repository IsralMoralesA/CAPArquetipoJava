package mx.com.axity.commons.to;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MouseTO implements Serializable {

    private int idmouse;
    private String serialnumber;
    private int idinputdevice;
}
