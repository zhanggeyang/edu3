package com.example.edu.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ProjectName: edu
 * @PackageName: com.example.edu.utils
 * @ClassName: TimeTest
 * @Date: 2020年10月21日 17:54
 * @Author: zhanggeyang
 * @Description: 测试累
 **/

public class TimeTest {
    public static void main(String[] args) {

        //时间测试
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").format(LocalDateTime.now()));

    }
}
