package com.example.server.service;

import com.example.server.entity.Location;
import com.example.server.entity.UserInfo;
import com.example.server.payload.ApiResponse;
import com.example.server.payload.UserInfoDto;
import com.example.server.repository.AttachmentRepository;
import com.example.server.repository.LocationRepository;
import com.example.server.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService {
    @Autowired
    UserInfoRepository userRepository;
    @Autowired
    LocationRepository locationRepository;

    @Autowired
    AttachmentRepository attachmentRepository;



    public ApiResponse saveUser(UserInfoDto userDTO) {
        UserInfo addUser = new UserInfo();
     if(!userRepository.existsByPhoneNumber(userDTO.getPhoneNumber())){

         Optional<Location> byId = locationRepository.findById(userDTO.getLocation_id());

         addUser.setLocation(byId.get());

         addUser.setFirstName( userDTO.getFirstName());
         addUser.setLastName(userDTO.getLastName());
         addUser.setAge(userDTO.getAge());
         addUser.setJShir(userDTO.getJShir());
         addUser.setSerialNumber(userDTO.getSerialNumber());
         addUser.setWeight(userDTO.getWeight());
         addUser.setHeight(userDTO.getHeight());
         addUser.setBloodGroup(userDTO.getBloodGroup());
         addUser.setCallStatus(userDTO.getCallStatus());
         addUser.setCardNumber(userDTO.getCardNumber());
         addUser.setCameAmbulance(userDTO.getCameAmbulance());
         addUser.setDistrictName(userDTO.getDistrictName());
         addUser.setStreet(userDTO.getStreet());
         addUser.setApartment(userDTO.getApartment());
         addUser.setHomeNumber(userDTO.getHomeNumber());
         addUser.setCallPatient(userDTO.getCallPatient());
         addUser.setResidenceAddress(userDTO.getResidenceAddress());
         addUser.setPhoneNumber(userDTO.getPhoneNumber());
         addUser.setIllnessInfo(userDTO.getIllnessInfo());

         userRepository.save(addUser);

         return new ApiResponse("Added",true);
     }
     return new ApiResponse("This kind of phoneNumber allready defined",false);
    }

    public List<UserInfo> getAll() {
        List<UserInfo> all = userRepository.findAll();
        return all;
    }

    public UserInfo oneUser(Integer id) {
        Optional<UserInfo> byId = userRepository.findById(id);
        return byId.orElse(null);
    }

    public ApiResponse editUser(UserInfoDto userDTO, Integer id) {
        Optional<UserInfo> byId = userRepository.findById(id);



        if(byId.isPresent()){

            UserInfo editUser=byId.get();

            editUser.setFirstName(userDTO.getFirstName());
            editUser.setLastName(userDTO.getLastName());
            editUser.setAge(userDTO.getAge());
            editUser.setJShir(userDTO.getJShir());
            editUser.setSerialNumber(userDTO.getSerialNumber());
            editUser.setWeight(userDTO.getWeight());
            editUser.setHeight(userDTO.getHeight());
            editUser.setBloodGroup(userDTO.getBloodGroup());
            editUser.setCallStatus(userDTO.getCallStatus());
            editUser.setCardNumber(userDTO.getCardNumber());
            editUser.setCameAmbulance(userDTO.getCameAmbulance());
            editUser.setDistrictName(userDTO.getDistrictName());
            editUser.setStreet(userDTO.getStreet());
            editUser.setApartment(userDTO.getApartment());
            editUser.setHomeNumber(userDTO.getHomeNumber());
            editUser.setCallPatient(userDTO.getCallPatient());
            editUser.setResidenceAddress(userDTO.getResidenceAddress());
            editUser.setPhoneNumber(userDTO.getPhoneNumber());
            editUser.setIllnessInfo(userDTO.getIllnessInfo());

            userRepository.save(editUser);

            return new ApiResponse("Changed",true);
        }
        return new ApiResponse("This kind of user not present",false);
    }

    public ApiResponse deleteUser(Integer id) {
        Optional<UserInfo> byId = userRepository.findById(id);
        if (byId.isPresent()){
            UserInfo user=byId.get();
            userRepository.delete(user);

            userRepository.save(user);
            return new ApiResponse("Deleted",true);
        }
        return new ApiResponse("Not Found",false);
    }
}
