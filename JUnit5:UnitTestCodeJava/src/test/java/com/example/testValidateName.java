package com.example;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class testValidateName {

    @Test
    public void test1(){
        validateName test1 = new validateName("phamhonghuy");
        assertTrue(test1.isValid());
    }
    @Test
    public void test2(){
        validateName test1 = new validateName("pham honghuy");
        assertFalse(test1.isValid());
    }
    @Test
    public void test3(){
        validateName test1 = new validateName("phamhonghuy**");
        assertFalse(test1.isValid());
    }
    @Test
    public void test4(){
        validateName test1 = new validateName("Phamhonghuy");
        assertFalse(test1.isValid());
    }
    @Test
    public void test5(){
        validateName test1 = new validateName("Phamhonghuy!");
        assertFalse(test1.isValid());
    }
    @Test
    public void test6(){
        validateName test1 = new validateName("Phamhonghuy ");
        assertFalse(test1.isValid());
    }
    @Test
    public void test7(){
        validateName test1 = new validateName(" Phamhonghuy");
        assertFalse(test1.isValid());
    }
    @Test
    public void test8(){
        validateName test1 = new validateName("@Phamhonghuy");
        assertFalse(test1.isValid());
    }
    @Test
    public void test9(){
        validateName test1 = new validateName("Pham hong huy");
        assertFalse(test1.isValid());
    }
    @Test
    public void test10(){
        validateName test1 = new validateName("Phamhonghuy0. _");
        assertFalse(test1.isValid());
    }
    @Test
    public void test11(){
        validateName test1 = new validateName("Pham()honghuy");
        assertFalse(test1.isValid());
    }
    @Test
    public void test12(){
        validateName test1 = new validateName("{Phamhonghuy}");
        assertFalse(test1.isValid());
    }

}
