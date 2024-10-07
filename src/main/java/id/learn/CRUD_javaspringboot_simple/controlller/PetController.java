package id.learn.CRUD_javaspringboot_simple.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import id.learn.CRUD_javaspringboot_simple.model.Pet;
import id.learn.CRUD_javaspringboot_simple.service.petService;

@RestController
@RequestMapping("/api/phonebooks")
@CrossOrigin(origins = "http://localhost:3000")
public class PetController {

@Autowired
private petService petService;

//PET MICROSERVICE

// Create
@PostMapping("/pet")
public ResponseEntity<String> createPet(@RequestBody Pet pet) {
    String response = petService.createPet(pet); // Call service method to create pet
    return new ResponseEntity<>(response, HttpStatus.CREATED); // Return HTTP 201 Created
}

//update
@PutMapping("/pet")
public ResponseEntity<String> updatePet(@RequestBody Pet pet) {
    String response = petService.updatePet(pet);
    return new ResponseEntity<>(response, HttpStatus.OK); // Return HTTP 200 OK
}

//get byid
@GetMapping("/pet/{id}")
public ResponseEntity<String> getPetById(@PathVariable("id") Long id) {
    String response = petService.getPetById(id); 
    return new ResponseEntity<>(response, HttpStatus.OK);
}

//delete
@DeleteMapping("/pet/{id}")
public ResponseEntity<String> deletePet(@PathVariable Long id) {
    String response = petService.deletePetById(id);
    return new ResponseEntity<>(response, HttpStatus.OK);
}


}
