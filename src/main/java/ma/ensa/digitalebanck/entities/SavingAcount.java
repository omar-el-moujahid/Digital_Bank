package ma.ensa.digitalebanck.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@DiscriminatorValue("SAV")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class  SavingAcount extends Acount {
    private  double InterestRate ;
}
