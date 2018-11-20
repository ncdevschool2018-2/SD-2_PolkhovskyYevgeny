package com.netcracker.edu.backend.service.businesService;

import com.netcracker.edu.backend.dto.PupilDto;
import com.netcracker.edu.backend.dto.TeacherDto;
import com.netcracker.edu.backend.entity.Pupils;
import com.netcracker.edu.backend.entity.Teacher;
import com.netcracker.edu.backend.entity.Users;

public interface RegistrationService {
    Pupils registratePupil(PupilDto pupilDto);
    Teacher registrateTeacher(TeacherDto teacherDto);
    Pupils editPupil(Pupils pupils);
}
