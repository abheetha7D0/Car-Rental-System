package lk.carrental.carrental.service.impl;


import lk.carrental.carrental.dto.BookingDetailsDTO;
import lk.carrental.carrental.entity.Booking;
import lk.carrental.carrental.entity.BookingDetails;
import lk.carrental.carrental.repo.BookingDetailsRepo;
import lk.carrental.carrental.repo.BookingRepo;
import lk.carrental.carrental.service.BookingDetailsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookingDetailsServiceImpl implements BookingDetailsService {
    @Autowired
    private BookingDetailsRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    BookingRepo bookingRepo;


    @Override
    public void saveBookingDetails(BookingDetailsDTO dto) {
        if (!repo.existsById(dto.getBookingId())) {
            Booking booking = bookingRepo.findById(dto.getBookingId()).get();

            BookingDetails bookingDetails=new BookingDetails(
                    dto.getPickUpDate(),
                    dto.getReturnDate(),
                    dto.getLoseDamagePrice(),
                    dto.getLoseDamageImage(),
                    dto.getBookingStatus(),
                    dto.getCustomerNIC(),
                    booking
            );
            repo.save(bookingDetails);
        } else {
            throw new RuntimeException("BookingDetails Already Exist..!");
        }
    }

    @Override
    public void deleteBookingDetails(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the BookingDetail ID...!");
        }
    }

    @Override
    public void updateBookingDetails(BookingDetailsDTO dto) {
        repo.save(mapper.map(dto, BookingDetails.class));
    }

    @Override
    public BookingDetailsDTO searchBookingDetails(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), BookingDetailsDTO.class);
        } else {
            throw new RuntimeException("No Customer For " + id + " ..!");
        }
    }

    @Override
    public List<BookingDetailsDTO> getAllBookingDetails() {
      /*  List < BookingDetailsDTO> bookingDetailsDTOS = new ArrayList<>();
        List<BookingDetails> all = repo.findAll();
        for (BookingDetails bookingDetails:all) {
            bookingDetailsDTOS.add(new BookingDetailsDTO(bookingDetails.getBookingDetailsId(),bookingDetails.getPickUpDate(),bookingDetails.getReturnDate(),bookingDetails.getLoseDamageStatus(),bookingDetails.getLoseDamageImg(),bookingDetails.getDetailsStatus(),bookingDetails.getCustNIC(),bookingDetails.getBookingId()));
        }
        return bookingDetailsDTOS; */
        return mapper.map(repo.findAll(), new TypeToken<List<BookingDetailsDTO>>() {
        }.getType());
    }

}
