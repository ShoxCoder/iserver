package com.example.server.service;

import com.example.server.entity.IllnessInfo;
import com.example.server.payload.ApiResponse;
import com.example.server.payload.IllnessInfoDto;
import com.example.server.repository.IllnessInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class IllnessInfoService {

    @Autowired
    IllnessInfoRepository illnessInfoRepository;
    public ApiResponse addIllnessInfo(IllnessInfoDto illnessDto) {
        IllnessInfo info=new IllnessInfo();
        if(!illnessInfoRepository.existsByIllnessName(illnessDto.getIllnessName())){

            info.setIllnessName(illnessDto.getIllnessName());
            info.setInfo1(illnessDto.getInfo1());
            info.setInfo2(illnessDto.getInfo2());
            info.setInfo3(illnessDto.getInfo3());
            info.setInfo4(illnessDto.getInfo4());
            info.setInfo5(illnessDto.getInfo5());
            info.setInfo6(illnessDto.getInfo6());
            info.setInfo7(illnessDto.getInfo7());
            info.setInfo8(illnessDto.getInfo8());
            info.setPhotoUrl(illnessDto.getPhotoUrl());


            illnessInfoRepository.save(info);

            return new ApiResponse("Information added",true);
        }
        return new ApiResponse("This kind of illnes already added",false);


    }

    public List<IllnessInfo> getAll() {
        List<IllnessInfo> all = illnessInfoRepository.findAll();
        return all;
    }

    public IllnessInfo getOne(Integer id) {
        Optional<IllnessInfo> byId = illnessInfoRepository.findById(id);

        return byId.orElse(null);
    }

    public ApiResponse edit(IllnessInfoDto illnessInfoDto, Integer id) {
        Optional<IllnessInfo> byId = illnessInfoRepository.findById(id);


        if(byId.isPresent()){
            IllnessInfo info=byId.get();

            info.setInfo1(illnessInfoDto.getInfo1());
            info.setInfo2(illnessInfoDto.getInfo2());
            info.setInfo3(illnessInfoDto.getInfo3());
            info.setInfo4(illnessInfoDto.getInfo4());
            info.setInfo5(illnessInfoDto.getInfo5());
            info.setInfo6(illnessInfoDto.getInfo6());
            info.setInfo7(illnessInfoDto.getInfo7());
            info.setInfo8(illnessInfoDto.getInfo8());
            info.setPhotoUrl(illnessInfoDto.getPhotoUrl());

            illnessInfoRepository.save(info);

            return new ApiResponse("Information changed " , true);
        }
        return new ApiResponse("this information not present",false);
    }


    public ApiResponse deleteInfo(Integer id) {
        Optional<IllnessInfo> byId = illnessInfoRepository.findById(id);

        if(!byId.isPresent())
            return new ApiResponse("This Kind of Illnes not found",false);
       illnessInfoRepository.deleteById(id);
       return new ApiResponse("deleted",true);
    }

}
