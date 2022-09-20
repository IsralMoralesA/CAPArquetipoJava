package mx.com.axity.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "computer")
@NoArgsConstructor
@AllArgsConstructor
public class ComputerDO implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idcomputer")
    private int idcomputer;
    @Column(name = "brand")
    private String brand;
    @Column(name = "serialnumber")
    private String serialnumber;
    @Column(name = "idmonitor")
    private int idmonitor;
    @Column(name = "idmouse")
    private int idmouse;
    @Column(name = "idkeyboard")
    private int idkeyboard;

}
