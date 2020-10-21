package com.example.edu.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: homeedu
 * @PackageName: com.edu.bean
 * @ClassName: Student
 * @Date: 2020年04月11日 17:52
 * @Author: zhanggeyang
 * @Description: 学生类
 **/

@Data

public class Student{


    private String name;
    private String age;
    private String address;
    private String school;
    private String gender;
    private String nickname;
    private String personId;
    @NotNull(message = "不能为空")
    private String password;
    private String identifyId;
    @NotNull(message = "不能为空")
    private String mobile;
    private Date registerTime;//
    private String grade;

}
