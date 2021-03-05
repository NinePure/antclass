package com.gjs.antclass.class0010;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * InvocationHandlerImpl
 *
 * @author gujiashun
 * @date 2021/3/2
 */
public class InvocationHandlerImpl implements InvocationHandler {

    private Object target;

    public InvocationHandlerImpl(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("begin");
        result = method.invoke(target, args);
        System.out.println("end");
        return result;
    }

    public static void main(String[] args) {
        IUserDao userDao = new UserDaoImpl();
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(userDao);
        ClassLoader classLoader = userDao.getClass().getClassLoader();
        Class<?>[] interfaces = userDao.getClass().getInterfaces();
        IUserDao o = (IUserDao)Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        o.addUser();
        o.save();
    }
}
