package io.github.nhatteam.jeri.service.repository;

import io.github.nhatteam.jeri.service.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
