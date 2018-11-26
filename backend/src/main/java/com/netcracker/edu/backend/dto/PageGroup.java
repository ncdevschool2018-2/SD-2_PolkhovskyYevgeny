package com.netcracker.edu.backend.dto;

import com.netcracker.edu.backend.entity.UniversityGroup;

import java.util.List;

public class PageGroup {
    private List<UniversityGroup> content;
    private int totalPages;
    private int totalElements;
    
    public PageGroup() {
    }
    
    public PageGroup(List<UniversityGroup> content, int totalPages, int totalElements) {
        this.content = content;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }
    
    public List<UniversityGroup> getContent() {
        return content;
    }
    
    public void setContent(List<UniversityGroup> content) {
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
