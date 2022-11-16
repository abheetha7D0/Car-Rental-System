package lk.carrental.carrental.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class DriverSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int diverScheduleId;
    private String driverStartDate;
    private String driverEndDate;
    private String driverScheduleStatus;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "bookingDetailsId",referencedColumnName = "bookingDetailsId")
    private BookingDetails bookingDetails;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "licenseNumber", referencedColumnName = "licenseNumber", nullable = false)
    private Driver driverId;

    public DriverSchedule(String driverStartDate, String driverEndDate, String driverScheduleStatus, BookingDetails bookingDetails, Driver driverId) {
        this.driverStartDate = driverStartDate;
        this.driverEndDate = driverEndDate;
        this.driverScheduleStatus = driverScheduleStatus;
        this.bookingDetails = bookingDetails;
        this.driverId = driverId;
    }
}
