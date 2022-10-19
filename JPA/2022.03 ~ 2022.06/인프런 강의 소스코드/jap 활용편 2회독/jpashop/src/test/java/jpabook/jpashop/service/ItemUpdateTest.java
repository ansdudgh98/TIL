package jpabook.jpashop.service;

import jpabook.jpashop.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ItemUpdateTest {

    @Autowired
    EntityManager em;

    @Test
    public void updateTest() throws Exception{
        Book book = em.find(Book.class,1L);

        //TX
        book.setName("asdasdasd!!");

        //변경감지 == dirty checking
        //update가능
    }

}