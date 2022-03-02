package com.lucasladeira.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lucasladeira.models.Resident;

public interface ResidentRepository extends JpaRepository<Resident, UUID>{
	
	boolean existsById(UUID id);
	
	@Query(value = "SELECT COUNT (id) FROM TB_RESIDENT", nativeQuery = true)
	int findAllResidents();
	
	public Optional<Resident> findByCpf(String cpf);
}
