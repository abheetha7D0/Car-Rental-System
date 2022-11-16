package lk.carrental.carrental.dto;

import lk.carrental.carrental.entity.BookingDetails;
import lk.carrental.carrental.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class VehicleScheduleDTO {
    private int vehicleScheduleId;
    private String vehicleStartDate;
    private String vehicleEndDate;
    private String vehicleScheduleStatus;
    private BookingDetails bookingDetails;
    private Vehicle vehicleNumber;
}
