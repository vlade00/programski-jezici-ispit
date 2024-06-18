package rc.ac.singidunum.aplikacija_za_doktore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rc.ac.singidunum.aplikacija_za_doktore.entity.Doctor;
import java.util.List;
import java.util.Optional;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    List<Doctor> findAllByDeletedAtIsNull();

    Optional<Doctor> findByIdAndDeletedAtIsNull(Integer id);

    //Napravimo ovo da bi u servisu pozvali i pronasli doktora po jmbgu i Contains je za kad ukucas pretragu samo 31 a ne ceo Jmbg da izadje taj doktor
    List<Doctor> findByJmbgContainsAndDeletedAtIsNull(String jmbg);


}
