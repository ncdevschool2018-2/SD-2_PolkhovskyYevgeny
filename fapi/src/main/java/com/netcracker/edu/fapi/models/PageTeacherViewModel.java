package com.netcracker.edu.fapi.models;

import com.netcracker.edu.backend.entity.UniversityGroup;

import java.util.List;

public class PageTeacherViewModel {
    private List<TeacherViewModel> content;
    private int totalPages;
    private int totalElements;
    
    public PageTeacherViewModel() {
    }
    
    public PageTeacherViewModel(List<TeacherViewModel> content, int totalPages, int totalElements) {
        this.content = content;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }
    
    public List<TeacherViewModel> getContent() {
        return content;
    }
    
    public void setContent(List<TeacherViewModel> content) {
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
