package com.moving.backend.pojo;

import java.util.List;

/**
 * <h3>com.moving.backend.pojo</h3>
 * <p></p>
 *
 * @author : Luhaitingfeng
 * @date : 2019-11-28 16:15
 **/
public class PetListOutput {
    private String name;
    private String gender;
    private Integer age;
    private List<PetOutput> pets;

    public static class PetOutput{
        private String name;
        private String type;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<PetOutput> getPets() {
        return pets;
    }

    public void setPets(List<PetOutput> pets) {
        this.pets = pets;
    }
}
