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
@Table(name = "mouse")
@NoArgsConstructor
@AllArgsConstructor
public class MouseDO implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idmouse")
    private int idmouse;
    @Column(name = "serialnumber")
    private String serialnumber;
    @Column(name = "idinputdevice")
    private int idinputdevice;
}
