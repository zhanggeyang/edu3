package com.example.edu.bean;

import lombok.Data;

/**
 * @ProjectName: edu
 * @PackageName: com.example.edu.bean
 * @ClassName: AttachFile
 * @Date: 2020年04月18日 10:48
 * @Author: zhanggeyang
 * @Description:
 **/

@Data
public class AttachFile {

    //用户关联id
    private String userId;
    //附件名称
    private String name;
    //附件类型
    private String type;
    //上传时间
    private String date;
    //附件地址
    private String location;
}
