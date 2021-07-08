package com.xm.mapper;


import com.xm.enity.Books;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BooksMapper {
    List<Books> queryAllBooks();
    Books queryABooks(@Param("bookID") int id);
    int addBook(@Param("books") Books books);
    int updateBook(Books books);
    int deleteBooks(@Param("id") Integer id);
}
