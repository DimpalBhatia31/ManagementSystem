package com.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.management.entities.User;
import com.management.interfaces.IUserDto;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query( value = "SELECT count(*) as NoOfRegisterUsers, date from user WHERE MONTH(date) = MONTH(CURRENT_DATE()) AND YEAR(date) = YEAR(CURRENT_DATE()) group by date order by date", nativeQuery= true)
	public List<IUserDto> getRegisterUsersCurrentMonth();
}
