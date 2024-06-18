package rc.ac.singidunum.aplikacija_za_doktore.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rc.ac.singidunum.aplikacija_za_doktore.entity.DoctorSpecialization;
import rc.ac.singidunum.aplikacija_za_doktore.model.DoctorSpecializationModel;
import rc.ac.singidunum.aplikacija_za_doktore.service.DoctorSpecializationService;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path = "/api/doctor-specialization")
public class DoctorSpecializationController {

    private final DoctorSpecializationService service;

    @GetMapping
    public List<DoctorSpecialization> getAll(){
        return service.getAllDoctorSpecializations();
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<DoctorSpecialization> getById(@PathVariable Integer id){
        return ResponseEntity.of(service.getDoctorSpecializationById(id));
    }

    @PostMapping
    public DoctorSpecialization create(@RequestBody DoctorSpecializationModel model){
        return service.saveDoctorSpecialization(model);
    }

    @PutMapping(path="/{id}")
    public DoctorSpecialization update(@PathVariable Integer id, @RequestBody DoctorSpecializationModel model){
        return service.updateDoctorSpecialization(id, model);
    }

    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        service.deleteDoctorSpecialization(id);
    }



}
