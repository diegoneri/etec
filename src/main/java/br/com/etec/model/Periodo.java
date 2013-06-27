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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dfelix3
 */
@Entity
@Table(name = "per", catalog = "eteab01", schema = "")
@XmlRootElement
public class Periodo extends DefaultModel implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String PROP_ID = "id";
    public static final String PROP_NOME = "nome";
    public static final String PROP_TURMALIST = "turmaList";
    @Id
    @Basic(optional = false)
    @Column(name = "idper")
    private Short id;
    @Basic(optional = false)
    @Column(name = "nmper")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo")
    private List<Turma> turmaList;

    public Periodo() {
    }

    public Periodo(Short id) {
        this.id = id;
    }

    public Periodo(Short id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Short getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @XmlTransient
    public List<Turma> getTurmaList() {
        return turmaList;
    }

    @Override
    public void setNullId(){
        this.setId(null);
    }
    
    public void setId(Short id) {
        java.lang.Short oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange(PROP_ID, oldId, id);
    }

    public void setNome(String nome) {
        java.lang.String oldNome = this.nome;
        this.nome = nome;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, nome);
    }

    public void setTurmaList(List<Turma> turmaList) throws PropertyVetoException {
        java.util.List<br.com.etec.model.Turma> oldTurmaList = this.turmaList;
        vetoableChangeSupport.fireVetoableChange(PROP_TURMALIST, oldTurmaList, turmaList);
        this.turmaList = turmaList;
        propertyChangeSupport.firePropertyChange(PROP_TURMALIST, oldTurmaList, turmaList);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.nome);
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
        final Periodo other = (Periodo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Periodo{" + "id=" + id + ", nome=" + nome + '}';
    }

}
