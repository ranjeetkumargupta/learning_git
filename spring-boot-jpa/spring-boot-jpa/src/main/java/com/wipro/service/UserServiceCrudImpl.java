package com.wipro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.dao.UserRepository;
import com.wipro.entity.Role;
import com.wipro.entity.User;
import com.wipro.exception.UserException;

import jakarta.persistence.PersistenceException;

//The methods of this class invoke CRUDRepositry methods

@Service(value = "userServiceBean")
@Transactional
public class UserServiceCrudImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUserById(Integer userid) throws UserException {
		try {
			Optional<User> optional = userRepository.findById(userid);
			if(optional.isEmpty()) {
				throw new UserException("Invalid Userid");
			}
			System.out.println("The getUserById() of UserServiceCrudImpl class invoked");
			return optional.get();
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage(),e);
		}

	}

	@Override
	public List<User> getAllUsers() throws UserException {
		try {
			Iterable<User> iterable = userRepository.findAll();
			List<User> userList = new ArrayList<>();

			for(User u: iterable) {
				userList.add(u);
			}

			if(userList.isEmpty()) {
				throw new UserException("Table is empty");
			}

			return userList;
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage(),e);
		}
	}

	@Override
	public User addUser(User user) throws UserException {
		try {
			User newUser = userRepository.save(user);
			return newUser;
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage(),e);
		}
	}

	@Override
	public User deleteUser(Integer userID) throws UserException {
		try {
			User user = this.getUserById(userID);

			userRepository.deleteById(userID);
			return user;
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage(),e);
		}
	}

	@Override
	public User updateUser(User user) throws UserException {
		try {
			User newUser = userRepository.save(user);
			return newUser;
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage(),e);
		}
	}

	@Override
	public List<User> getUsersByPages(Integer pageNumber, Integer recordsPerPage, String sortBy) throws UserException {
		try {

			/*
			 * Ex. pageNumber=2, recordsPerPage=10, say your table has 100 records
			 * returns: 11th row to 20th row
			 */
			Pageable pageable = PageRequest.of(pageNumber, recordsPerPage, Sort.by(sortBy));
			List<User> userList = userRepository.findAll(pageable).getContent();
			if(userList.isEmpty()) {
				throw new PersistenceException("Table is empty");
			}
			return userList;
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage(),e);
		}
	}

	@Override
	public List<User> getUsersByPagesCount(Integer numberOfPages, Integer recordsPerPage, String sortBy)
			throws UserException {
		Pageable pageable=null;
//		List<User> userList = new ArrayList<>();
		List<User> totalList = new ArrayList<>();
		try {

			
			for(int i=0; i<numberOfPages;i++) {
				pageable = PageRequest.of(i, recordsPerPage, Sort.by(sortBy));
				List<User> userList = userRepository.findAll(pageable).getContent();
				totalList.addAll(userList);				
			}
			
			if(totalList.isEmpty()) {
				throw new PersistenceException("Table is empty");
			}
			return totalList;
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage(),e);
		}
	}

	@Override
	public List<User> getUsersSortedByField(String sortBy) throws UserException {
		try {
//			Sort sort = Sort.by(sortBy).descending();
			//default is ascending
			Sort sort = Sort.by(sortBy);
			Iterable<User> iterable = userRepository.findAll(sort);
			List<User> userList = new ArrayList<>();

			for(User u: iterable) {
				userList.add(u);
			}

			if(userList.isEmpty()) {
				throw new UserException("Table is empty");
			}

			return userList;
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage(),e);
		}
	}

	@Override
	public User findByUsername(String username) throws UserException {
		try {
			User user = userRepository.findByUsername(username);
			return user;
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage(),e);
		}
	}

	@Override
	public List<User> findUsersByRole(Role role) throws UserException {
		try {
			List<User> userList = userRepository.findUsersByRole(role);
			return userList;
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage(),e);
		}
	}

}
