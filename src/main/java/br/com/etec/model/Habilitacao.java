/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.model;

import java.beans.PropertyVetoException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
@Table(name = "hab", catalog = "eteab01", schema = "")
@XmlRootElement
public class Habilitacao extends DefaultModel implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String PROP_SIGLA = "sigla";
    public static final String PROP_NOME = "nome";
    public static final String PROP_DESCRICAO = "descricao";
    public static final String PROP_GRADECURRICULARLIST = "gradeCurricularList";
    
    @Id
    @Basic(optional = false)
    @Column(name = "idhab")
    private String sigla;
    @Basic(optional = false)
    @Column(name = "nmhab")
    private String nome;
    @Column(name = "dshab")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "habilitacao")
    private List<GradeCurricular> gradeCurricularList;
    
    public Habilitacao() {
    }

    public String getId() {
        return getSigla();
    }
    
    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<GradeCurricular> getGradeCurricularList() {
        return gradeCurricularList;
    }

    @Override
    public void setNullId(){
        //this.setSigla(null);
    }
    
    public void setSigla(String sigla) {
        java.lang.String oldSigla = this.sigla;
        this.sigla = sigla;
        propertyChangeSupport.firePropertyChange(PROP_SIGLA, oldSigla, sigla);
    }

    public void setNome(String nome) {
        java.lang.String oldNome = this.nome;
        this.nome = nome;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, nome);
    }

    public void setDescricao(String descricao) {
        java.lang.String oldDescricao = this.descricao;
        this.descricao = descricao;
        propertyChangeSupport.firePropertyChange(PROP_DESCRICAO, oldDescricao, descricao);
    }

    public void setGradeCurricularList(List<GradeCurricular> gradeCurricularList) throws PropertyVetoException {
        java.util.List<br.com.etec.model.GradeCurricular> oldGradeCurricularList = this.gradeCurricularList;
        vetoableChangeSupport.fireVetoableChange(PROP_GRADECURRICULARLIST, oldGradeCurricularList, gradeCurricularList);
        this.gradeCurricularList = gradeCurricularList;
        propertyChangeSupport.firePropertyChange(PROP_GRADECURRICULARLIST, oldGradeCurricularList, gradeCurricularList);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.sigla);
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.descricao);
        hash = 29 * hash + Objects.hashCode(this.gradeCurricularList);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Habilitacao other = (Habilitacao) obj;
        if (!Objects.equals(this.sigla, other.sigla)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.gradeCurricularList, other.gradeCurricularList)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nome;
    }
   
    
}
