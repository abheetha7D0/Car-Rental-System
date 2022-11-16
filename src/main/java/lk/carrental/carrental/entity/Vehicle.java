package lk.carrental.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class Vehicle {

    @Id
    private String number;
    private String type;
    private String brand;
    private String transmissionType;
    private int noOfPassenger;
    private String color;
    private double dailyRent; //Rs
    private double MonthlyRent; //Rs
    private double toKMRent; //Rs
    private double extraPerKMRent; //Rs
    private String status;
    private String frontPhoto;
    private String backPhoto;
    private String side1Photo;
    private String side2Photo;

}
