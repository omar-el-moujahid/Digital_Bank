package ma.ensa.digitalebanck.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ensa.digitalebanck.entities.enums.Enumtype;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Operation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date operationDate;
    private  double amount ;
    @Enumerated(EnumType.STRING)
    private Enumtype type;
    @ManyToOne
    private Acount acount ;
}
