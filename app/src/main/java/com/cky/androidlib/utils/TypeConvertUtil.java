package com.cky.androidlib.utils;

/**
 * Created by cuikangyuan on 16/8/28.
 *
 * 类型安全转换
 *
 * 1.对于 Object 类型的对象, 当其为null时调用toString方法会崩溃
 * 2.如果 长度不够 调用subString方法会崩溃
 */
public class TypeConvertUtil {

    public final static int convertToInt(Object object, int defaultValue) {

        if (object == null || "".equals(object.toString().trim())) {
            return defaultValue;
        }
        try {
            return Integer.valueOf(object.toString());
        } catch (Exception e) {
            try {
                return Double.valueOf(object.toString()).intValue();
            } catch (Exception e1) {
                return defaultValue;
            }
        }

    }
}
