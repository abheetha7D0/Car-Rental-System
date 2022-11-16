package lk.carrental.carrental.dto;

import lk.carrental.carrental.entity.BookingDetails;
import lk.carrental.carrental.entity.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DriverScheduleDTO {
    private int diverScheduleId;
    private String driverStartDate;
    private String driverEndDate;
    private String driverScheduleStatus;
    private BookingDetails bookingDetails;
    private Driver driverId;
}
