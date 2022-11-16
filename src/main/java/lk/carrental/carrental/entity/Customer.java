package lk.carrental.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Size(min = 3, max = 25, message = "Name Invalid")
    private String name;

    @Size(min = 3, max = 50, message = "Address Invalid")
    private String address;

    @Size(min = 9, max = 10, message = "contactNumber Invalid")
    private String contactNumber;

    @Email(message = "email Invalid")
    private String email;

    @Size(min = 4, max = 50,message = "password Invalid")
    private String password;

    @NotNull(message = "licenseNumber Required")
    private String licenseNumber;

    @NotNull(message = "licensePhoto Required")
    private String licensePhoto;

    @NotNull(message = "NICPhoto Required")
    private String nICPhoto;

}
