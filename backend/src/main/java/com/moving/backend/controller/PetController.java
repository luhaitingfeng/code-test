package com.moving.backend.controller;

import com.moving.backend.pojo.pet.PetListGroupOutput;
import com.moving.backend.pojo.ResponseOutput;
import com.moving.backend.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h3>com.moving.backend.controller</h3>
 * <p>Resolve Pet Data</p>
 *
 * @author : Luhaitingfeng
 * @date : 2019-11-28 15:11
 **/
@RestController
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("test")
    public String test(){
        return "ok";
    }

    @GetMapping("/api/petList.backend")
    public ResponseOutput<List<PetListGroupOutput>> petList()  {

        List<PetListGroupOutput> petListGroupOutputs = petService.petList();
        return ResponseOutput.ok(petListGroupOutputs);
    }

}
