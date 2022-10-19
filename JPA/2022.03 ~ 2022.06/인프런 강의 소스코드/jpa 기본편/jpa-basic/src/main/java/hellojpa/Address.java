package hellojpa;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private String stret;
    private String zipzode;

    public Address() {
    }

    public Address(String city, String stret, String zipzode) {
        this.city = city;
        this.stret = stret;
        this.zipzode = zipzode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStret() {
        return stret;
    }

    public void setStret(String stret) {
        this.stret = stret;
    }

    public String getZipzode() {
        return zipzode;
    }

    public void setZipzode(String zipzode) {
        this.zipzode = zipzode;
    }
}
