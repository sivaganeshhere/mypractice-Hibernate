package com.nit.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CompositeId_Anno")
@Entity
public class ProgrammersProjectInfo {
	@EmbeddedId
private ProgmrprojId id;//has-property with class ProgmrprojId
	@Column(length = 20)
	@Type(type="string")
private String pname;
	@Column(length = 20)
	@Type(type="string")
private String projectName;
	@Type(type = "int")
private Integer teamSize;
}
