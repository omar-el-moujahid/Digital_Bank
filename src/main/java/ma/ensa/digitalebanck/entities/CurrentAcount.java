package ma.ensa.digitalebanck.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@DiscriminatorValue("CUR")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentAcount extends Acount {
   private double  overDaft ;
}

