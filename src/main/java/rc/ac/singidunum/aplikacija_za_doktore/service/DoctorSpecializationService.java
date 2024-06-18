package rc.ac.singidunum.aplikacija_za_doktore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rc.ac.singidunum.aplikacija_za_doktore.entity.DoctorSpecialization;
import rc.ac.singidunum.aplikacija_za_doktore.model.DoctorSpecializationModel;
import rc.ac.singidunum.aplikacija_za_doktore.repository.DoctorSpecializationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorSpecializationService {

    private final DoctorSpecializationRepository repository;

    public List<DoctorSpecialization> getAllDoctorSpecializations(){
        return repository.findAllByDeletedAtIsNull();
    }

    public Optional<DoctorSpecialization> getDoctorSpecializationById(Integer id){
       return repository.findByIdAndDeletedAtIsNull(id);
    }

    public DoctorSpecialization saveDoctorSpecialization(DoctorSpecializationModel model){
        DoctorSpecialization specialization = new DoctorSpecialization();
        specialization.setName(model.getName());
        specialization.setCreatedAt(LocalDateTime.now());
        return repository.save(specialization);
    }

    public DoctorSpecialization updateDoctorSpecialization(Integer id, DoctorSpecializationModel model){
        DoctorSpecialization specialization = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        specialization.setName(model.getName());
        specialization.setUpdatedAt(LocalDateTime.now());
        return repository.save(specialization);
    }

    public void deleteDoctorSpecialization(Integer id){
        DoctorSpecialization specialization = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        specialization.setDeletedAt(LocalDateTime.now());
        repository.save(specialization);
    }
}
