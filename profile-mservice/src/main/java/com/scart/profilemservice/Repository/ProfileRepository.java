package com.scart.profilemservice.Repository;


import com.scart.profilemservice.Model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, Integer> {

    @Query("{'emailId' : ?0}")
    Optional<Profile> findByEmailId(String emailId);
}
