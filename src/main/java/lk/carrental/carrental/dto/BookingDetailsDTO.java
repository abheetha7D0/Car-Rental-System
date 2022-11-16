package lk.carrental.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BookingDetailsDTO {
    private int bookingDetailsId;
    private String pickUpDate;
    private String returnDate;
    private double loseDamagePrice;
    private String loseDamageImage;
    private String bookingStatus;
    private String customerNIC;/*
    private Booking bookingId;*/
    private String bookingId;
    private String number;
    private String driverStatus;

    public BookingDetailsDTO(int bookingDetailsId, String pickUpDate, String returnDate, double loseDamagePrice, String loseDamageImage, String bookingStatus, String customerNIC, String bookingId) {
        this.bookingDetailsId = bookingDetailsId;
        this.pickUpDate = pickUpDate;
        this.returnDate = returnDate;
        this.loseDamagePrice = loseDamagePrice;
        this.loseDamageImage = loseDamageImage;
        this.bookingStatus = bookingStatus;
        this.customerNIC = customerNIC;
        this.bookingId = bookingId;
    }

}
