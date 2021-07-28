package com.nit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammersProjectInfo {
private ProgmrprojId id;//has-property with class ProgmrprojId
private String pname;
private String projectName;
private Integer teamSize;
}
