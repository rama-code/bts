package com.bts.Tes.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.bts.Tes.entity.Shoopping;
import java.util.*;
public interface Shooppingrepository extends JpaRepository<Shoopping,Long>{

    
  Shoopping findById(long id);
   Shoopping deleteById(long id);

}