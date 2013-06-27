/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.model;

import java.beans.PropertyVetoException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "tpc_ds")
@XmlRootElement
public class TipoContrato extends DefaultModel implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String PROP_CODIGO = "codigo";
    public static final String PROP_NOME = "nome";
    public static final String PROP_PROFESSORLIST = "professorList";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtpc")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "nmtpc")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoContrato")
    private List<Professor> professorList;

    public TipoContrato() {
    }

    public TipoContrato(Integer codigo) {
        this.codigo = codigo;
    }

    public TipoContrato(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    @XmlTransient
    public List<Professor> getProfessorList() {
        return professorList;
    }
    
    @Override
    public void setNullId(){
        this.setCodigo(null);
    }    
    
    public void setCodigo(Integer codigo) {
        java.lang.Integer oldCodigo = this.codigo;
        this.codigo = codigo;
        propertyChangeSupport.firePropertyChange(PROP_CODIGO, oldCodigo, codigo);
    }

    public void setNome(String nome) {
        java.lang.String oldNome = this.nome;
        this.nome = nome;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, nome);
    }    
    public void setProfessorList(List<Professor> professorList) throws PropertyVetoException {
        java.util.List<br.com.etec.model.Professor> oldProfessorList = this.professorList;
        vetoableChangeSupport.fireVetoableChange(PROP_PROFESSORLIST, oldProfessorList, professorList);
        this.professorList = professorList;
        propertyChangeSupport.firePropertyChange(PROP_PROFESSORLIST, oldProfessorList, professorList);
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoContrato)) {
            return false;
        }
        TipoContrato other = (TipoContrato) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "(" + getCodigo() + ") " + getNome();
    }

    public Integer getId() {
        return this.getCodigo();
    }
    
}
