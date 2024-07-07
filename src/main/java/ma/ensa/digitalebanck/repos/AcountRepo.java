package ma.ensa.digitalebanck.repos;

import ma.ensa.digitalebanck.entities.Acount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcountRepo extends JpaRepository<Acount,String> {
}
