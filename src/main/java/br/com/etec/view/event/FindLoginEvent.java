/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.view.event;

import br.com.etec.model.Login;

/**
 *
 * @author dfelix3
 */
public class FindLoginEvent extends AbstractEvent<Login> {
    public FindLoginEvent(Login login){
        super(login);
    }
}
