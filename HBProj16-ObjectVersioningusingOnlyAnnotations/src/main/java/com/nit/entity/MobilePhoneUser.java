package com.nit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class MobilePhoneUser {
	@Id
	private  Long regno;
	@NonNull
	private Long mobileno;
	private  boolean prepaid;  //gives  isPrepaid() instread of getPrepaid
	@NonNull
	private  String circle;
	@NonNull
	private String callertune;
	@Version
	private  Integer updationcount;
	

}