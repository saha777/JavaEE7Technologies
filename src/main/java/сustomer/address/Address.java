package сustomer.address;


import annotations.ZipCode;
import com.sun.istack.internal.NotNull;

public class Address {
    @NotNull
    private String street1;
    private String street2;
    @NotNull
    private String city;
    private String state;
    @NotNull
    @ZipCode
    private String zipcode;
    private String country;

    public Address(String street1, String city, String state, String zipcode, String country) {
        this.street1 = street1;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
    }
}
