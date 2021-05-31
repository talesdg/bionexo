package br.com.talesayjins.entities.enums;

public enum Score {

    DESEMPENHO_ACIMA(1,"Desempenho acima da média"),
    DESEMPENHO_MEDIANO(2, "Desempenho mediano ou  um pouco abaixo da média"),
    DESEMPENHO_MUITO_ACIMA(3, "Desempenho muito acima da média");

    private int cod;
    private String descricao;

    private Score(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return this.cod;
    }
    public String getDescricao() {
        return this.descricao;
    }

    public static Score toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }
        for(Score x : Score.values()) {
            if(cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido: "+cod);
    }

    public static Score toEnum(String descicao){
        if(descicao == null) {
            return null;
        }
        for(Score x : Score.values()) {
            if(descicao.equals(x.getDescricao())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Descrição inválida: "+descicao);
    }
}
