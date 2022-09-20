package mx.com.axity.commons.to;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class KeyBoardTO implements Serializable {

    private int idkeyboard;
    private String serialnumber;
    private int idinputdevice;
}
