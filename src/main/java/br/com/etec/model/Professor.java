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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dfelix3
 */
@Entity
@Table(name = "prf")
@SecondaryTable(name = "prf_ds", pkJoinColumns={@PrimaryKeyJoinColumn(name="fkprf")})
@XmlRootElement
public class Professor extends DefaultModel implements Serializable, Comparable<Professor> {
    public static final String PROP_TIPOCONTRATO = "tipoContrato";
    public static final String PROP_CATEGORIAPROFESSOR = "categoriaProfessor";
   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cdprf")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nmprf")
    private String nome;
    @Basic(optional = false)
    @Column(name = "pfprf")
    private String cpf;
    @Column(name = "mtprf")
    private Integer matricula;
    @Column(name="rgprfds", table="prf_ds")
    private String rg;
    @JoinColumn(name = "fktpcds", referencedColumnName = "idtpc", table="prf_ds")
    @ManyToOne(optional = false)
    private TipoContrato tipoContrato;
    @JoinColumn(name = "fkcatds", referencedColumnName = "cdcat", table="prf_ds")
    @ManyToOne(optional = false)
    private CategoriaProfessor categoriaProfessor;    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professor")
    private List<Atribuicao> atribuicaoList;
    
    public Professor() {
    }
    
    public Professor(Integer id) {
        this.id = id;
    }
    
    public Professor(Integer id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }
    
    public Integer getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public String getRg() {
        return rg;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public CategoriaProfessor getCategoriaProfessor() {
        return categoriaProfessor;
    }

    @XmlTransient
    public List<Atribuicao> getAtribuicaoList() {
        return atribuicaoList;
    }

    @Override
    public void setNullId(){
        this.setId(null);
    }    
    
    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange("id", oldId, id);
    }
    
    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        propertyChangeSupport.firePropertyChange("nome", oldNome, nome);
    }
    
    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        propertyChangeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }
    
    public void setRg(String rg) {
        String oldRg = this.rg;
        this.rg = rg;
        propertyChangeSupport.firePropertyChange("rg", oldRg, rg);
    }
    
    public void setMatricula(Integer matricula) {
        Integer oldMatricula = this.matricula;
        this.matricula = matricula;
        propertyChangeSupport.firePropertyChange("matricula", oldMatricula, matricula);
    }
    
    public void setAtribuicaoList(List<Atribuicao> atribuicaoList) throws PropertyVetoException {
        java.util.List<br.com.etec.model.Atribuicao> oldAtribuicaoList = this.atribuicaoList;
        vetoableChangeSupport.fireVetoableChange("atribuicaoList", oldAtribuicaoList, atribuicaoList);
        this.atribuicaoList = atribuicaoList;
        propertyChangeSupport.firePropertyChange("atribuicaoList", oldAtribuicaoList, atribuicaoList);        
    }
    
    public void setTipoContrato(TipoContrato tipoContrato) {
        br.com.etec.model.TipoContrato oldTipoContrato = this.tipoContrato;
        this.tipoContrato = tipoContrato;
        propertyChangeSupport.firePropertyChange(PROP_TIPOCONTRATO, oldTipoContrato, tipoContrato);
    }

    public void setCategoriaProfessor(CategoriaProfessor categoriaProfessor) {
        br.com.etec.model.CategoriaProfessor oldCategoriaProfessor = this.categoriaProfessor;
        this.categoriaProfessor = categoriaProfessor;
        propertyChangeSupport.firePropertyChange(PROP_CATEGORIAPROFESSOR, oldCategoriaProfessor, categoriaProfessor);
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
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "(" + this.getMatricula() + ") " + this.getNome();
    }
    
    @Override
    public int compareTo(Professor o) {
        return this.getNome().compareTo(o.getNome());
    }

}
