package com.medicare1.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare1.dto.UserDto;
import com.medicare1.entity.User;
import com.medicare1.repository.UserRepository;
import com.medicare1.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserRepository userRepository;

	@Override
	public String addUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setPhone(userDto.getPhone());
		userRepository.save(user);
			return "New User Registered";
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public String updateUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User userToUpdate=new User();
		userToUpdate.setId(userDto.getId());
		userToUpdate.setEmail(userDto.getEmail());
		userToUpdate.setName(userDto.getName());
		userToUpdate.setPhone(userDto.getPhone());
		userToUpdate.setPassword(userDto.getPassword());
		
		userRepository.save(userToUpdate);
		
		return "User Updated Successfully";
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public String deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		return "User deleted";
	}

	

}
