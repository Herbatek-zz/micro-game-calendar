package com.piotrke.user.repositories;

import com.piotrke.user.entities.Role;
import com.piotrke.user.enums.RoleName;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

    Optional<Role> findByName(RoleName name);
}
