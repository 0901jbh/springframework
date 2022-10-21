package com.ssafy.empapp.model.service;

import java.sql.SQLException;

import com.ssafy.empapp.model.dto.User;

public interface UserService {

	String login(String userId, String password) throws Exception;
	boolean regist(User user) throws SQLException;
}