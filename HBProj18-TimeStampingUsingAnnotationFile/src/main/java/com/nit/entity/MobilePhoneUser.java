package com.nit.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Time_Stamp_Anno")
public class MobilePhoneUser {
	@Id
	private  Long regno;
	@NonNull
	private Long mobileno;
	@NonNull
	private  boolean prepaid;  //gives  isPrepaid() instread of getPrepaid
	@NonNull
	private  String circle;
	@NonNull
	private String callertune;
	@Version
	private Integer updationCount;
	@UpdateTimestamp
	private Timestamp lastUpdated;
	@CreationTimestamp
	private Timestamp doj;
	

}