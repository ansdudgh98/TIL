package hellojpa;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Member extends BaseEntity{

        @Id @GeneratedValue
        @Column(name = "member_id")
        private Long id;

        @Column(name = "USERNAME")
        private String username;

        @Embedded
        private Period workperiod;

        @Embedded
        private Address homeaddress;

        public Long getId() {
                return id;
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, username, workperiod, homeaddress);
        }

        @ElementCollection
        @CollectionTable(name="FAVORITE_FOODS",joinColumns = @JoinColumn(name="MEMBER_ID"))
        @Column(name = "FOOD")
        private Set<String> favoriteFoods = new HashSet<>();


        @ElementCollection
        @CollectionTable(name="ADDRESS",joinColumns = @JoinColumn(name="MEMBER_ID"))
        private List<Address> addressHistory = new ArrayList<>();

        public void setId(Long id) {
                this.id = id;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public Period getWorkperiod() {
                return workperiod;
        }

        public void setWorkperiod(Period workperiod) {
                this.workperiod = workperiod;
        }

        public Address getHomeaddress() {
                return homeaddress;
        }

        public void setHomeaddress(Address homeaddress) {
                this.homeaddress = homeaddress;
        }

        public Set<String> getFavoriteFoods() {
                return favoriteFoods;
        }

        public void setFavoriteFoods(Set<String> favoriteFoods) {
                this.favoriteFoods = favoriteFoods;
        }

        public List<Address> getAddressHistory() {
                return addressHistory;
        }

        public void setAddressHistory(List<Address> addressHistory) {
                this.addressHistory = addressHistory;
        }
}
