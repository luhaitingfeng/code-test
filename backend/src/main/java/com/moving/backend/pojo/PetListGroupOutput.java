package com.moving.backend.pojo;

import java.util.List;

/**
 * <h3>com.moving.backend.pojo</h3>
 * <p></p>
 *
 * @author : Luhaitingfeng
 * @date : 2019-11-28 16:25
 **/
public class PetListGroupOutput {
    private String gender;
    private List<String> names;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
