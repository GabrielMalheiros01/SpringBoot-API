package com.apiIc.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apiIc.api.entities.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{

}
