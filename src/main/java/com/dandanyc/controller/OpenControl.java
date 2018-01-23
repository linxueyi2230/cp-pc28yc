package com.dandanyc.controller;

import com.alibaba.fastjson.JSONArray;
import com.dandanyc.entity.CanadaDTO;
import com.dandanyc.entity.KenoDTO;
import com.dandanyc.util.CanadaUtil;
import com.dandanyc.util.KenoUtil;
import com.dandanyc.util.PropertiesUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/Open")
@RestController
public class OpenControl {

    /**
     * 唯一Token凭证
     */
    private String tokenOnly = PropertiesUtil.getProperty("Token");

    /**
     * 幸运28数据
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/KenoInfo", method = RequestMethod.GET)
    public String getKenoInfo(HttpServletRequest request) {
        String info = null;
        String token = request.getParameter("Token");
        List<KenoDTO> kenoDTOList = KenoUtil.getKenoInfo();
        JSONArray jsonArray = new JSONArray();
        if (tokenOnly.equals(token)) {
            if (kenoDTOList != null && !kenoDTOList.isEmpty()) {
                jsonArray.add(kenoDTOList);
                info = jsonArray.toString();
            }
        }
        return info;
    }

    /**
     * 加拿大28数据
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/CanadaInfo", method = RequestMethod.GET)
    public String getCanadaInfo(HttpServletRequest request) {
        String info = "";
        String token = request.getParameter("Token");
        List<CanadaDTO> canadaInfo = CanadaUtil.getCanadaInfo();
        JSONArray jsonArray = new JSONArray();
        if (tokenOnly.equals(token)) {
            if (canadaInfo != null && !canadaInfo.isEmpty()) {
                jsonArray.add(canadaInfo);
                info = jsonArray.toString();
            }
        }
        return info;
    }

}
