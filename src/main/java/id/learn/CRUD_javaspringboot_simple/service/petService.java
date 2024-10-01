package id.learn.CRUD_javaspringboot_simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import id.learn.CRUD_javaspringboot_simple.model.Pet;

@Service
public class petService {

    @Autowired
    private RestTemplate restTemplate;


    public String getPetById(Long id) {
        // URL yang benar harusnya sesuai dengan dokumentasi API
        String url = "https://petstore3.swagger.io/api/v3/pet/" + id;
        
        try {
            // Mengirim request ke API eksternal
            return restTemplate.getForObject(url, String.class);
        } catch (HttpClientErrorException e) {
            System.out.println("HTTP Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            throw e; // Rethrow exception or handle accordingly
        }
    }
    public String createPet(Pet pet) {
        
        String url = "https://petstore3.swagger.io/api/v3/pet";


        try {
            // Mengirim request POST ke API eksternal untuk create pet
            ResponseEntity<String> response = restTemplate.postForEntity(url, pet, String.class);
            return response.getBody(); // Mengembalikan response dari API
        } catch (HttpClientErrorException e) {
            System.out.println("HTTP Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            throw e; // Rethrow exception or handle accordingly
        }
    }

    public String updatePet(Pet pet) {

        String url = "https://petstore3.swagger.io/api/v3/pet";

        try {
            // Mengirim request PUT ke API eksternal untuk update pet
            restTemplate.put(url, pet);
            return "Pet updated successfully";
        } catch (HttpClientErrorException e) {
            System.out.println("HTTP Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            throw e;
        }
    }

    public String deletePetById(Long id) {
        
        String url = "https://petstore3.swagger.io/api/v3/pet/" + id;
        try {
            // Send DELETE request to the external API
            restTemplate.delete(url);
            return "Pet deleted successfully";
        } catch (HttpClientErrorException e) {
            System.out.println("HTTP Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            throw e;
        }
    }

    
}
