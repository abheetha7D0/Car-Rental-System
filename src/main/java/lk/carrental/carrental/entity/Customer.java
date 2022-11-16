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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class Customer {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    //@NotBlank(message = "Name is mandatory")
    private String name;
    private String address;
    private String contactNumber;
    private String email;
    private String password;
    private String licenseNumber;
    private String licensePhoto;
    private String NICPhoto;

}
