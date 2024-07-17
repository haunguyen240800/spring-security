package com.train.auth.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "role_id")
	private String roleId;
	
	@Column(name = "role_name")
	private String roleName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "updated_date")
	private Date updatedDate;
	
	@Column(name = "updated_by")
	private String updatedBy;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", 
		joinColumns = @JoinColumn(name="role_id"), 
		inverseJoinColumns = @JoinColumn(name = "user_uid")
	)
	private List<User> users;
	
}
