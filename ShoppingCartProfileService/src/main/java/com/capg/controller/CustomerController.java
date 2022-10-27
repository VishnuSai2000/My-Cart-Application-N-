package com.capg.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.dto.UserProfileDTO;
import com.capg.entity.UserProfile;
import com.capg.service.ProfileService;
import com.capg.service.SequenceGeneratorService;


@RestController
@RequestMapping("/customers")

public class CustomerController {
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private SequenceGeneratorService service;
	
	@GetMapping("/getall")
	public List<UserProfileDTO> userProfile(){
		return profileService.getAllProfiles();
	}
	
	@GetMapping("/get/{profileId}")
	public UserProfileDTO byProfileId(@PathVariable Integer profileId) {
		return profileService.getByProfileId(profileId);
	}
	
	@PostMapping("/save")
	public ResponseEntity<UserProfileDTO> save(@Valid @RequestBody UserProfileDTO cust) {
		
		cust.setProfileId(service.getSequenceNumber(UserProfile.SEQUENCE_NAME));

		return new ResponseEntity<UserProfileDTO>(profileService.addNewCustomerProfile(cust),HttpStatus.CREATED);
	}
	
//	@PutMapping("/update/{profileId}")
//	public ResponseEntity<UserProfileDTO> update(@PathVariable Integer profileId, @RequestBody UserProfileDTO cust) {
//		return new ResponseEntity<UserProfileDTO>(profileService.updateUserProfile(profileId, cust),HttpStatus.ACCEPTED);
//	}
	
	//the following code is for the update method in mongoDB
	@PutMapping("/update/{profileId}")
	public ResponseEntity<UserProfile> update(@PathVariable Integer profileId,@RequestBody UserProfile user) throws Exception{
		user.setProfileId(profileId);
		return  ResponseEntity.ok().body(this.profileService.updateProfile(user));
	}
	
	@DeleteMapping("/delete/{profileId}")
	public String delete(@PathVariable Integer profileId) {
		profileService.deleteUserProfile(profileId);
		return "Customer With ID "+profileId+" Was Deleted Successfully!!"; 
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		profileService.deleteAllUserProfiles();
		return "All Customers Deleted Successfully!!";
	}
	
	@GetMapping("/getbymail/{emailId}")
	public UserProfileDTO customerBymail(@PathVariable String emailId) {
		return profileService.getByMail(emailId);
	}
	

	
}
	
	

	
/*	@GetMapping("/getUserByName/{productName}")
	public List<Product> getUserByName(@PathVariable String productName){
		return productService.getUserByName(productName);
	}*/

//	
//	@PatchMapping("/partialUpdatelname/{customerId}/{lname}")
//	public ResponseEntity<CustomerDTO> partialupdatelname(@PathVariable Integer customerId,@PathVariable String lname) {
//		return new ResponseEntity<CustomerDTO>(customerService.partialupdateCustomerlname(customerId, lname),HttpStatus.OK);
//	}
//	

//	
//	@PatchMapping("/partialUpdatesalary/{customerId}/{salary}")
//	public ResponseEntity<CustomerDTO> partialupdatesalary(@PathVariable Integer customerId,@PathVariable double salary) {
//		return new ResponseEntity<CustomerDTO>(customerService.partialupdateCustomersalary(customerId, salary),HttpStatus.OK);
//	}
//@GetMapping("/search")
//public List<UserProfileDTO> searchProduct(@RequestParam("query") String query){
//	return profileService.searchCustomers(query);
//}
//@PatchMapping("/partialUpdatefullname/{profileId}/{fullname}")
//public ResponseEntity<UserProfileDTO> partialupdatefname(@PathVariable Integer profileId,@PathVariable String Fullname) {
//	return new ResponseEntity<UserProfileDTO>(profileService.partialupdateCustomerFullName(profileId, Fullname),HttpStatus.OK);
//}
//@PatchMapping("/partialUpdatemail/{profileId}/{emailId}")
//public ResponseEntity<UserProfileDTO> partialupdatemail(@PathVariable Integer profileId,@PathVariable String emailId) {
//	return new ResponseEntity<UserProfileDTO>(profileService.partialupdateUsermail(profileId, emailId),HttpStatus.OK);
//}
	
