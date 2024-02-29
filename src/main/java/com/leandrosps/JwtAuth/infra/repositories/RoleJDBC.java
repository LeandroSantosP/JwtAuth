package com.leandrosps.JwtAuth.infra.repositories;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Table("ROLES")
public class RoleJDBC {
  @Id
  private String id;
  private String name;
}
