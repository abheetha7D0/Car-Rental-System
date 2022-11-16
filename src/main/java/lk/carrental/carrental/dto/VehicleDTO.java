package lk.carrental.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class VehicleDTO {
    private String number;
    private String type;
    private String brand;
    private String transmissionType;
    private int noOfPassenger;
    private String color;
    private double dailyRent; //Rs
    private double monthlyRent; //Rs
    private double toKMRent; //Rs
    private double extraPerKMRent; //Rs
    private String status;
    private String frontPhoto;
    private String backPhoto;
    private String side1Photo;
    private String side2Photo;
}
