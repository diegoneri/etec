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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dfelix3
 */
@Entity
@Table(name = "cat_ds")
@XmlRootElement
public class CategoriaProfessor extends DefaultModel implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String PROP_CODIGO = "codigo";
    public static final String PROP_NOME = "nome";
    public static final String PROP_PROFESSORLIST = "professorList";
    @Id
    @Basic(optional = false)
    @Column(name = "cdcat")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "nmcat")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaProfessor", targetEntity=Professor.class)
    private List<Professor> professorList;

    public CategoriaProfessor() {
    }

    public CategoriaProfessor(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getCodigo() != null ? getCodigo().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaProfessor)) {
            return false;
        }
        CategoriaProfessor other = (CategoriaProfessor) object;
        if ((this.getCodigo() == null && other.getCodigo() != null) || (this.getCodigo() != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "(" + getCodigo() + ") " + getNome();
    }

    public String getId() {
        return this.codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public List<Professor> getProfessorList() {
        return professorList;
    }

    @Override
    public void setNullId(){
        //this.setCodigo(null);
    }
    
    public void setCodigo(String codigo) {
        java.lang.String oldCodigo = this.codigo;
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
    
    
}
