package com.gjs.antclass.class0012;

import com.gjs.antclass.class0007.Test01;

/**
 * Book1
 *
 * @author gujiashun
 * @date 2021/3/4
 */
public class Book1 implements Cloneable{

    String name;
    int num;
    Test01 test;

    /**
     * 获取 name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 name.
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Object clone() throws CloneNotSupportedException {
        Object clone = super.clone();
        return clone;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Book1 book1 = new Book1();
        book1.setName("123");
        book1.num = 111;
        book1.test = new Test01();
        Book1 clone = (Book1)book1.clone();
        System.out.println(Integer.toHexString(book1.name.hashCode()));
        System.out.println(Integer.toHexString(clone.name.hashCode()));
        System.out.println(book1.test);
        System.out.println(clone.test);
        System.out.println(book1.test.hashCode());
        System.out.println(clone.test.hashCode());
//        book1.setName("1234");
//        book1.num = 114;
//        book1.test = new Test01();
//        System.out.println(clone.getName());
//        System.out.println(clone.getName() == book1.getName());
//        System.out.println(clone.num == book1.num);
//        System.out.println(clone.test == book1.test);

    }
}
