package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    BookDao bookDao;

    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testSave(){
        for(int i=0; i<15; i++){
            Book book = new Book();
            book.setType(""+i);
            book.setName(""+i);
            book.setDescription(""+i);
            bookDao.insert(book);
        }
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(2);
        book.setType("测试数据abc");
        book.setName("测试数据abc");
        book.setDescription("测试数据abc");
        bookDao.updateById(book);
    }

    @Test
    void testDelete(){
        bookDao.deleteById(2);
    }

    @Test
    void testGetAll(){
        bookDao.selectList(null);
    }

    @Test
    void testGetPage(){
        // 在这里是使用拦截器进行实现的
        //IPage page = new Page(1, 5);
        IPage page = new Page(2, 5);
        // 使用分类需要两个最基本的数据 当前所处的是第几页 每一页有多少条
        bookDao.selectPage(page, null);
        System.out.println(page.getCurrent()); // 表示当前第几页
        System.out.println(page.getSize()); // 就是每一页多少条数据
        System.out.println(page.getTotal()); // 一共多少条数据
        System.out.println(page.getPages()); // 就是一共多少页
        System.out.println(page.getRecords()); //
    }

    @Test
    void testGetBy(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        //select * from tbl_book where name like %spring%
        qw.like("name", "spring");
        bookDao.selectList(qw);
    }


    @Test
    void testGetBy2(){
        String name = "Spring";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        // if(name!=null) lqw.like(Book::getName, name);
        lqw.like(name!=null,Book::getName, name);
        bookDao.selectList(lqw);
    }
}
