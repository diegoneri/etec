/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.repository;

import br.com.etec.model.TipoAtribuicao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dfelix3
 */
public interface TipoAtribuicaoRepository extends JpaRepository<TipoAtribuicao, Character> {
    
}
