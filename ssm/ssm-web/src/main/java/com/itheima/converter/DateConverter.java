package com.itheima.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义日期转换器
 */
public class DateConverter implements Converter<String,Date> {
    /**
     * 实现转换逻辑的方法
     */
    public Date convert(String source) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return format.parse(source);
        } catch (ParseException e) {
            // 转换异常，再按照yyyy-MM-dd HH:mm格式转换
            format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            // 转换成功，直接返回
            try {
                return format.parse(source);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        //转换失败,返回null
        return null;
    }

}
