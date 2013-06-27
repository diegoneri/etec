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
@Table(name = "dis")
@SecondaryTable(name="dis_ds", pkJoinColumns={@PrimaryKeyJoinColumn(name="fkdis")})
@XmlRootElement
public class Disciplina extends DefaultModel implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String PROP_ID = "id";
    public static final String PROP_SIGLA = "sigla";
    public static final String PROP_NOME = "nome";
    public static final String PROP_CARGAHORARIA = "cargaHoraria";
    public static final String PROP_CARGAHORARIADIVISAO = "cargaHorariaDivisao";
    public static final String PROP_HASDIVISAO = "hasDivisao";
    public static final String PROP_ATRIBUICAOLIST = "atribuicaoList";
    public static final String PROP_MODULO = "modulo";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cddis")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "sgdis")
    private String sigla;
    @Basic(optional = false)
    @Column(name = "nmdis")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "csdis")
    private Float cargaHoraria;
    @Column(table = "dis_ds" ,name = "csdivdis")
    private Float cargaHorariaDivisao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private List<Atribuicao> atribuicaoList;
    @JoinColumn(name = "fkmdl", referencedColumnName = "cdmdl")
    @ManyToOne(optional = false)
    private Modulo modulo;

    public Disciplina() {
    }

    public Disciplina(Integer id) {
        this.id = id;
    }

    public Disciplina(Integer id, String sigla, String nome) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
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
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNome() + " (" + getSigla() + ')';
    }

    public Integer getId() {
        return id;
    }

    @XmlTransient
    public List<Atribuicao> getAtribuicaoList() {
        return atribuicaoList;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }

    public Float getCargaHoraria() {
        return cargaHoraria;
    }

    public Float getCargaHorariaDivisao() {
        return cargaHorariaDivisao;
    }

    public Boolean getHasDivisao() {
        return cargaHorariaDivisao != null && cargaHorariaDivisao > 0;
    }

    public Boolean hasDivisao() {
        return getHasDivisao();
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

    public void setCargaHoraria(Float cargaHoraria) {
        java.lang.Float oldCargaHoraria = this.cargaHoraria;
        this.cargaHoraria = cargaHoraria;
        propertyChangeSupport.firePropertyChange(PROP_CARGAHORARIA, oldCargaHoraria, cargaHoraria);
    }

    public void setCargaHorariaDivisao(Float cargaHorariaDivisao)  {
        java.lang.Float oldCargaHoraria = this.cargaHorariaDivisao;
        this.cargaHorariaDivisao = cargaHorariaDivisao;
        propertyChangeSupport.firePropertyChange(PROP_CARGAHORARIADIVISAO, oldCargaHoraria, cargaHorariaDivisao);
    }

    public void setAtribuicaoList(List<Atribuicao> atribuicaoList) throws PropertyVetoException {
        java.util.List<br.com.etec.model.Atribuicao> oldAtribuicaoList = this.atribuicaoList;
        vetoableChangeSupport.fireVetoableChange(PROP_ATRIBUICAOLIST, oldAtribuicaoList, atribuicaoList);
        this.atribuicaoList = atribuicaoList;
        propertyChangeSupport.firePropertyChange(PROP_ATRIBUICAOLIST, oldAtribuicaoList, atribuicaoList);
    }

    public void setModulo(Modulo modulo) {
        br.com.etec.model.Modulo oldModulo = this.modulo;
        this.modulo = modulo;
        propertyChangeSupport.firePropertyChange(PROP_MODULO, oldModulo, modulo);
    }
}
