/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.model;

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
@Table(name = "tur", catalog = "eteab01", schema = "")
@XmlRootElement
public class Turma extends DefaultModel implements Serializable, Comparable<Turma> {
    private static final long serialVersionUID = 1L;
    public static final String PROP_ID = "id";
    public static final String PROP_SIGLA = "sigla";
    public static final String PROP_PERIODOLETIVO = "periodoLetivo";
    public static final String PROP_PERIODO = "periodo";
    public static final String PROP_MODULO = "modulo";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cdtur")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "sgtur")
    private char sigla;
    @Column(name = "fkrepalu")
    private Integer fkrepalu;
    @JoinColumn(name = "fkplv", referencedColumnName = "cdplv")
    @ManyToOne(optional = false)
    private PeriodoLetivo periodoLetivo;
    @JoinColumn(name = "fkper", referencedColumnName = "idper")
    @ManyToOne(optional = false)
    private Periodo periodo;
    @JoinColumn(name = "fkmdl", referencedColumnName = "cdmdl")
    @ManyToOne(optional = false)
    private Modulo modulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turma")
    private List<Atribuicao> atribuicaoList;
    
    public Turma() {
    }

    public Turma(Integer id) {
        this.id = id;
    }

    public Turma(Integer id, char sigla) {
        this.id = id;
        this.sigla = sigla;
    }

    public Integer getId() {
        return id;
    }

    public char getSigla() {
        return sigla;
    }

    public PeriodoLetivo getPeriodoLetivo() {
        return periodoLetivo;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public Modulo getModulo() {
        return modulo;
    }

    @Override
    public void setNullId(){
        this.setId(null);
    }
    
    public void setId(Integer id) {
        java.lang.Integer oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange(PROP_ID, oldId, id);
    }

    public void setSigla(char sigla) {
        char oldSigla = this.sigla;
        this.sigla = sigla;
        propertyChangeSupport.firePropertyChange(PROP_SIGLA, oldSigla, sigla);
    }

    public void setPeriodoLetivo(PeriodoLetivo periodoLetivo) {
        br.com.etec.model.PeriodoLetivo oldPeriodoLetivo = this.periodoLetivo;
        this.periodoLetivo = periodoLetivo;
        propertyChangeSupport.firePropertyChange(PROP_PERIODOLETIVO, oldPeriodoLetivo, periodoLetivo);
    }

    public void setPeriodo(Periodo periodo) {
        br.com.etec.model.Periodo oldPeriodo = this.periodo;
        this.periodo = periodo;
        propertyChangeSupport.firePropertyChange(PROP_PERIODO, oldPeriodo, periodo);
    }

    public void setModulo(Modulo modulo) {
        br.com.etec.model.Modulo oldModulo = this.modulo;
        this.modulo = modulo;
        propertyChangeSupport.firePropertyChange(PROP_MODULO, oldModulo, modulo);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Turma other = (Turma) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNomeTurma();
    }

    public String getNomeTurma() {
        return this.modulo.getSequencia()
                + this.modulo.getGradeCurricular().getHabilitacao().getSigla()
                + this.periodo.getId()
                + (this.sigla == 'U' ? "" : this.sigla);
    }

    @Override
    public int compareTo(Turma other) {
        int result = 
         this.getModulo().getGradeCurricular().getHabilitacao().getSigla()
    .compareTo(other.getModulo().getGradeCurricular().getHabilitacao().getSigla());
        if (result == 0){
            Short sq1 = this.getModulo().getSequencia();
            Short sq2 = other.getModulo().getSequencia();
            result = sq1.compareTo(sq2);
        }
        return result;
    }

    public Integer getFkrepalu() {
        return fkrepalu;
    }

    public void setFkrepalu(Integer fkrepalu) {
        this.fkrepalu = fkrepalu;
    }

    @XmlTransient
    public List<Atribuicao> getAtribuicaoList() {
        return atribuicaoList;
    }

    public void setAtribuicaoList(List<Atribuicao> atribuicaoList) {
        this.atribuicaoList = atribuicaoList;
    }
}
