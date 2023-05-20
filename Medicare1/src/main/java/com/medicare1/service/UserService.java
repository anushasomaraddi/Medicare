package com.medicare1.service;

import java.util.List;


import com.medicare1.dto.UserDto;
import com.medicare1.entity.User;

public interface UserService {
	
	public String addUser(UserDto userDto);
	
	public List<User> getAllUser();
	
	public String updateUser(UserDto userDto);
	
	public User getUserById(Long id);
	
	public String deleteUser(Long id);

}
