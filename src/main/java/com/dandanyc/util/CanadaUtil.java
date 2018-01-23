package com.dandanyc.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dandanyc.entity.CanadaDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by prothezou on 2016/12/23.
 */
public class CanadaUtil {

    private static final Log log = LogFactory.getLog(CanadaUtil.class);

    /**
     * 获取加拿大开奖数据
     *
     * @return
     */
    public static List<CanadaDTO> getCanadaInfo() {
        try {
            String result = HttpUtil.sendPost(PropertiesUtil.getProperty
                    ("Canada_Url"),null);
            List<CanadaDTO> canadaDTOList = new ArrayList<CanadaDTO>();
            Random random = new Random(27);
            String [] arrays = result.split("↑");
            for (int i = 0;i<arrays.length;i++){
                if(i==30){
                    break;
                }else{
                    String [] canada = arrays[i].split("-");
                    CanadaDTO canadaDTO = new CanadaDTO();
                    canadaDTO.setId(canada[0]);
                    canadaDTO.setDate(canada[1]);
                    canadaDTO.setNumber(canada[2]);
                    String [] count = canada[2].split("\\+");
                    canadaDTO.setResult(String.valueOf(Integer.parseInt(count[0])+Integer.parseInt(count[1])+Integer.parseInt(count[2])));
                    canadaDTO.setYuce(String.valueOf(random.nextInt(27)));
                    canadaDTOList.add(canadaDTO);
                }
            }
            return canadaDTOList;
        } catch (Exception ex) {
            log.error("获取加拿大数据异常：" + ex);
        }
        return null;
    }

}
