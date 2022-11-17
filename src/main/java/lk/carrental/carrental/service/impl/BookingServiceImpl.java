package lk.carrental.carrental.service.impl;


import lk.carrental.carrental.dto.BookingDTO;
import lk.carrental.carrental.dto.BookingDetailsDTO;
import lk.carrental.carrental.entity.*;
import lk.carrental.carrental.repo.*;
import lk.carrental.carrental.service.BookingService;
import lk.carrental.carrental.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepo bookingRepo;

    private final DriverService driverService;

    private final BookingDetailsRepo bookingDetailsRepo;


    private final VehicleRepo vehicleRepo;

    private final DriverScheduleRepo driverScheduleRepo;

    private final VehicleScheduleRepo vehicleScheduleRepo;

    private final ModelMapper mapper;

    public BookingServiceImpl(BookingRepo bookingRepo, DriverService driverService, BookingDetailsRepo bookingDetailsRepo, VehicleRepo vehicleRepo, DriverScheduleRepo driverScheduleRepo, VehicleScheduleRepo vehicleScheduleRepo, ModelMapper mapper) {
        this.bookingRepo = bookingRepo;
        this.driverService = driverService;
        this.bookingDetailsRepo = bookingDetailsRepo;
        this.vehicleRepo = vehicleRepo;
        this.driverScheduleRepo = driverScheduleRepo;
        this.vehicleScheduleRepo = vehicleScheduleRepo;
        this.mapper = mapper;
    }

    @Override
    public String getLastRid() {
        return bookingRepo.getLastID();
    }

    @Override
    public void saveBooking(BookingDTO entity) {
        System.out.println("1111111111111111111111111111111");
        if(!bookingRepo.existsById(entity.getBookingId())){
            Booking booking=new Booking(
                    entity.getBookingId(),
                    entity.getCustomer()
            );
            System.out.println("awoooo");
            Booking IsBooking = bookingRepo.save(booking);


            System.out.println(IsBooking);
            if(IsBooking!=null){
                for (BookingDetailsDTO detailsDTO:entity.getBookingDetails()) {
                    BookingDetails bookingDetails=new BookingDetails(
                            detailsDTO.getPickUpDate(),
                            detailsDTO.getReturnDate(),
                            detailsDTO.getLoseDamagePrice(),
                            "uploads/"+detailsDTO.getLoseDamageImage(),
                            "Not Approved",
                            detailsDTO.getCustomerNIC(),
                            booking

                    );

                    BookingDetails IsBookingDetails = bookingDetailsRepo.save(bookingDetails);

                    if(IsBookingDetails!=null) {
                        System.out.println("========"+bookingDetails.toString());
                        System.out.println(detailsDTO.getDriverStatus());
                        if(detailsDTO.getDriverStatus().equals("Assign")){
                            Driver driver=mapper.map( driverService.getRandomDriver(),Driver.class);


                            DriverSchedule driverSchedule = new DriverSchedule(
                                    detailsDTO.getPickUpDate(),
                                    detailsDTO.getReturnDate(),
                                    "On Work",
                                    IsBookingDetails,
                                    driver
                            );
                            DriverSchedule IsDriverSchedule = driverScheduleRepo.save(driverSchedule);

                        }

                        if (IsBookingDetails != null) {
                            System.out.println("====+++++++++===="+detailsDTO.toString());
                            Vehicle vehicle = vehicleRepo.findById(detailsDTO.getNumber()).get();

                            VehicleSchedule vehicleSchedule = new VehicleSchedule(
                                    detailsDTO.getPickUpDate(),
                                    detailsDTO.getReturnDate(),
                                    "On Booking",
                                    IsBookingDetails,
                                    vehicle
                            );
                            System.out.println("========"+vehicleSchedule);
                            vehicleScheduleRepo.save(vehicleSchedule);
                        }
                    }


                }
            }
        }else {
            throw new RuntimeException("This Booking ID is Already Exist !");
        }
    }

    @Override
    public void deleteBooking(String id) {

    }

    @Override
    public void updateBooking(BookingDTO dto) {

    }

    @Override
    public BookingDTO searchBooking(String id) {
        return null;
    }

    @Override
    public List<BookingDTO> getAllBooking() {
        return mapper.map(bookingRepo.findAll(), new TypeToken<List<BookingDTO>>() {
        }.getType());
    }
}
