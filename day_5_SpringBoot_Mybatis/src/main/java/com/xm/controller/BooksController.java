package com.xm.controller;

import com.xm.enity.Books;
import com.xm.mapper.BooksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BooksController {

    @Autowired
    BooksMapper booksMapper;

    @RequestMapping("/test1")
    @ResponseBody
    public String test1(){
        List<Books> books = booksMapper.queryAllBooks();
        //System.out.println(books);
        return books.toString();
    }

    @RequestMapping("/test2/{id}")
    @ResponseBody
    public String test2(@PathVariable("id") Integer id){
        Books books = booksMapper.queryABooks(id);
        System.out.println(books);
        return books.toString();
    }

    // 增
    @RequestMapping("/test3/{bookID}/{bookName}/{bookCounts}/{detail}")
    @ResponseBody
    public int test3(Books books){   // 以对象接收不用加@PathVariable
        System.out.println(books);
        int i = booksMapper.addBook(books);
        return i;
    }

    // 删
    @RequestMapping("/test4/{bookID}")
    @ResponseBody
    public int test4(@PathVariable("bookID") Integer id){
        int i = booksMapper.deleteBooks(id);
        return i;
    }

    //更新
    @RequestMapping("/test5/{bookID}/{bookName}/{bookCounts}/{detail}")
    @ResponseBody
    public int test5(Books books){
        int i = test4(books.getBookID());
        booksMapper.addBook(books);
        return i;

    }
}
