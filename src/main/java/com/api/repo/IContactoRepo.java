package com.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.model.Contacto;

@Repository
public interface IContactoRepo extends JpaRepository<Contacto, Long> {

}
