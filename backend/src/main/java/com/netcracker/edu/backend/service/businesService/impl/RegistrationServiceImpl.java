package com.netcracker.edu.backend.service.businesService.impl;

import com.netcracker.edu.backend.dto.PupilDto;
import com.netcracker.edu.backend.dto.TeacherDto;
import com.netcracker.edu.backend.entity.Pupils;
import com.netcracker.edu.backend.entity.SubjectTeacher;
import com.netcracker.edu.backend.entity.Teacher;
import com.netcracker.edu.backend.entity.Users;
import com.netcracker.edu.backend.service.PupilsService;
import com.netcracker.edu.backend.service.SubjectTeacherService;
import com.netcracker.edu.backend.service.TeacherService;
import com.netcracker.edu.backend.service.UsersService;
import com.netcracker.edu.backend.service.businesService.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RegistrationServiceImpl implements RegistrationService {
    private PupilsService pupilsService;
    private UsersService usersService;
    private TeacherService teacherService;
    private SubjectTeacherService subjectTeacherService;
    
    
    @Autowired
    public RegistrationServiceImpl(PupilsService pupilsService, UsersService usersService, TeacherService teacherService, SubjectTeacherService subjectTeacherService) {
        this.pupilsService = pupilsService;
        this.usersService = usersService;
        this.teacherService = teacherService;
        this.subjectTeacherService = subjectTeacherService;
    }
    
    
    @Override
    @Transactional
    public Pupils registratePupil(PupilDto pupilDto) {
        Users newUser = new Users(pupilDto.getLogin(), pupilDto.getPassword(), pupilDto.getRoleId());
        
        
        usersService.saveUsers(newUser);
        Users getUser = usersService.findUserByLogin(pupilDto.getLogin());
        Pupils newPupil = new Pupils(pupilDto.getName(), pupilDto.getSurname(), pupilDto.getGroupId(), getUser.getId());
        
        pupilsService.savePupil(newPupil);
        
        return newPupil;
    }
    
    
    @Override
    @Transactional
    public Teacher registrateTeacher(TeacherDto teacherDto) {
        Users newUser = new Users(teacherDto.getLogin(), teacherDto.getPassword(), teacherDto.getRoleId());
        usersService.saveUsers(newUser);
        Users getUser = usersService.findUserByLogin(teacherDto.getLogin());
        Teacher newTeacher = new Teacher(teacherDto.getName(), teacherDto.getSurname(), getUser.getId());
        teacherService.saveTeacher(newTeacher);
        
        Teacher teacherId = teacherService.findTeacherByUserId(newTeacher.getUserId());
        SubjectTeacher newSubjectTeacher = new SubjectTeacher(teacherDto.getSubjectId(), teacherId.getId());
        subjectTeacherService.saveSubjectTeacher(newSubjectTeacher);
        
        
        return newTeacher;
    }
    
    
    @Override
    public Pupils editPupil(Pupils pupils) {
        pupilsService.savePupil(pupils);
        return pupils;
    }
}
