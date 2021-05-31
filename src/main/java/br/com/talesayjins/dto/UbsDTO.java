package br.com.talesayjins.dto;

import br.com.talesayjins.entities.Ubs;

public class UbsDTO {

    private Integer id;
    private String name;
    private String address;
    private String city;
    private String phone;
    private GeocodeDTO geocode;
    private ScoreDTO score;

    public UbsDTO(){};
    public UbsDTO(Ubs obj){
        id = obj.getId();
        name = obj.getNom_estab();
        address = obj.getDsc_endereco();
        city = obj.getDsc_cidade();
        phone = obj.getDsc_telefone();
        geocode = new GeocodeDTO(obj);
        score = new ScoreDTO(obj);
    };


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public GeocodeDTO getGeocode() {
        return geocode;
    }

    public void setGeocode(GeocodeDTO geocode) {
        this.geocode = geocode;
    }

    public ScoreDTO getScore() {
        return score;
    }

    public void setScore(ScoreDTO score) {
        this.score = score;
    }

}
