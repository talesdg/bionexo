package br.com.talesayjins.dto;

import br.com.talesayjins.entities.Ubs;

public class GeocodeDTO {
    private Double lat;
    private Double lng;

    public GeocodeDTO(){};
    public GeocodeDTO(Ubs obj){
        lat = obj.getVlr_latitude();
        lng = obj.getVlr_longitude();
    };

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
