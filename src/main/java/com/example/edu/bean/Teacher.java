package com.example.edu.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


/**
 * @ProjectName: homeedu
 * @PackageName: com.edu.bean
 * @ClassName: Teacher
 * @Date: 2020年04月11日 17:44
 * @Author: zhanggeyang
 * @Description: 教师类
 **/

@Data
public class Teacher {

    @NotBlank(message = "姓名不能为空")
    private String name;
    private String age;
    private String address;
    private String school;
    private String gender;
    private String nickname;
    private String personId;
    private String applyid;

    @NotBlank(message = "密码不能为空")
    private String password;
    private String identifyId;

    @NotBlank(message = "手机不能为空")
    private String mobile;

    private Date registerTime;//
    private String degree;
    private String subject;
    private int isUseable;//账号是否可用
    private int isCertificate;//是否实名认证

    private List<AttachFile> attachFileList;


}
