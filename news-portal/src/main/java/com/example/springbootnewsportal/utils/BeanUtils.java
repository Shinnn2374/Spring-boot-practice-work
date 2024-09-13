package com.example.springbootnewsportal.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;

@UtilityClass
public class BeanUtils
{
    @SneakyThrows
    public void copyNonNullProperties(Object source, Object destination)
    {
        Class<?> sourceClass = source.getClass();
        Field[] declaredFields = sourceClass.getDeclaredFields();

        for (Field field : declaredFields)
        {
            field.setAccessible(true);
            Object value = field.get(source);
            if (value != null)
            {
                field.set(destination, value);
            }
        }
    }
}
