package br.com.talesayjins.controllers.response;

import org.springframework.data.domain.Page;

import java.util.List;

public class ResponsePagination<T>  {

    private Integer current_page;
    private Integer per_page;
    private Long total_entries;
    private List<T> entries;

    public ResponsePagination(Page<T> obj){
        current_page = obj.getPageable().getPageNumber() +1;
        per_page = obj.getContent().size();
        total_entries = obj.getTotalElements();
        entries = obj.getContent();
    }


    public Integer getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(Integer current_page) {
        this.current_page = current_page;
    }

    public Integer getPer_page() {
        return per_page;
    }

    public void setPer_page(Integer per_page) {
        this.per_page = per_page;
    }

    public Long getTotal_entries() {
        return total_entries;
    }

    public void setTotal_entries(Long total_entries) {
        this.total_entries = total_entries;
    }

    public List<T> getEntries() {
        return entries;
    }

    public void setEntries(List<T> entries) {
        this.entries = entries;
    }

}
