/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.model;

import br.com.etec.model.comparator.TurmaComparator;
import java.beans.PropertyVetoException;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dfelix3
 */
@Entity
@Table(name = "plv", catalog = "eteab01", schema = "")
@XmlRootElement
public class PeriodoLetivo extends DefaultModel implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String PROP_ID = "id";
    public static final String PROP_ANO = "ano";
    public static final String PROP_SEMESTRE = "semestre";
    public static final String PROP_DATAINICIO = "dataInicio";
    public static final String PROP_DATAFIM = "dataFim";
    public static final String PROP_SITUACAO = "situacao";
    public static final String PROP_TURMALIST = "turmaList";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cdplv")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "yrplv")
    private short ano;
    @Basic(optional = false)
    @Column(name = "smplv")
    private short semestre;
    @Basic(optional = false)
    @Column(name = "dtinicioplv")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;
    @Basic(optional = false)
    @Column(name = "dtfimplv")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;
    @Column(name = "stplv")
    private String situacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodoLetivo", fetch=FetchType.EAGER)
    private List<Turma> turmaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodoLetivo")
    private List<Atribuicao> atribuicaoList;
    @Transient
    private final TurmaComparator TURMA_COMPARATOR = new TurmaComparator();
    
    public PeriodoLetivo() {
    }

    public PeriodoLetivo(Integer id) {
        this.id = id;
    }

    public PeriodoLetivo(Integer id, short ano, short semestre, Date dataInicio, Date dataFim) {
        this.id = id;
        this.ano = ano;
        this.semestre = semestre;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Integer getId() {
        return id;
    }

    public short getAno() {
        return ano;
    }

    public short getSemestre() {
        return semestre;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public String getSituacao() {
        return situacao;
    }

    @XmlTransient
    public List<Turma> getTurmaList() {
        Collections.sort(this.turmaList, this.TURMA_COMPARATOR);
        return turmaList;
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

    public void setAno(short ano) {
        short oldAno = this.ano;
        this.ano = ano;
        propertyChangeSupport.firePropertyChange(PROP_ANO, oldAno, ano);
    }

    public void setSemestre(short semestre) {
        short oldSemestre = this.semestre;
        this.semestre = semestre;
        propertyChangeSupport.firePropertyChange(PROP_SEMESTRE, oldSemestre, semestre);
    }

    public void setDataInicio(Date dataInicio) {
        java.util.Date oldDataInicio = this.dataInicio;
        this.dataInicio = dataInicio;
        propertyChangeSupport.firePropertyChange(PROP_DATAINICIO, oldDataInicio, dataInicio);
    }

    public void setDataFim(Date dataFim) {
        java.util.Date oldDataFim = this.dataFim;
        this.dataFim = dataFim;
        propertyChangeSupport.firePropertyChange(PROP_DATAFIM, oldDataFim, dataFim);
    }

    public void setSituacao(String situacao) {
        java.lang.String oldSituacao = this.situacao;
        this.situacao = situacao;
        propertyChangeSupport.firePropertyChange(PROP_SITUACAO, oldSituacao, situacao);
    }

    public void setTurmaList(List<Turma> turmaList) throws PropertyVetoException {
        java.util.List<br.com.etec.model.Turma> oldTurmaList = this.turmaList;
        vetoableChangeSupport.fireVetoableChange(PROP_TURMALIST, oldTurmaList, turmaList);
        this.turmaList = turmaList;
        propertyChangeSupport.firePropertyChange(PROP_TURMALIST, oldTurmaList, turmaList);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + this.ano;
        hash = 31 * hash + this.semestre;
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
        final PeriodoLetivo other = (PeriodoLetivo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.ano != other.ano) {
            return false;
        }
        if (this.semestre != other.semestre) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  "Ano: " + ano + ", Semestre: " + semestre;
    }

    @XmlTransient
    public List<Atribuicao> getAtribuicaoList() {
        return atribuicaoList;
    }

    public void setAtribuicaoList(List<Atribuicao> atribuicaoList) {
        this.atribuicaoList = atribuicaoList;
    }

    
}
