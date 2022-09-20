package mx.com.axity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "keyboard")
@NoArgsConstructor
@AllArgsConstructor
public class KeyBoardDO implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idkeyboard")
    private int idkeyboard;
    @Column(name = "serialnumber")
    private String serialnumber;
    @Column(name = "idinputdevice")
    private int idinputdevice;
}
