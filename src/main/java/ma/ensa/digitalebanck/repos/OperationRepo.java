package ma.ensa.digitalebanck.repos;

import ma.ensa.digitalebanck.entities.Acount;
import ma.ensa.digitalebanck.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepo extends JpaRepository<Operation,Long> {
}
