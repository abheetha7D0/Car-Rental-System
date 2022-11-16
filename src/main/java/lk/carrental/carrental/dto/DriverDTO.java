package lk.carrental.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DriverDTO {
    private String licenseNumber;
    private String name;
    private String address;
    private String contactNumber;
    private String licensePhoto;
    private String status;
}
