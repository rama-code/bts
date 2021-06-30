package com.bts.Tes.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.bts.Tes.entity.User;
import java.util.*;
public interface Userrepository extends JpaRepository<User,Long>{

	User findByUsernameAndPassword(String username,String password);

    
  

}