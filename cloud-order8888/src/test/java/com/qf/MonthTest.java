package com.qf;

import org.junit.Test;

import java.util.Date;
import java.time.*;

/**
 * @Auther: Lcs
 * @Date: 2020/9/5 21:05
 * @Description:
 */
public class MonthTest {
    @Test
    public void test(){
        System.out.println(new Date());
        System.out.println(new Date().getTime());
        System.out.println(LocalDate.now().minusMonths(3));
        System.out.println(LocalDateTime.now().getMonth());
    }
}
