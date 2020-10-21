package com.example.edu.mapper;

import com.example.edu.bean.Teacher;
import org.apache.ibatis.annotations.Mapper;


/**
 * @ProjectName: edu
 * @PackageName: com.example.edu.com.example.edu.mapper
 * @InterfaceName: webMapper
 * @Date: 2020年04月14日 23:45
 * @Author: zhanggeyang
 * @Description:
 **/

@Mapper
public interface webMapper {

    void insertNew(Teacher teacher);

    Teacher getTeacher(Teacher teacher);
}
