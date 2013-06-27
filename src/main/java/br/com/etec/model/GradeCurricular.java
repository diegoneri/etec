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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dfelix3
 */
@Entity
@Table(name = "grd", catalog = "eteab01", schema = "")
@XmlRootElement
public class GradeCurricular extends DefaultModel implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String PROP_ID = "id";
    public static final String PROP_DESCRICAO = "descricao";
    public static final String PROP_OBGRD = "obgrd";
    public static final String PROP_HABILITACAO = "habilitacao";
    public static final String PROP_MODULOLIST = "moduloList";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cdgrd")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "dsgrd")
    private String descricao;
    @Lob
    @Column(name = "obgrd")
    private String obgrd;
    @JoinColumn(name = "fkhab", referencedColumnName = "idhab")
    @ManyToOne(optional = false)
    private Habilitacao habilitacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gradeCurricular")
    private List<Modulo> moduloList;

    public GradeCurricular() {
    }

    public GradeCurricular(Integer id) {
        this.id = id;
    }

    public GradeCurricular(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getObgrd() {
        return obgrd;
    }

    public Habilitacao getHabilitacao() {
        return habilitacao;
    }
    
    public List<Modulo> getModuloList() {
        return moduloList;
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

    public void setDescricao(String descricao) {
        java.lang.String oldDescricao = this.descricao;
        this.descricao = descricao;
        propertyChangeSupport.firePropertyChange(PROP_DESCRICAO, oldDescricao, descricao);
    }

    public void setObgrd(String obgrd) {
        java.lang.String oldObgrd = this.obgrd;
        this.obgrd = obgrd;
        propertyChangeSupport.firePropertyChange(PROP_OBGRD, oldObgrd, obgrd);
    }

    public void setHabilitacao(Habilitacao habilitacao) {
        Habilitacao oldHabilitacao = this.habilitacao;
        this.habilitacao = habilitacao;
        propertyChangeSupport.firePropertyChange(PROP_HABILITACAO, oldHabilitacao, habilitacao);
    }

    public void setModuloList(List<Modulo> moduloList) throws PropertyVetoException {
        java.util.List<br.com.etec.model.Modulo> oldModuloList = this.moduloList;
        vetoableChangeSupport.fireVetoableChange(PROP_MODULOLIST, oldModuloList, moduloList);
        this.moduloList = moduloList;
        propertyChangeSupport.firePropertyChange(PROP_MODULOLIST, oldModuloList, moduloList);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.descricao);
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
        final GradeCurricular other = (GradeCurricular) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GradeCurricular{" 
                + "\t\nid=" + id 
                + "\t\n, descricao=" + descricao 
                + "\t\n, habilitacao=" + habilitacao                
                + '}';
    }

    
    
}
