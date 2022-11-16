package lk.carrental.carrental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class VehicleSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleScheduleId;
    @NotNull(message = "vehicleStartDate Required")
    private String vehicleStartDate;
    @NotNull(message = "vehicleEndDate Required")
    private String vehicleEndDate;
    @NotNull(message = "vehicleScheduleStatus Required")
    private String vehicleScheduleStatus;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "bookingDetailsId",referencedColumnName = "bookingDetailsId")
    private BookingDetails bookingDetails;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "vehicleNumber", referencedColumnName = "number")
    private Vehicle vehicleNumber;

    public VehicleSchedule(String vehicleStartDate, String vehicleEndDate, String vehicleScheduleStatus, BookingDetails bookingDetails, Vehicle vehicleNumber) {
        this.vehicleStartDate = vehicleStartDate;
        this.vehicleEndDate = vehicleEndDate;
        this.vehicleScheduleStatus = vehicleScheduleStatus;
        this.bookingDetails = bookingDetails;
        this.vehicleNumber = vehicleNumber;
    }
}
