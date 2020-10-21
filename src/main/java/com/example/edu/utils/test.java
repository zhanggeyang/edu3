package com.example.edu.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ProjectName: edu
 * @PackageName: com.example.edu.utils
 * @ClassName: test
 * @Date: 2020年04月26日 20:46
 * @Author: zhanggeyang
 * @Description:
 **/

public class test {
    public static void main(String[] args) throws Exception{
        List<Object> arrayList = new ArrayList<>();
        HashMap<String, String> hashMap = new HashMap<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/zhanggeyang/Desktop/test.txt"));
        String line = null;
        StringBuffer buffer = new StringBuffer();
        while ((line = bufferedReader.readLine()) != null){
            buffer.append(line);
        }
        String[] alltable = buffer.toString().split("\n");
        for (int i = 0; i < alltable.length; i++) {
            //处理表名
            String table = alltable[i];

            //得到第一个（ 出现的位置
            int i1 = table.indexOf("(");
            //System.out.println(i1);
            String tablename = table.substring(12, i1);
            //System.out.println(tablename);

            hashMap.put("tablename",tablename);
            //得到最后一个）出现的位置
            int i2 = table.lastIndexOf(")");
            //System.out.println(i2);

            //截取（）中的内容
            String substring = table.substring(i1+1, i2);
            String[] split = substring.split(",");

            //字段集合
            for (int i3 = 0; i3 < split.length; i3++) {
                System.out.println(split[i3]);
                int i4 = split[i3].indexOf("`");
                int i5 = split[i3].lastIndexOf("`");
                String fieldname = split[i3].substring(i4, i5+1);
                //System.out.println(fieldname);
                //System.out.println(i4);
                //System.out.println(split[i3]);
                hashMap.put("fieldname",fieldname);

                //得到注释内容
                int i6 = split[i3].indexOf("'");
                int i7 = split[i3].lastIndexOf("'");
                if (split[i3].contains("KEY") || split[i3].contains("PRIMARY")){
                    continue;
                }
                String fieldcontent = split[i3].substring(i6, i7);
                hashMap.put("fieldcontent",fieldcontent);

                //判断是否必须字段
                if (split[i3].contains("NOT")){
                    hashMap.put("isneed","是");
                }else {
                    hashMap.put("isneed","否");
                }
                arrayList.add(hashMap);
            }


        }
        System.out.println(arrayList);
    }
}
