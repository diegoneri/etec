/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dfelix3
 */

@Entity
@Table(name = "tat")
@XmlRootElement
public class TipoAtribuicao extends DefaultModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtat")
    private Character id;
    @Basic(optional = false)
    @Column(name = "nmtat")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAtribuicao")
    private List<Atribuicao> atribuicaoList;

    public TipoAtribuicao() {

    }

    public TipoAtribuicao(Character id, String nome, List<Atribuicao> atribuicaoList) {
        this.id = id;
        this.nome = nome;
        this.atribuicaoList = atribuicaoList;
    }

    public TipoAtribuicao(Character id) {
        this.id = id;
    }

    public TipoAtribuicao(Character id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Character getId() {
        return id;
    }

    @Override
    public void setNullId(){
        //this.setId(null);
    }    
    
    public void setId(Character id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Atribuicao> getAtribuicaoList() {
        return atribuicaoList;
    }

    public void setAtribuicaoList(List<Atribuicao> atribuicaoList) {
        this.atribuicaoList = atribuicaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAtribuicao)) {
            return false;
        }
        TipoAtribuicao other = (TipoAtribuicao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "(" + id + ")" + nome;
    }

}
