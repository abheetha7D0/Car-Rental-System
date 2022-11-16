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
@ToString
@Entity
public class BookingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingDetailsId;

    private String pickUpDate;
    private String returnDate;
    private double loseDamagePrice;
    private String loseDamageImage;
    private String bookingStatus;
    private String customerNIC;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "bookingId",referencedColumnName = "bookingId")
    private Booking bookingId;

    public BookingDetails(String pickUpDate, String returnDate, double loseDamagePrice, String loseDamageImage, String bookingStatus, String customerNIC, Booking bookingId) {
        this.pickUpDate = pickUpDate;
        this.returnDate = returnDate;
        this.loseDamagePrice = loseDamagePrice;
        this.loseDamageImage = loseDamageImage;
        this.bookingStatus = bookingStatus;
        this.customerNIC = customerNIC;
        this.bookingId = bookingId;
    }
}