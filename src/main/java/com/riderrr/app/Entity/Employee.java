package com.riderrr.app.Entity;
import com.riderrr.app.Enum.Role;
import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String Name;
    private String Email;
    private String Phone;
    private String Password;

    @Enumerated(EnumType.STRING)
    private Role Role;

    @ManyToOne
    @JoinColumn(name = "branchId")
    private Branch branchId;
    private String Address;


}
