/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.controller;

import br.com.etec.model.TipoAtribuicao;
import br.com.etec.repository.TipoAtribuicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author dfelix3
 */
@Controller
public class TipoAtribuicaoController {
    @Autowired
    private TipoAtribuicaoRepository tipoAtribuicaoRepository;

    public TipoAtribuicaoRepository getTipoAtribuicaoRepository() {
        return tipoAtribuicaoRepository;
    }
    
    public void init(){
        for(TipoAtribuicao ta: tipoAtribuicaoRepository.findAll() ){
            System.out.println(ta);
        }
    }
    
}
