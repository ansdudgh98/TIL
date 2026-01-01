package jpa.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {

    private String city;

    private String street;

    private String zipzode;

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipzode() {
        return zipzode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZipzode(String zipzode) {
        this.zipzode = zipzode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getCity(), address.getCity()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getZipzode(), address.getZipzode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipzode());
    }
}
