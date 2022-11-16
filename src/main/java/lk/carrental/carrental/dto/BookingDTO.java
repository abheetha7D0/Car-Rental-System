package lk.carrental.carrental.dto;

import lk.carrental.carrental.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BookingDTO {
    private String bookingId;
    private Customer customer;
    List<BookingDetailsDTO> bookingDetails;

    public BookingDTO(String bookingId, Customer customer) {
        this.bookingId = bookingId;
        this.customer = customer;
    }
}
