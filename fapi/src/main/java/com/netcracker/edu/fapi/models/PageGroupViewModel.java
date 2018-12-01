package com.netcracker.edu.fapi.models;


import java.util.List;

public class PageGroupViewModel {
    private List<UniversityGroupViewModel> content;
    private int totalPages;
    private int totalElements;
    
    public PageGroupViewModel() {
    }
    
    public PageGroupViewModel(List<UniversityGroupViewModel> content, int totalPages, int totalElements) {
        this.content = content;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }
    
    public List<UniversityGroupViewModel> getContent() {
        return content;
    }
    
    public void setContent(List<UniversityGroupViewModel> content) {
        this.content = content;
    }
    
    public int getTotalPages() {
        return totalPages;
    }
    
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    
    public int getTotalElements() {
        return totalElements;
    }
    
    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }
}
