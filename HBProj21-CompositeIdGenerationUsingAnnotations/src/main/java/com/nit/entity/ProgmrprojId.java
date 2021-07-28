package com.nit.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ProgmrprojId implements Serializable{
	@Type(type = "int")
private Integer pid;
	@Type(type = "int")
private Integer projid;
}
