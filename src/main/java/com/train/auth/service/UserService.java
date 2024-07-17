package com.train.auth.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.train.auth.dto.UserDTO;

public interface UserService {
	
	public String getSeq(String seqName) throws SQLException;
	
	public void signUp(UserDTO userDTO) throws Exception;
	
	public UserDTO getByUserUid(Long userUid) throws JsonMappingException, JsonProcessingException;
	
	public Map<String, Object> getByUserUidList(List<String> userUidList) throws JsonMappingException, JsonProcessingException;
	
	public List<UserDTO> getAll();
	
}
