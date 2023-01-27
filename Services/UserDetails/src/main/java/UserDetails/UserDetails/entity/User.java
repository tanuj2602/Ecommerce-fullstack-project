package UserDetails.UserDetails.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "user_details")
public class User {
    @Id
    private  String userId ;
    private  String userName;
    private  String password;
    private String userEmail;

    public String getUserId() {
        return userId;
    }
}
