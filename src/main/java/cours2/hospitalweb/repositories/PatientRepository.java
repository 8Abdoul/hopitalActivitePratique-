package cours2.hospitalweb.repositories;

import cours2.hospitalweb.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
