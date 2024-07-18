package com.wipro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.entity.Role;
/*
 * save(), findById(), findAll(), count(), existsById(), deleteById(), delete(), deleteAll()
 */
import com.wipro.entity.User;

//@Repository
//public interface UserRepository extends CrudRepository<User,Integer>{
//
//}


/*
 * additional methods related to Pagination and Sorting plus methods related to
 * delete record in batch and flushing persistence context
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	User findByUsername(String username);
	
	
	//	List<User> findByRole(String role);
	
	//is same as
	//providing JPQL to the @Query
	@Query("SELECT u FROM User u WHERE u.role = ?1")
	List<User> findUsersByRole(Role role);
	

	@Query("SELECT u FROM User u WHERE u.role= ?1 and u.username = ?2")
	List<User> findUsersByStatusAndName(String role, String username);
	
	//to execute native query, i.e. SQL statements
	@Query(value= "SELECT * FROM registered_user u WHERE u.role = ?1", nativeQuery = true)
	List<User> findUsersByRoleNative(String role);
	


}