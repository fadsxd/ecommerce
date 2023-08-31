package com.proyecto.ecommerce.repository;

import com.proyecto.ecommerce.entity.Role;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID>  {

  /*
  //TODO: QUERY NATIVA
  @Query(value = "SELECT * FROM roles WHERE name = ?1",nativeQuery = true)
  Optional<Role> findRoleByName(String name);

  // TODO: JPQL
  @Query(value = "SELECT r FROM Role r WHERE r.name = ?1")
  Optional<Role> getRoleByName(String name);

  */
  //TODO: QUERY METHODS
  Optional<Role> findByName(String name);
  boolean existsByName(String name);
}
