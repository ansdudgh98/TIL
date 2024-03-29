package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String name;

    @Embedded
    private Address address;


    @JsonIgnore
    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    List<Order> orders = new ArrayList<>();




}
