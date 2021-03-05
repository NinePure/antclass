package com.gjs.antclass.class0010;

/**
 * UserDaoImpl
 *
 * @author gujiashun
 * @date 2021/3/2
 */
public class UserDaoImpl implements IUserDao {
    @Override
    public String addUser() {
        System.out.println("addUser");
        return "addUser123";
    }

    @Override
    public String save() {
        System.out.println("save");
        return "save123";
    }
}
