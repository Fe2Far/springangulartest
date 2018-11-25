package com.zagwork.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zagwork.test.domain.TipoRisco; 

@Repository
public interface TipoRiscoRepository extends JpaRepository<TipoRisco,Long>{

}
