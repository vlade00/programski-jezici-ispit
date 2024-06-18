package rc.ac.singidunum.aplikacija_za_doktore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rc.ac.singidunum.aplikacija_za_doktore.entity.DoctorSpecialization;

import java.util.List;
import java.util.Optional;

@Repository

public interface DoctorSpecializationRepository extends JpaRepository<DoctorSpecialization, Integer> {
    List<DoctorSpecialization> findAllByDeletedAtIsNull();

    Optional<DoctorSpecialization> findByIdAndDeletedAtIsNull(Integer id);
}
