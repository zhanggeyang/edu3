package com.example.edu.service.impl;

import com.example.edu.bean.Teacher;
import com.example.edu.mapper.webMapper;
import com.example.edu.service.webService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: edu
 * @PackageName: com.example.edu.service.impl
 * @ClassName: webServiceImpl
 * @Date: 2020年04月14日 23:44
 * @Author: zhanggeyang
 * @Description:
 **/

@Service
public class webServiceImpl implements webService {

    @Autowired
    private webMapper webMapper;

    @Override
    public void insertTeacher(Teacher teacher) {
        webMapper.insertNew(teacher);
    }

    @Override
    public boolean getTeacher(Teacher teacher) {
        Teacher teacher1 = webMapper.getTeacher(teacher);
        if (teacher1 != null) {
            return true;
        }
        return false;

    }
}
