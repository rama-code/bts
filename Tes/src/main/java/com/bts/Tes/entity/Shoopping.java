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
@Table(name="shopping")
public class Shoopping{
    @Id
    @Column
    @GeneratedValue
    private long id;
    @Column
    private String  name;
   
    
   
    

}