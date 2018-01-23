package com.dandanyc.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;
/**
 * Created by prothezou on 2016/10/29.
 */
public class PropertiesUtil {

    private static final Log log = LogFactory.getLog(PropertiesUtil.class);

    private static Properties prt = new Properties();

    static {
        try {
            //PropertiesHelper.class.getResourceAsStream("env.properties"); // /com/cici/conf/env.properties
            //ClassLoader.getSystemResourceAsStream("env.properties");
            InputStream is = PropertiesUtil.class.getClassLoader()
                    .getResourceAsStream("other.properties");
            prt.load(is);
            is.close();
        } catch (Exception e) {
            log.error(e);
        }
    }

    /**
     * 取属性值
     * @param key
     * @return
     */
    public static String getProperty(String key){
        return prt.getProperty(key);
    }

    /**
     * 设置属性值
     * @param key
     * @param value
     */
    public static void setProperty(String key, String value){
        try{
            File file = new File(PropertiesUtil.class.getClassLoader().getResource(".").getPath()+File.separator+"env.properties");
            FileOutputStream outStream = new FileOutputStream(file);
            prt.setProperty(key, value);
            //写入properties文件
            prt.store(outStream, null);
        } catch (Exception ex) {
            log.error(ex);
        }
    }

}
