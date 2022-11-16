package lk.carrental.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String NICNumber;
    private String name;
    private String address;
    private String contactNumber;
    private String email;
    private String password;
    private String licenseNumber;
    private String licensePhoto;
    private String NICPhoto;
    private String status;
}
