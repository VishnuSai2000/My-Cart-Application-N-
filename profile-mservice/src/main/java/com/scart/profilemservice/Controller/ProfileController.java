package com.scart.profilemservice.Controller;

import com.scart.profilemservice.Model.Profile;
import com.scart.profilemservice.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profile")
@CrossOrigin("*")
public class ProfileController {

    @Autowired
    ProfileService service;

    @PostMapping("/save")
    public Profile addNewCustomerProfile(@RequestBody Profile user) {
        return service.addNewCustomerProfile(user);
    }

    @GetMapping("/show")
    public List<Profile> getAllProfiles() {
        return service.getAllProfiles();
    }

    @PutMapping("update/{id}")
    public Profile updateProfile(@RequestBody Profile user, @PathVariable("id") int profileId) {
        return service.updateProfile(user, profileId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProfileById(@PathVariable("id") int profileId) {
        service.deleteProfileById(profileId);
    }

    @GetMapping("/getbymail/{emailId}")
    public Optional<Profile> profileByEmailId(@PathVariable String emailId) {
        return service.profileByEmailId(emailId);
    }
}
