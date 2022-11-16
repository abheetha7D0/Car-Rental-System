package lk.carrental.carrental.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ReturnDetailsDTO {
    private String returnId;
    private String vNumber;
    private String returnDate;
    private String lossDamageStatus;
    private double lossDamage;
    private double rentalFee;

    private ReturnCarDTO returnCar ;
    private VehicleDTO vehicle;

}
