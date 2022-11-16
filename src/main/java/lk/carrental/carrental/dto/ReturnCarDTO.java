package lk.carrental.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ReturnCarDTO {
    private String id;
    private CustomerDTO customerId;
    private BookingDTO bookingId;
    private List<ReturnDetailsDTO> returnDetails;
}
