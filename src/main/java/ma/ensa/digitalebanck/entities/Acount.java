package ma.ensa.digitalebanck.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ensa.digitalebanck.entities.enums.EnumAccount;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length = 3 , name = "type" )
public class Acount {
    @Id
    private String id ;
    private Date creationdate;
    private  double balance ;
    @Enumerated(EnumType.STRING)
    private EnumAccount satatus;
    private String cuurency;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "acount")
    private Collection<Operation>  operations = new ArrayList<>();
}
