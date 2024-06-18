package rc.ac.singidunum.aplikacija_za_doktore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rc.ac.singidunum.aplikacija_za_doktore.entity.Doctor;

import rc.ac.singidunum.aplikacija_za_doktore.model.DoctorModel;
import rc.ac.singidunum.aplikacija_za_doktore.service.DoctorService;

import java.util.List;

@RestController
//Mapiranje ka nekoj putanji
@RequestMapping(path = "/api/doctor")
//Konstruktor za repository;
@RequiredArgsConstructor
@CrossOrigin
public class DoctorController {

    private final DoctorService service;

    //Vraca sve doktore putanjom/doktor
    @GetMapping
    public List<Doctor> getAllDoctors(){
        return service.getAllDoctors();
    }

    //Za pretrazivanje po putanji /doktor/1    (Sa id-em 1,2...)
    //ResponseEntity - ako ne nadje doktora sa tim Id-em, vraca 404 not found gresku
    @GetMapping(path="/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Integer id){
        return ResponseEntity.of(service.getDoctorById(id));
    }

    @GetMapping(path="/jmbg/{jmbg}")
    public List<Doctor> getDoctorByJmbg(@PathVariable String jmbg){
        return service.getDoctorByJmbg(jmbg);
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody DoctorModel doctor){
        return service.createDoctor(doctor);
    }

    @PutMapping(path="/{id}")
    public Doctor editDoctor(@PathVariable Integer id, @RequestBody DoctorModel doctor){
        return service.editDoctor(id, doctor);
    }

    @DeleteMapping(path="/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteDoctor(@PathVariable Integer id){
        service.deleteDoctor(id);
    }


}
