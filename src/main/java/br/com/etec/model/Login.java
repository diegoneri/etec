/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.model;

import br.com.etec.crypto.Hash;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dfelix3
 */
@Entity
@Table(name = "acesso")
@XmlRootElement
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nmusuario")
    private String usuario;
    @Size(max = 20)
    @Column(name = "nmsenha")
    private String senha;
    @Size(max = 100)
    @Column(name = "nmacesso")
    private String acesso;

    public Login(){
        this.usuario = "";
        this.senha = "";
        this.acesso = "";
    }
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getHashSenha(){
        try {
            return Hash.SHA256.encode(senha);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Login.class.getName())
                    .log(Level.SEVERE, "Não foi possível encriptar a senha", ex);
            return "";
        }
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Login[ nmusuario=" + usuario + " ]";
    }
    
}
