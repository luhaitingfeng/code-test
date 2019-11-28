package com.moving.backend.service;

import com.moving.backend.pojo.PetListGroupOutput;
import com.moving.backend.pojo.PetListOutput;

import java.util.List;

/**
 * <h3>com.moving.backend.service</h3>
 * <p></p>
 *
 * @author : Luhaitingfeng
 * @date : 2019-11-28 16:20
 **/
public interface PetService {
    List<PetListGroupOutput> petList();
}
