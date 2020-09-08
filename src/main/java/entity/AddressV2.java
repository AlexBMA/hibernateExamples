package entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AddressV2 {

    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "zipcode")
    private String zipcode;

    public static class AddressV2Builder {
        private String street;
        private String city;
        private String zipcode;

        public AddressV2Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public AddressV2Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public AddressV2Builder setZipcode(String zipcode) {
            this.zipcode = zipcode;
            return this;
        }

        public AddressV2 build() {
            return new AddressV2(street, city, zipcode);
        }
    }

    public AddressV2() {
    }

    public AddressV2(String street, String city, String zipcode) {
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
