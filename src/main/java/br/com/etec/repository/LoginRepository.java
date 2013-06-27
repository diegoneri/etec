/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.repository;

import br.com.etec.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author dfelix3
 */
public interface LoginRepository extends JpaRepository<Login, String>, JpaSpecificationExecutor<Login> {
    
}
