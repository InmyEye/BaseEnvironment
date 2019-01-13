package com.suixin.baseEnvironment.test;

import com.alibaba.fastjson.JSON;
import com.suixin.baseEnvironment.Application;
import com.suixin.baseEnvironment.dao.UserMapper;
import com.suixin.baseEnvironment.domain.dataObject.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes ={Application.class})
@RunWith(SpringRunner.class)
public class MybatisTest {
    Logger logger=Logger.getLogger(MybatisTest.class);
    @Autowired
    DataSource dataSource;
    @Autowired
    UserMapper userMapper;
    @Test
    public void test(){
        try {
            Connection connection=dataSource.getConnection();
            Statement statement= connection.createStatement();
            ResultSet set=statement.executeQuery("select *from user ");
            logger.error(JSON.toJSONString(convertList(set)));
            logger.error("数据源启动成功！");
            User user=userMapper.selectByPrimaryKey(1);
            logger.error(JSON.toJSONString(user));
            logger.error("mybatis启动成功！");
        }catch (Exception e){
            logger.error("数据源好坑啊！！",e);
        }

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
