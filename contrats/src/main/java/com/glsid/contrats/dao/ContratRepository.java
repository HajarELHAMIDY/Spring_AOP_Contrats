package com.glsid.contrats.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.glsid.contrats.entities.Contrat;


@RepositoryRestController
public interface ContratRepository extends JpaRepository<Contrat, Long> {
    Contrat findByCinClient(String cin);
}
