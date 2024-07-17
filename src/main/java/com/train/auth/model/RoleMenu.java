package com.train.auth.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "role_menu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleMenu implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "role_id")
	private String roleId;
	@Column(name = "menu_id")
	private String menuId;
	@Column(name = "read_yn")
	private Boolean readYn;
	@Column(name = "wrt_yn")
	private Boolean wrtYn;
	@Column(name = "mod_yn")
	private Boolean modYn;
	@Column(name = "del_yn")
	private Boolean delYn;
	@Column(name = "pnt_yn")
	private Boolean pntYn;
	@Column(name = "exc_dn_yn")
	private Boolean excDnYn;
	@Column(name = "mng_yn")
	private Boolean mngYn;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_date")
	private Date createdDate;
}
