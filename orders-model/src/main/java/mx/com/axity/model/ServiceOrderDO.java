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
@Table(name = "serviceorder")
@NoArgsConstructor
@AllArgsConstructor
public class ServiceOrderDO implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idserviceorder")
    private int idserviceorder;
    @Column(name = "idorder")
    private int idorder;
    @Column(name = "idcomputer")
    private int idcomputer;
}
