package lk.carrental.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class Vehicle {

    @Id
    private String number;
    @Size(min = 3, max = 50, message = "type Invalid")
    private String type;
    @Size(min = 3, max = 50, message = "type Invalid")
    private String brand;
    @Size(min = 3, max = 50, message = "type Invalid")
    private String transmissionType;
    @Size(min = 3, max = 50, message = "type Invalid")
    private int noOfPassenger;
    @Size(min = 3, max = 50, message = "type Invalid")
    private String color;
    @Size(min = 3, max = 50, message = "type Invalid")
    private double dailyRent; //Rs
    @Size(min = 3, max = 50, message = "type Invalid")
    private double MonthlyRent; //Rs
    @Size(min = 3, max = 50, message = "type Invalid")
    private double toKMRent; //Rs
    @Size(min = 3, max = 50, message = "type Invalid")
    private double extraPerKMRent; //Rs
    @NotNull(message = "status Required")
    private String status;
    @NotNull(message = "frontPhoto Required")
    private String frontPhoto;
    @NotNull(message = "backPhoto Required")
    private String backPhoto;
    @NotNull(message = "side1Photo Required")
    private String side1Photo;
    @NotNull(message = "side2Photo Required")
    private String side2Photo;

}
