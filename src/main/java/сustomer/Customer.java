package сustomer;

import annotations.Email;
import com.sun.istack.internal.NotNull;
import com.sun.jndi.cosnaming.IiopUrl;
import сustomer.address.Address;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class Customer {

    @NotNull
    @Size(min = 2)
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String phoneNumber;
    @Past
    private Date dateOfBirth;
    private Address deliveryAddress;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
