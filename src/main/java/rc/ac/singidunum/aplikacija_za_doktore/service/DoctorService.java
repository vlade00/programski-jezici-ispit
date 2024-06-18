package rc.ac.singidunum.aplikacija_za_doktore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rc.ac.singidunum.aplikacija_za_doktore.entity.Doctor;
import rc.ac.singidunum.aplikacija_za_doktore.model.DoctorModel;
import rc.ac.singidunum.aplikacija_za_doktore.repository.DoctorRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository repository;

    public List<Doctor> getAllDoctors(){

        return repository.findAllByDeletedAtIsNull();
    }

    public Optional<Doctor> getDoctorById(Integer id){
        return repository.findByIdAndDeletedAtIsNull(id);
    }

    public List<Doctor> getDoctorByJmbg(String jmbg){
        return repository.findByJmbgContainsAndDeletedAtIsNull(jmbg);
    }

    public Doctor createDoctor(DoctorModel model){
        Doctor doctor = new Doctor();
        doctor.setName(model.getName());
        doctor.setSurname(model.getSurname());
        doctor.setJmbg(model.getJmbg());
        doctor.setCreatedAt(LocalDateTime.now());
        return repository.save(doctor);
    }

    public Doctor editDoctor(Integer id, DoctorModel model){
        Doctor doctor = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        doctor.setName(model.getName());
        doctor.setSurname(model.getSurname());
        doctor.setJmbg(model.getJmbg());
        doctor.setUpdatedAt(LocalDateTime.now());
        return repository.save(doctor);
    }

    public void deleteDoctor(Integer id){
        Doctor doctor = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        doctor.setDeletedAt(LocalDateTime.now());
        repository.save(doctor);
    }
}
