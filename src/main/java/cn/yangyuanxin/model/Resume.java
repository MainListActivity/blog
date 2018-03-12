package cn.yangyuanxin.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by y
 * on 2018/3/11
 */
@Document(collection = "resume")
public class Resume {
    @Field
    private String name;
    @Field
    private String gender;


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
}
