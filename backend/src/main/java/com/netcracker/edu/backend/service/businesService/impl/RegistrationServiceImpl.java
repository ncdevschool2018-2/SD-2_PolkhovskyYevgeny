package com.netcracker.edu.backend.service.businesService.impl;

import com.netcracker.edu.backend.dto.PupilDto;
import com.netcracker.edu.backend.entity.Pupils;
import com.netcracker.edu.backend.entity.Users;
import com.netcracker.edu.backend.service.PupilsService;
import com.netcracker.edu.backend.service.UsersService;
import com.netcracker.edu.backend.service.businesService.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RegistrationServiceImpl implements RegistrationService {
    private PupilsService pupilsService;
    private UsersService usersService;
    
    @Autowired
    public  RegistrationServiceImpl(PupilsService pupilsService,UsersService usersService){
        this.pupilsService = pupilsService;
        this.usersService=usersService;
    }
    @Override
    @Transactional
    public Pupils registratePupil(PupilDto pupilDto) {
        Users newUser = new Users(pupilDto.getLogin(),pupilDto.getPassword(),pupilDto.getRoleId());
        
        
        usersService.saveUsers(newUser);
        Users getUser=usersService.findUserByLogin(pupilDto.getLogin());
        Pupils newPupil= new Pupils(pupilDto.getName(),pupilDto.getSurname(),pupilDto.getGroupId(),getUser.getId());
        
        pupilsService.savePupil(newPupil);
        
        return newPupil;
    }
}
