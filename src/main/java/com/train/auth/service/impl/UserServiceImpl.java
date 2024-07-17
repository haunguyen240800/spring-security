package com.train.auth.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.train.auth.constant.CommonConstant;
import com.train.auth.constant.RoleEnum;
import com.train.auth.dto.UserDTO;
import com.train.auth.model.User;
import com.train.auth.model.UserInfo;
import com.train.auth.model.UserRole;
import com.train.auth.repository.UserInfoRepository;
import com.train.auth.repository.UserRepository;
import com.train.auth.repository.UserRoleRepository;
import com.train.auth.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void signUp(UserDTO userDTO) throws Exception {
		if (userRepository.existsByUsername(userDTO.getUsername())) {
			throw new BadRequestException("Username already exists");
		}
		
		if (userRepository.existsByEmail(userDTO.getEmail())) {
			throw new BadRequestException("Email already exists");
		}
		
		UserInfo userInfo = new UserInfo();
		userInfo.setFullName(userDTO.getFullName());
		userInfo.setDob(userDTO.getDob());
		userInfo.setAddress(userDTO.getAddress());
		userInfo.setGender(userDTO.getGender());
		userInfo.setImgPath(userDTO.getImgPath());
		userInfo.setCellPhone(userDTO.getCellPhone());
		userInfoRepository.save(userInfo);
		
		User user = new User();
//		user.setUserUid(this.getSeq("seq_user_uid"));
		user.setUsername(userDTO.getUsername());
		user.setEmail(userDTO.getEmail());
		user.setStatus(CommonConstant.AccountStatus.ACTIVATED.getValue());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setCreatedDate(new Date());
		user.setUserInfo(userInfo);
		
		userRepository.save(user);
		
		UserRole userRole = new UserRole();
		userRole.setRoleId(RoleEnum.NORMAIL_USER.getValue());
		userRole.setUserUid(user.getUserUid());
		userRoleRepository.save(userRole);
	}
	
	@Override
	public String getSeq(String seqName) throws SQLException {
//		userRepository.setSeq(seqName);
//		return userRepository.getSeq();
		return null;
	}
	
	public UserDTO getByUserUid(Long userUid) throws JsonMappingException, JsonProcessingException {
		User user = userRepository.findByUserUid(userUid).get();
		UserDTO userDTO = convertToUserDTO(user);
		return userDTO;
	}
	
	public Map<String, Object> getByUserUidList(List<String> userUidList) throws JsonMappingException, JsonProcessingException {
		Map<String, Object> result = new HashMap<>();
//		for (String userUid : userUidList) {
//			result.put(userUid, getByUserUid(userUid));
//		}
		
		return result;
	}
	
	public List<UserDTO> getAll() {
		List<User> users = userRepository.findAll();
		return users.stream().map(user -> convertToUserDTO(user)).collect(Collectors.toList());
	}
	
	public UserDTO convertToUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setAddress(user.getUserInfo().getAddress());
		userDTO.setCellPhone(user.getUserInfo().getCellPhone());
		userDTO.setCreatedBy(user.getCreatedBy());
		userDTO.setCreatedDate(user.getCreatedDate());
		userDTO.setDob(user.getUserInfo().getDob());
		userDTO.setEmail(user.getEmail());
		userDTO.setFullName(user.getUserInfo().getFullName());
		userDTO.setGender(user.getUserInfo().getGender());
		userDTO.setImgPath(user.getUserInfo().getImgPath());
		userDTO.setStatus(user.getStatus());
		userDTO.setUserInfoId(user.getUserInfo().getUserInfoId());
		userDTO.setUsername(user.getUsername());
		userDTO.setUserUid(user.getUserUid());
		userDTO.setUpdatedDate(user.getUpdatedDate());
		userDTO.setUpdatedBy(user.getUpdatedBy());
		
		return userDTO;
	}
}
