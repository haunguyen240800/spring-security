package com.train.auth.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long userUid;
	private String username;
//	@JsonIgnore
	private String password;
	private String email;
	private String fullName;
	private String cellPhone;
	private Date dob;
	private String imgPath;
	private String address;
	private Boolean gender;
	private String status;
	private Long userInfoId;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
}
