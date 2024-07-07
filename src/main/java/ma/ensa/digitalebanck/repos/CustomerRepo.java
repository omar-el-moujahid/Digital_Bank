package ma.ensa.digitalebanck.repos;

import ma.ensa.digitalebanck.entities.Acount;
import ma.ensa.digitalebanck.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {
}
