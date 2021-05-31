package br.com.talesayjins.entities;

import br.com.talesayjins.entities.enums.Score;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Ubs implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Double vlr_latitude;

    @Column
    private Double vlr_longitude;

    @Column
    private String cod_munic;

    @Column
    private String codCnes;

    @Column
    private String nom_estab;

    @Column
    private String dsc_endereco;

    @Column
    private String dsc_bairro;

    @Column
    private String dsc_cidade;

    @Column
    private String dsc_telefone;

    @Column
    private Integer dsc_estrut_fisic_ambiencia;

    @Column
    private Integer dsc_adap_defic_fisic_idosos;

    @Column
    private Integer dsc_equipamentos;

    @Column
    private Integer dsc_medicamentos;

    @Column
    private String latitude;

    @Column
    private String longitude;

    public Ubs(){};
    public Ubs(Double vlr_latitude, Double vlr_longitude, String cod_munic, String codCnes, String nom_estab, String dsc_endereco, String dsc_bairro, String dsc_cidade, String dsc_telefone, Score dsc_estrut_fisic_ambiencia, Score dsc_adap_defic_fisic_idosos, Score dsc_equipamentos, Score dsc_medicamentos,String latitude, String longitude) {
        this.vlr_latitude = vlr_latitude;
        this.vlr_longitude = vlr_longitude;
        this.cod_munic = cod_munic;
        this.codCnes = codCnes;
        this.nom_estab = nom_estab;
        this.dsc_endereco = dsc_endereco;
        this.dsc_bairro = dsc_bairro;
        this.dsc_cidade = dsc_cidade;
        this.dsc_telefone = dsc_telefone;
        this.dsc_estrut_fisic_ambiencia = dsc_estrut_fisic_ambiencia.getCod();
        this.dsc_adap_defic_fisic_idosos = dsc_adap_defic_fisic_idosos.getCod();
        this.dsc_equipamentos = dsc_equipamentos.getCod();
        this.dsc_medicamentos = dsc_medicamentos.getCod();
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getVlr_latitude() {
        return vlr_latitude;
    }

    public void setVlr_latitude(Double vlr_latitude) {
        this.vlr_latitude = vlr_latitude;
    }

    public Double getVlr_longitude() {
        return vlr_longitude;
    }

    public void setVlr_longitude(Double vlr_longitude) {
        this.vlr_longitude = vlr_longitude;
    }

    public String getCod_munic() {
        return cod_munic;
    }

    public void setCod_munic(String cod_munic) {
        this.cod_munic = cod_munic;
    }

    public String getCodCnes() {
        return codCnes;
    }

    public void setCodCnes(String codCnes) {
        this.codCnes = codCnes;
    }

    public String getNom_estab() {
        return nom_estab;
    }

    public void setNom_estab(String nom_estab) {
        this.nom_estab = nom_estab;
    }

    public String getDsc_endereco() {
        return dsc_endereco;
    }

    public void setDsc_endereco(String dsc_endereco) {
        this.dsc_endereco = dsc_endereco;
    }

    public String getDsc_bairro() {
        return dsc_bairro;
    }

    public void setDsc_bairro(String dsc_bairro) {
        this.dsc_bairro = dsc_bairro;
    }

    public String getDsc_cidade() {
        return dsc_cidade;
    }

    public void setDsc_cidade(String dsc_cidade) {
        this.dsc_cidade = dsc_cidade;
    }

    public String getDsc_telefone() {
        return dsc_telefone;
    }

    public void setDsc_telefone(String dsc_telefone) {
        this.dsc_telefone = dsc_telefone;
    }

    public Score getDsc_estrut_fisic_ambiencia() {
        return Score.toEnum(dsc_estrut_fisic_ambiencia);
    }

    public void setDsc_estrut_fisic_ambiencia(Score dsc_estrut_fisic_ambiencia) {
        this.dsc_estrut_fisic_ambiencia = dsc_estrut_fisic_ambiencia.getCod();
    }

    public Score getDsc_adap_defic_fisic_idosos() {
        return Score.toEnum(dsc_adap_defic_fisic_idosos);
    }

    public void setDsc_adap_defic_fisic_idosos(Score dsc_adap_defic_fisic_idosos) {
        this.dsc_adap_defic_fisic_idosos = dsc_adap_defic_fisic_idosos.getCod();
    }

    public Score getDsc_equipamentos() {
        return Score.toEnum(dsc_equipamentos);
    }

    public void setDsc_equipamentos(Score dsc_equipamentos) {
        this.dsc_equipamentos = dsc_equipamentos.getCod();
    }

    public Score getDsc_medicamentos() {
        return Score.toEnum(dsc_medicamentos);
    }

    public void setDsc_medicamentos(Score dsc_medicamentos) {
        this.dsc_medicamentos = dsc_medicamentos.getCod();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ubs)) return false;
        Ubs ubs = (Ubs) o;
        return getId().equals(ubs.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Ubs{" +
                "id=" + id +
                ", vlr_latitude=" + vlr_latitude +
                ", vlr_longitude=" + vlr_longitude +
                ", cod_munic='" + cod_munic + '\'' +
                ", cod_cnes='" + codCnes + '\'' +
                ", nom_estab='" + nom_estab + '\'' +
                ", dsc_endereco='" + dsc_endereco + '\'' +
                ", dsc_bairro='" + dsc_bairro + '\'' +
                ", dsc_cidade='" + dsc_cidade + '\'' +
                ", dsc_telefone='" + dsc_telefone + '\'' +
                ", dsc_estrut_fisic_ambiencia='" + dsc_estrut_fisic_ambiencia + '\'' +
                ", dsc_adap_defic_fisic_idosos='" + dsc_adap_defic_fisic_idosos + '\'' +
                ", dsc_equipamentos='" + dsc_equipamentos + '\'' +
                ", dsc_medicamentos='" + dsc_medicamentos + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
