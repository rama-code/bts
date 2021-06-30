package com.bts.Tes.entity;
import lombok.Data;
import lombok.*;
import java.sql.Date;
import javax.persistence.*;
import java.util.Calendar;


@Getter
@Setter
@Data
@Entity
@Table(name="user")
public class User{
    @Id
    @Column
    @GeneratedValue
    private long id;
    @Column
    private String  username;  //Username
     @Column
    private String  password;  //Username
     @Column
    private String  email;
    @Column
    private String  phone;
    @Column
    private String  country;
    @Column
    private String  city;
    @Column
    private String  postcode;
    @Column
    private String  name;
    @Column
    private String  address;
    
   
    

}