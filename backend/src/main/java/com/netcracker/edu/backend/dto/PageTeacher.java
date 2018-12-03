package com.netcracker.edu.backend.dto;

import com.netcracker.edu.backend.entity.Teacher;

import java.util.List;

public class PageTeacher {
    private List<Teacher> content;
    private int totalPages;
    private int totalElements;
    
    
    public PageTeacher() {
    }
    
    
    public PageTeacher(List<Teacher> content, int totalPages, int totalElements) {
        this.content = content;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }
    
    
    public List<Teacher> getContent() {
        return content;
    }
    
    
    public void setContent(List<Teacher> content) {
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
