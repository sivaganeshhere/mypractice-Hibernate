package com.nit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import lombok.Data;

@Data
@Table(name="ARTIST_INFO")
@Entity
//@DynamicUpdate(true)
@DynamicInsert(true)
@Proxy(lazy = false)
public class ARTIST_INFO {
	@Id
	@Column(name = "aid")
private Integer aid;
	@Column(name = "name",length = 15)
private String name;
	@Column(name = "addrs",length = 15)
private String addrs;
	@Column(name = "mobileno")
private Integer mobileno;
	@Column(name = "pincode")
private Integer pincode;

}
