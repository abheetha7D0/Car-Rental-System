package lk.carrental.carrental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String bookingId;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "customerNICNumber",referencedColumnName = "id",nullable = false)
    private Customer customer;

    @JsonIgnore
    @OneToMany(mappedBy = "bookingId",cascade = CascadeType.ALL)
    private List<BookingDetails> bookingDetails;

    public Booking(String bookingId, Customer customer) {
        this.bookingId = bookingId;
        this.customer = customer;
    }
}
