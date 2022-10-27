package com.scart.profilemservice.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "Profiless")
public class Profile {
    @Transient
    public static final String SEQUENCE_NAME = "profile_sequence";

    @Id
    private int profileId;


    @NotBlank(message = "name must not be null or empty")
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String fullName;


    @Email(message = "not a valid email")
    private String emailId;

    @NotBlank(message = "password is required")
    @Size(min = 4, max = 10)
    private String password;

    @NotNull(message="Contact cannot be empty")

    private String mobileNumber;

    @NotBlank(message = "name must not be null or empty")
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String gender;

   // @NotNull(message = "add address for delivery")
   @NotBlank(message = "address is required")
    private List<Address> address;



}
