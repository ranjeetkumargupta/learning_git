package com.wipro.service;

import java.util.List;

import com.wipro.entity.Role;
import com.wipro.entity.User;
import com.wipro.exception.UserException;



public interface UserService {
	public User getUserById(Integer userid) throws UserException;
	public List<User> getAllUsers() throws UserException;
	public User addUser(User user) throws UserException;
	public User deleteUser(Integer userID) throws UserException;
	public User updateUser(User user) throws UserException;
	public User findByUsername(String username) throws UserException;
	
	
	public List<User> getUsersByPages(Integer pageNumber, Integer recordsPerPage, String sortBy) throws UserException;
	public List<User> getUsersByPagesCount(Integer numberOfPages, Integer recordsPerPage, String sortBy) throws UserException;
	public List<User> getUsersSortedByField(String sortBy)  throws UserException;
	
	public List<User> findUsersByRole(Role role)  throws UserException;
 
}
