package com.dennis.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Blue {
    private String name = "蓝色";
    public static void main(String[] args) {
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.set(2019, 12, 1, 7, 30, 0);
        Date time = instance.getTime();
        long time1 = time.getTime();
        System.out.println("--------------------");
        System.out.println(time1);
        Date date1 = new Date(time1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日：HH:mm:ss");
        String format = simpleDateFormat.format(date1);
        System.out.println(format);
    }
}
