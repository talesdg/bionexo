package br.com.talesayjins.dto;

import br.com.talesayjins.entities.Ubs;

public class ScoreDTO {
    private Integer size;
    private Integer adaptation_for_seniors;
    private Integer medical_equipment;
    private Integer medicine;

    public ScoreDTO(){};

    public ScoreDTO(Ubs obj){
        medicine = obj.getDsc_medicamentos().getCod();
        medical_equipment = obj.getDsc_equipamentos().getCod();
        adaptation_for_seniors = obj.getDsc_adap_defic_fisic_idosos().getCod();
        size = obj.getDsc_estrut_fisic_ambiencia().getCod();
    };

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getAdaptation_for_seniors() {
        return adaptation_for_seniors;
    }

    public void setAdaptation_for_seniors(Integer adaptation_for_seniors) {
        this.adaptation_for_seniors = adaptation_for_seniors;
    }

    public Integer getMedical_equipment() {
        return medical_equipment;
    }

    public void setMedical_equipment(Integer medical_equipment) {
        this.medical_equipment = medical_equipment;
    }

    public Integer getMedicine() {
        return medicine;
    }

    public void setMedicine(Integer medicine) {
        this.medicine = medicine;
    }
}
