package gr.aueb.cf.schoolapp.mapper;

import gr.aueb.cf.schoolapp.dto.*;
import gr.aueb.cf.schoolapp.model.PersonalInfo;
import gr.aueb.cf.schoolapp.model.Teacher;
import gr.aueb.cf.schoolapp.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mapper {

    private final PasswordEncoder passwordEncoder;

    public TeacherReadOnlyDTO mapToTeacherReadOnlyDTO(Teacher teacher) {
        TeacherReadOnlyDTO teacherReadOnlyDto = new TeacherReadOnlyDTO();

        teacherReadOnlyDto.setId(teacher.getId());
        teacherReadOnlyDto.setUuid(teacher.getUuid());
        teacherReadOnlyDto.setIsActive(teacher.getIsActive());

        // Map User to UserReadOnlyDTO
        UserReadOnlyDTO userDTO = new UserReadOnlyDTO();
        userDTO.setFirstname(teacher.getUser().getFirstname());
        userDTO.setLastname(teacher.getUser().getLastname());
        userDTO.setVat(teacher.getUser().getAfm());
        teacherReadOnlyDto.setUser(userDTO);

        // Map PersonalInfo to PersonalInfoReadOnlyDTO
        PersonalInfoReadOnlyDTO personalInfoDTO = new PersonalInfoReadOnlyDTO();
        personalInfoDTO.setAmka(teacher.getPersonalInfo().getAmka());
        personalInfoDTO.setIdentityNumber(teacher.getPersonalInfo().getIdentityNumber());
        teacherReadOnlyDto.setPersonalInfo(personalInfoDTO);

        return teacherReadOnlyDto; 
    }


    public Teacher mapToTeacherEntity(TeacherInsertDTO dto) {
        Teacher teacher = new Teacher();
        teacher.setIsActive(dto.getIsActive());

        // Map fields from UserDTO
        UserInsertDTO userDTO = dto.getUser();      // extract user dto
        User user = new User();
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setAfm(userDTO.getAfm());
        user.setFatherName(userDTO.getFatherName());
        user.setFatherLastname(userDTO.getFatherLastname());
        user.setMotherName(userDTO.getMotherName());
        user.setMotherLastname(userDTO.getMotherLastname());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setGender(userDTO.getGender());
        user.setRole(userDTO.getRole());
        user.setIsActive(dto.getIsActive());
        teacher.setUser(user);  // Set User entity to Teacher

        // Map fields from PersonalInfoDTO
        PersonalInfoInsertDTO personalInfoDTO = dto.getPersonalInfo();  // extract personal info dto
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setAmka(personalInfoDTO.getAmka());
        personalInfo.setIdentityNumber(personalInfoDTO.getIdentityNumber());
        personalInfo.setPlaceOfBirth(personalInfoDTO.getPlaceOfBirth());
        personalInfo.setMunicipalityOfRegistration(personalInfoDTO
                .getMunicipalityOfRegistration());
        teacher.setPersonalInfo(personalInfo);  // Set PersonalInfo entity to Teacher

        return teacher;
    }
}
