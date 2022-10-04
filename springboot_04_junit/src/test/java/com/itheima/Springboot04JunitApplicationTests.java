package com.itheima;

import com.itheima.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Springboot04JunitApplication.class)
class Springboot04JunitApplicationTests {
    //1. 注入你要进行测试的对象
    @Autowired
    private BookDao bookDao;


    @Test
    void contextLoads() {
        //2. 执行要进行测试的对象所对应的方法
        bookDao.save();
    }

}
