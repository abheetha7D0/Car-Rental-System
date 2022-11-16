package lk.carrental.carrental.service;



import lk.carrental.carrental.dto.BookingDTO;

import java.util.List;

public interface BookingService {
    public String getLastRid();
    void saveBooking(BookingDTO dto);
    void deleteBooking(String id);
    void updateBooking(BookingDTO dto);
    BookingDTO searchBooking(String id);
    List<BookingDTO> getAllBooking();

}
