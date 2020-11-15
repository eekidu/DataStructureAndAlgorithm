package com.kee.search;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import static org.junit.Assert.*;

public class BinarySearchTest {

    private float aFloat;

    @Test
    public void name() {
        byte[] bytes = "7".getBytes();
        System.out.println(bytes[0]);

        char[] chars = new char[]{55, 51, 50, 71};
        System.out.println(java.lang.String.valueOf(chars));


        aFloat = 4f / 1024 / 1024;
        int i = (int) (Integer.MAX_VALUE * aFloat);
        System.out.println(i);

        System.out.println(String.format("%f", aFloat));
    }

    @Test
    public void name1() {
        Class clazz = null;
        Type[] genericInterfaces = clazz.getGenericInterfaces();
        if (genericInterfaces != null)
            for (int i = 0; i < genericInterfaces.length; i++) {
                Type genericInterface = genericInterfaces[i];
                if (genericInterface instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) genericInterface;
                    Type rawType = parameterizedType.getRawType();
//                    if (IItemView.class.equals(rawType)) {
//                        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
//                        if (actualTypeArguments != null && actualTypeArguments.length > 0) {
//                            Type actualTypeArgument = actualTypeArguments[0];
//                            String typeName = ((Class) actualTypeArgument).getSimpleName();
//                            String errorMsg = String.format("(%s.java:1) bindData() expected: (%s.class),but was: (%s.class)!", itemView.getClass().getSimpleName(), typeName, data.getClass().getSimpleName());
//                            RuntimeException runtimeException = new RuntimeException(errorMsg, ex);
//                            throw runtimeException;
//                        }
//                    }
                }
            }
//        throw ex;

//        StackTraceElement[] stackTrace = ex.getStackTrace();
//        StackTraceElement stackTraceElement = stackTrace[0];
//        String classAndLine = stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber();
    }
}