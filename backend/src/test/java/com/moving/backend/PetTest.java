package com.moving.backend;

import com.moving.backend.controller.PetController;
import com.moving.backend.pojo.ResponseOutput;
import com.moving.backend.pojo.pet.PetListGroupOutput;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

/**
 * <h3>com.moving.backend</h3>
 * <p></p>
 *
 * @author : Luhaitingfeng
 * @date : 2019-11-28 18:17
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BackendApplication.class})
public class PetTest {

    @Autowired
    private PetController petController;

    @Test
    public void testPetController(){
        ResponseOutput<List<PetListGroupOutput>> responseOutput = petController.petList();
        Boolean success = responseOutput.getSuccess();
        Assert.assertTrue(success);
        Assert.assertNotNull(responseOutput.getData());
        System.out.println(responseOutput.getData());
    }
}
