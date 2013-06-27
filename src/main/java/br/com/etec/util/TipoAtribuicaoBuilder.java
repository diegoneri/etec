/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.util;

import br.com.etec.dao.TipoAtribuicaoDao;
import br.com.etec.model.TipoAtribuicao;

/**
 *
 * @author dfelix3
 */
public class TipoAtribuicaoBuilder {
    private static TipoAtribuicao TIPO_ATRIBUICAO_PRINCIPAL;
    private static TipoAtribuicao TIPO_ATRIBUICAO_DIVISAO;
    private static TipoAtribuicao TIPO_ATRIBUICAO_PRINCIPAL_SUBSTITUICAO;
    private static TipoAtribuicao TIPO_ATRIBUICAO_DIVISAO_SUBSTITUICAO;
    
    private static final TipoAtribuicaoDao dao = new TipoAtribuicaoDao();
   
    public static TipoAtribuicao getTipoAtribuicaoPrincipal(){
        if (TIPO_ATRIBUICAO_PRINCIPAL == null){
            TIPO_ATRIBUICAO_PRINCIPAL = dao.find('P');
        }
        return TIPO_ATRIBUICAO_PRINCIPAL;
    }
    public static TipoAtribuicao getTipoAtribuicaoDivisao(){
        if (TIPO_ATRIBUICAO_DIVISAO == null){
            TIPO_ATRIBUICAO_DIVISAO = dao.find('D');
        }
        return TIPO_ATRIBUICAO_DIVISAO;
    }    

    public static TipoAtribuicao getTipoAtribuicaoPrincipalSubstituicao() {
        if (TIPO_ATRIBUICAO_PRINCIPAL_SUBSTITUICAO == null) {
            TIPO_ATRIBUICAO_PRINCIPAL_SUBSTITUICAO = dao.find('X');
        }
        return TIPO_ATRIBUICAO_PRINCIPAL_SUBSTITUICAO;
    }

    public static TipoAtribuicao getTipoAtribuicaoDivisaoSubstituicao() {
        if (TIPO_ATRIBUICAO_DIVISAO_SUBSTITUICAO == null) {
            TIPO_ATRIBUICAO_DIVISAO_SUBSTITUICAO = dao.find('Y');
        }
        return TIPO_ATRIBUICAO_DIVISAO_SUBSTITUICAO;
    }
    
    
}
