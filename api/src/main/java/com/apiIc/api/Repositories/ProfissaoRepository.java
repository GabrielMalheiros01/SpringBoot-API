package com.apiIc.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apiIc.api.entities.Profissao;

public interface ProfissaoRepository extends JpaRepository <Profissao, Long> {

}
