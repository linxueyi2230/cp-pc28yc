package com.dandanyc.task;

import com.dandanyc.entity.KenoDTO;
import com.dandanyc.util.KenoUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by prothezou on 2017/5/13.
 */
@Component
public class KenoTask {

        @Scheduled(cron = "*/3 * * * * ?")
        public void showInfo(){
            List<KenoDTO> kenoDTOList = KenoUtil.getKenoInfo();
            for (KenoDTO k : kenoDTOList
                    ) {
                System.out.println(k.getId() + " " + k.getDate() + " " + k.getNumber
                        () + " " + k.getResult());
            }
        }

        public void test(){
            String path = getClass().getResource("/").getFile().toString();
            List<KenoDTO> kenoDTOList = KenoUtil.getKenoInfo();
            StringBuffer sb=new StringBuffer();
            for (KenoDTO k : kenoDTOList
                    ) {
                sb.append(k.getId() + "&" + k.getDate() + "&" + k.getNumber
                        () + "&" + k.getResult()+"↓");
            }
            try{
                System.out.printf(sb.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        public static void main(String[]args){
            KenoTask kenoTask=new KenoTask();
            kenoTask.test();
        }
}
