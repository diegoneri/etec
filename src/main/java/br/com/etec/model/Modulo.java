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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dfelix3
 */
@Entity
@Table(name = "mdl", catalog = "eteab01", schema = "")
@XmlRootElement
public class Modulo extends DefaultModel implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulo")
    private List<Disciplina> disciplinaList;
    private static final long serialVersionUID = 1L;
    public static final String PROP_ID = "id";
    public static final String PROP_SEQUENCIA = "sequencia";
    public static final String PROP_GRADECURRICULAR = "gradeCurricular";
    public static final String PROP_TURMALIST = "turmaList";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cdmdl")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "sqmdl")
    private short sequencia;
    @JoinColumn(name = "fkgrd", referencedColumnName = "cdgrd")
    @ManyToOne(optional = false)
    private GradeCurricular gradeCurricular;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulo")
    private List<Turma> turmaList;
    
    public Modulo() {
    }

    public Integer getId() {
        return id;
    }

    public short getSequencia() {
        return sequencia;
    }

    public GradeCurricular getGradeCurricular() {
        return gradeCurricular;
    }

    public List<Turma> getTurmaList() {
        return turmaList;
    }

    @Override
    public void setNullId(){
        this.setId(null);
    }
    
    public void setId(Integer id)  {
        java.lang.Integer oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange(PROP_ID, oldId, id);
    }

    public void setSequencia(short sequencia)  {
        short oldSequencia = this.sequencia;
        this.sequencia = sequencia;
        propertyChangeSupport.firePropertyChange(PROP_SEQUENCIA, oldSequencia, sequencia);
    }

    public void setGradeCurricular(GradeCurricular gradeCurricular)  {
        br.com.etec.model.GradeCurricular oldGradeCurricular = this.gradeCurricular;
        this.gradeCurricular = gradeCurricular;
        propertyChangeSupport.firePropertyChange(PROP_GRADECURRICULAR, oldGradeCurricular, gradeCurricular);
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
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + this.sequencia;
        hash = 41 * hash + Objects.hashCode(this.gradeCurricular);
        hash = 41 * hash + Objects.hashCode(this.turmaList);
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
        final Modulo other = (Modulo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.sequencia != other.sequencia) {
            return false;
        }
        if (!Objects.equals(this.gradeCurricular, other.gradeCurricular)) {
            return false;
        }
        if (!Objects.equals(this.turmaList, other.turmaList)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modulo{" 
                + "\t\nid=" + id 
                + ", \t\nsequencia=" + sequencia 
                + ", \t\ngradeCurricular=" + this.gradeCurricular 
                //+ ", \t\nturmas=" + this.turmaList 
                + '}';
    }

    @XmlTransient
    public List<Disciplina> getDisciplinaList() {
        return disciplinaList;
    }

    public void setDisciplinaList(List<Disciplina> disciplinaList) {
        this.disciplinaList = disciplinaList;
    }

}
