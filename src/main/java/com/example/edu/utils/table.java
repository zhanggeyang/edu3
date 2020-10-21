package com.example.edu.utils;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: edu
 * @PackageName: com.example.edu.utils
 * @ClassName: table
 * @Date: 2020年04月27日 00:11
 * @Author: zhanggeyang
 * @Description:
 **/

public class table {
    private String tablename;
    private String tablenamecontent;
    private List<Map<String,String>> fieldlist;

    @Override
    public String toString() {
        return "table{" +
                "tablename='" + tablename + '\'' +
                ", tablenamecontent='" + tablenamecontent + '\'' +
                ", fieldlist=" + fieldlist +
                '}';
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getTablenamecontent() {
        return tablenamecontent;
    }

    public void setTablenamecontent(String tablenamecontent) {
        this.tablenamecontent = tablenamecontent;
    }

    public List<Map<String, String>> getFieldlist() {
        return fieldlist;
    }

    public void setFieldlist(List<Map<String, String>> fieldlist) {
        this.fieldlist = fieldlist;
    }
}
