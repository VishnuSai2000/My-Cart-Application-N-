package com.scart.profilemservice.Service;

import com.scart.profilemservice.Model.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileService {
    Profile addNewCustomerProfile(Profile user);
    List<Profile> getAllProfiles();
    Optional<Profile> getByProfileId(int profileId);
    Profile updateProfile(Profile user, int profileId);

    void deleteProfileById(int profileId);

    Optional<Profile> profileByEmailId(String emailId);
}
