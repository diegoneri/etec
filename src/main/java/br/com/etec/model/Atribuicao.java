/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.model;

import br.com.etec.exception.EtecAbException;
import br.com.etec.util.TipoAtribuicaoBuilder;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dfelix3
 */
@Entity
@Table(name = "atr")
@SecondaryTable(name="atr_ds", pkJoinColumns={@PrimaryKeyJoinColumn(name="fkatr")})
@XmlRootElement
public class Atribuicao extends DefaultModel implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String PROP_ID = "id";
    public static final String PROP_TURMA = "turma";
    public static final String PROP_TIPOATRIBUICAO = "tipoAtribuicao";
    public static final String PROP_PROFESSOR = "professor";
    public static final String PROP_PERIODOLETIVO = "periodoLetivo";
    public static final String PROP_DISCIPLINA = "disciplina";
    public static final String PROP_ATRIBUICAOSUBSTITUICAO = "atribuicaoSubstituicao";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cdatr")
    private Integer id;
    @JoinColumn(name = "fktur", referencedColumnName = "cdtur")
    @ManyToOne(optional = false)
    private Turma turma;
    @JoinColumn(name = "fktat", referencedColumnName = "idtat")
    @ManyToOne(optional = false)
    private TipoAtribuicao tipoAtribuicao;
    @JoinColumn(name = "fkprf", referencedColumnName = "cdprf")
    @ManyToOne(optional = false)
    private Professor professor;
    @JoinColumn(name = "fkplv", referencedColumnName = "cdplv")
    @ManyToOne(optional = false)
    private PeriodoLetivo periodoLetivo;
    @JoinColumn(name = "fkdis", referencedColumnName = "cddis")
    @ManyToOne(optional = false)
    private Disciplina disciplina;
    @JoinColumn(table = "atr_ds", name = "fkatrsub", referencedColumnName = "cdatr")
    @ManyToOne(optional = true)    
    private Atribuicao atribuicaoSubstituicao;
    @Basic(optional = false)
    @Column(table="atr_ds", name="flatrsub")
    private Boolean hasSubstituicao = Boolean.FALSE;
    @Basic(optional = false)
    @Column(table="atr_ds", name="csdisatr")
    private Float cargaHorariaAtribuida;
    
    public Atribuicao() {
    }

    public Atribuicao(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Atribuicao)) {
            return false;
        }
        Atribuicao other = (Atribuicao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.etecab.model.Atribuicao[ cdatr=" + id + " ]";
    }

    public Integer getId() {
        return id;
    }
    
    @Override
    public void setNullId(){
        this.setId(null);
    }

    public Turma getTurma() {
        return turma;
    }

    public TipoAtribuicao getTipoAtribuicao() {
        return tipoAtribuicao;
    }

    public Professor getProfessor() {
        return professor;
    }

    public PeriodoLetivo getPeriodoLetivo() {
        return periodoLetivo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Atribuicao getAtribuicaoSubstituicao() {
        return atribuicaoSubstituicao;
    }
   
    public Boolean hasSubstituicao(){
        return this.hasSubstituicao;
    }

    public Boolean getHasSubstituicao(){
        return this.hasSubstituicao;
    }    
    
    public Float getCargaHorariaAtribuida(){
        return this.cargaHorariaAtribuida;
    }
    
    public void setId(Integer id) {
        java.lang.Integer oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange(PROP_ID, oldId, id);
    }

    public void setTurma(Turma turma) {
        br.com.etec.model.Turma oldTurma = this.turma;
        this.turma = turma;
        propertyChangeSupport.firePropertyChange(PROP_TURMA, oldTurma, turma);
    }

    public void setTipoAtribuicao(TipoAtribuicao tipoAtribuicao) {
        br.com.etec.model.TipoAtribuicao oldTipoAtribuicao = this.tipoAtribuicao;
        this.tipoAtribuicao = tipoAtribuicao;
        propertyChangeSupport.firePropertyChange(PROP_TIPOATRIBUICAO, oldTipoAtribuicao, tipoAtribuicao);
    }

    public void setProfessor(Professor professor) {
        br.com.etec.model.Professor oldProfessor = this.professor;
        this.professor = professor;
        propertyChangeSupport.firePropertyChange(PROP_PROFESSOR, oldProfessor, professor);
    }

    public void setPeriodoLetivo(PeriodoLetivo periodoLetivo) {
        br.com.etec.model.PeriodoLetivo oldPeriodoLetivo = this.periodoLetivo;
        this.periodoLetivo = periodoLetivo;
        propertyChangeSupport.firePropertyChange(PROP_PERIODOLETIVO, oldPeriodoLetivo, periodoLetivo);
    }

    public void setDisciplina(Disciplina disciplina) {
        br.com.etec.model.Disciplina oldDisciplina = this.disciplina;
        this.disciplina = disciplina;
        propertyChangeSupport.firePropertyChange(PROP_DISCIPLINA, oldDisciplina, disciplina);
    }

    public void setAtribuicaoSubstituicao(Atribuicao atribuicaoSubstituicao) {
        br.com.etec.model.Atribuicao oldAtribuicaoSubstituicao = this.atribuicaoSubstituicao;
        this.atribuicaoSubstituicao = atribuicaoSubstituicao;
        propertyChangeSupport.firePropertyChange(PROP_ATRIBUICAOSUBSTITUICAO, oldAtribuicaoSubstituicao, atribuicaoSubstituicao);
    }
    
    public void setCargaHorariaAtribuida(Float cargaHorariaAtribuida){
        Float oldCargaHorariaAtribuida = this.cargaHorariaAtribuida;
        this.cargaHorariaAtribuida = cargaHorariaAtribuida;
        propertyChangeSupport.firePropertyChange("cargaHorariaAtribuida", oldCargaHorariaAtribuida, cargaHorariaAtribuida);
    }

    private void criarAtribuicaoSubstituicao(){
        Atribuicao atrSub = new Atribuicao();
        atrSub.setDisciplina(disciplina);
        atrSub.setPeriodoLetivo(periodoLetivo);
        atrSub.setTurma(turma);
        atrSub.setCargaHorariaAtribuida(disciplina.getCargaHoraria());        
        this.setAtribuicaoSubstituicao(atrSub);
    }
    
    public void setHasSubstituicao(Boolean hasSubstituicao) throws EtecAbException {
        Boolean oldHasSubstituicao = this.hasSubstituicao;
        this.hasSubstituicao = hasSubstituicao;
        propertyChangeSupport.firePropertyChange("hasSubstituicao", oldHasSubstituicao, hasSubstituicao);
        if (hasSubstituicao) {
            this.criarAtribuicaoSubstituicao();
            
            if (this.getTipoAtribuicao().equals(TipoAtribuicaoBuilder.getTipoAtribuicaoPrincipal())) {
                this.setTipoAtribuicao(TipoAtribuicaoBuilder.getTipoAtribuicaoPrincipalSubstituicao());
                this.getAtribuicaoSubstituicao().setTipoAtribuicao(TipoAtribuicaoBuilder.getTipoAtribuicaoPrincipal());
            }else if (this.getTipoAtribuicao().equals(TipoAtribuicaoBuilder.getTipoAtribuicaoDivisao())) {
                this.setTipoAtribuicao(TipoAtribuicaoBuilder.getTipoAtribuicaoDivisaoSubstituicao());
                this.getAtribuicaoSubstituicao().setTipoAtribuicao(TipoAtribuicaoBuilder.getTipoAtribuicaoDivisaoSubstituicao());
            }
        }else{
            this.setAtribuicaoSubstituicao(null);
            try{
            if (this.getTipoAtribuicao().equals(TipoAtribuicaoBuilder.getTipoAtribuicaoPrincipalSubstituicao())) {
                this.setTipoAtribuicao(TipoAtribuicaoBuilder.getTipoAtribuicaoPrincipal());
            }else if (this.getTipoAtribuicao().equals(TipoAtribuicaoBuilder.getTipoAtribuicaoDivisaoSubstituicao())) {
                this.setTipoAtribuicao(TipoAtribuicaoBuilder.getTipoAtribuicaoDivisao());
            }   
            }catch(NullPointerException ex){
                throw new EtecAbException("Não há um tipo de atribuição definida. Deve ser confirmada antes de informar a substituição do professor", ex);
            }
        }
    }

}
