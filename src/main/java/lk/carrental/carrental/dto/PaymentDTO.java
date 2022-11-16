package lk.carrental.carrental.dto;

import lk.carrental.carrental.entity.Booking;
import lk.carrental.carrental.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PaymentDTO {
    private int paymentId;
    private double finalPrice;
    private Booking bookingId;
    private Customer custNICNumber;
}
