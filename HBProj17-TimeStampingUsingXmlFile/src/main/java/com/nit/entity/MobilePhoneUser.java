package com.nit.entity;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class MobilePhoneUser {
	private  Long regno;
	@NonNull
	private Long mobileno;
	@NonNull
	private  boolean prepaid;  //gives  isPrepaid() instread of getPrepaid
	@NonNull
	private  String circle;
	@NonNull
	private String callertune;
	private Timestamp lastUpdated;
	

}