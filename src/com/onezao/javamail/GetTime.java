package com.onezao.javamail;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;



public class GetTime {
	@Test
    public static String getTime(){
	//我要获取当前的日期
    Date date = new Date();
    //设置要获取到什么样的时间
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
    //获取String类型的时间
    String createdate = sdf.format(date);
    System.out.println(createdate);
    return createdate;
    }
}
