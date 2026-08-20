package ticket.booking.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.User;

import java.io.File;

public class UserBookingService {

    private User user;
    

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String USERS_PATH = "../localDb/users.json";

    public UserBookingService(User user1){
        this.user = user1;
        File users = new File(USERS_PATH);
    }
}
