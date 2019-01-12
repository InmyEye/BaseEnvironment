package com.suixin.baseEnvironment.web;

import com.alibaba.druid.support.json.JSONUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class A {
    private static Logger logger=Logger.getLogger(A.class);
    @Autowired
    DataSource dataSource;
    @RequestMapping(value = "/")
    public String test(){
        System.out.printf(dataSource.toString());
        try {
           Connection connection=dataSource.getConnection();
          Statement statement= connection.createStatement();
          ResultSet set=statement.executeQuery("select *from user ");
          logger.error("我擦，mysql跑起来了！！！");
          logger.error(JSONUtils.toJSONString(convertList(set)));
        }catch (Exception e){
            logger.error("数据源好坑啊！！",e);
        }
        return "sdsdsds";
    }
    private static List convertList(ResultSet rs) throws SQLException {
        List list = new ArrayList();
        ResultSetMetaData md = rs.getMetaData();//获取键名
        int columnCount = md.getColumnCount();//获取行的数量
        while (rs.next()) {
            Map rowData = new HashMap();//声明Map
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(md.getColumnName(i), rs.getObject(i));//获取键名及值
            }
            list.add(rowData);
        }
        return list;
    }
}
