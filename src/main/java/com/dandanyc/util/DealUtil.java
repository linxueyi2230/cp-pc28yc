package com.dandanyc.util;

/**
 * Created by prothezou on 2016/10/27.
 */
public class DealUtil {

    /**
     * 处理0-9数字
     * @param random
     * @return
     */
    public static String  zero(String random){
        String zero="";
        try {
            if(null!=random||!"".equals(random)){
                if ("0".equals(random)){
                    zero="00";
                }else if("1".equals(random)){
                    zero="01";
                }else if("2".equals(random)){
                    zero="02";
                }else if("3".equals(random)){
                    zero="03";
                }else if("4".equals(random)){
                    zero="04";
                }else if("5".equals(random)){
                    zero="05";
                }else if("6".equals(random)){
                    zero="06";
                }else if("7".equals(random)){
                    zero="07";
                }else if("8".equals(random)){
                    zero="08";
                }else if("9".equals(random)){
                    zero="09";
                }else {
                    zero=random;
                }
            }else{
                zero="00";
            }
        }catch (Exception ex){

        }
        return  zero;
    }
}
