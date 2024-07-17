package com.train.auth.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_info_id")
	private Long userInfoId;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "cell_phone")
	private String cellPhone;
	
	@Column(name = "dob")
	private Date dob;
	
	@Column(name = "img_path")
	private String imgPath;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "gender")
	private Boolean gender;
	
	@OneToOne(mappedBy = "userInfo")
	private User user;
	
}
