package com.train.auth.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "menu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Menu implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "menu_id")
	private String menuId;
	@Column(name = "menu_name")
	private String menuName;
	@Column(name = "lev")
	private int lev;
	@Column(name = "order_no")
	private int orderNo;
	@Column(name = "up_menu_id")
	private String upMenuId;
	@Column(name = "url")
	private String url;
	@Column(name = "status")
	private Boolean Status;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "updated_date")
	private Date updatedDate;
	@Column(name = "updated_by")
	private String updatedBy;
}
