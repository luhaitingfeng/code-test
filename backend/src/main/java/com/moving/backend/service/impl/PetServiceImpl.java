package com.moving.backend.service.impl;

import com.alibaba.fastjson.JSON;
import com.moving.backend.pojo.pet.PetListGroupOutput;
import com.moving.backend.pojo.pet.PetListOutput;
import com.moving.backend.service.PetService;
import com.moving.backend.util.UtilHttpClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * <h3>com.moving.backend.service</h3>
 * <p></p>
 *
 * @author : Luhaitingfeng
 * @date : 2019-11-28 16:19
 **/
@Service
public class PetServiceImpl implements PetService {
    private static final String CAT_TYPE = "Cat";
    @Override
    public List<PetListGroupOutput> petList(){

        ResponseEntity<String> responseEntity = UtilHttpClient.get("http://5c92dbfae7b1a00014078e61.mockapi.io/owners", null);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            List<PetListOutput> petListOutputs = JSON.parseArray(responseEntity.getBody(), PetListOutput.class);

            if(petListOutputs!= null && petListOutputs.size()>0){
                Map<String,List<String>> petMap = new TreeMap<>();
                for (PetListOutput petListOutput : petListOutputs) {
                    List<String> names = petMap.get(petListOutput.getGender());
                    if(names!= null){
                    }else {
                        names = new ArrayList<>();
                    }
                    if(petListOutput.getPets()!= null && petListOutput.getPets().size()>0){
                        names.addAll(petListOutput.getPets().stream().filter(petOutput -> {
                            if(CAT_TYPE.equalsIgnoreCase(petOutput.getType())){
                                return true;
                            }else {
                                return false;
                            }
                        }).map(petOutput -> {
                            return petOutput.getName();
                        }).collect(Collectors.toList()));
                    }
                    petMap.put(petListOutput.getGender(), names);
                }

                List<PetListGroupOutput> petGroupList = new ArrayList();
                petMap.forEach((gender, names) -> {
                    PetListGroupOutput petListGroupOutput = new PetListGroupOutput();
                    petListGroupOutput.setGender(gender);
                    names.sort(String::compareTo);
                    petListGroupOutput.setNames(names);
                    petGroupList.add(petListGroupOutput);
                });
                return petGroupList;
            }
        }

        return null;
    }
}
