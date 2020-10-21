package com.example.edu.service;

import com.example.edu.bean.Teacher; /**
 * @ProjectName: edu
 * @PackageName: com.example.edu.service
 * @InterfaceName: webService
 * @Date: 2020年04月14日 23:43
 * @Author: zhanggeyang
 * @Description:
 **/

public interface webService {
    void insertTeacher(Teacher teacher);

    boolean getTeacher(Teacher teacher);
}
