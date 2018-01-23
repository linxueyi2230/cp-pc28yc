package com.dandanyc.util;

import com.dandanyc.entity.KenoDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

/**
 * Created by prothezou on 2016/12/24.
 */
public class KenoUtil {

    private static final Log log = LogFactory.getLog(KenoUtil.class);

    /**
     * 获取PC蛋蛋最近30期开奖数据
     *
     * @return
     */
    public static List<KenoDTO> getKenoInfo() {
        try {
            String kenoResult = HttpUtil.sendPost(PropertiesUtil.getProperty
                    ("Keno_Url"),null);
            String [] resultSplit = kenoResult.split("↑");
            Random random = new Random(27);
            List<KenoDTO> kenoDTOList = new ArrayList<KenoDTO>();
            for (int i = 0;i<resultSplit.length;i++){
                if(i==30){
                    break;
                }else{
                    String [] kenoList =  resultSplit[i].split("-");
                    KenoDTO kenoDTO = new KenoDTO();
                    kenoDTO.setId(kenoList[0]);
                    kenoDTO.setDate(kenoList[3].substring(3));
                    String count = kenoList[4].replace(" ","");
                    kenoDTO.setNumber(count.substring(0,5));
                    kenoDTO.setResult(count.substring(6,8));
                    kenoDTO.setYuce(String.valueOf(random.nextInt(27)));
                    kenoDTOList.add(kenoDTO);
                }
            }
            return kenoDTOList;
        } catch (Exception ex) {
            log.error("获取PC蛋蛋数据异常：" + ex);
        }
        return null;
    }
}
