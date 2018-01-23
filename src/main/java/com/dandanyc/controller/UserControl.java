//package com.dandanyc.controller;
//
//import com.alibaba.fastjson.JSONObject;
//import com.dandanyc.entity.User;
//import com.dandanyc.service.UserService;
//import com.dandanyc.util.MD5Tools;
//import com.dandanyc.util.RegExpUtil;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by prothezou on 2016/12/31.
// */
//@RequestMapping("/User")
//@Controller
//public class UserControl {
//
//    private static final Log log = LogFactory.getLog(UserControl.class);
//
//    @Autowired
//    private UserService userService;
//
//    @RequestMapping(value = "/toRegister", method = RequestMethod.GET)
//    public ModelAndView toUserRegister(ModelAndView modelAndView) {
//        modelAndView.setViewName("User/Register");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/toUserLogin", method = RequestMethod.GET)
//    public ModelAndView toUserLogin(ModelAndView modelAndView, HttpServletRequest request) {
//        Cookie[] cookies = request.getCookies();
//        if (null == cookies) {
//            modelAndView.setViewName("User/UserLogin");
//        } else {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("isFlagLogin")) {
//                    User user = userService.selectByUserName(cookie.getValue());
//                    if (user!=null){
//                        modelAndView.setViewName("User/UserLogin");
//                    }else{
//                        modelAndView.setViewName("/index");
//                    }
//                }
//            }
//        }
//        return modelAndView;
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/addRegister", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
//    public String addUserRegister(HttpServletRequest request, HttpServletResponse response) {
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        JSONObject jsonObject = new JSONObject();
//        String name = request.getParameter("name");
//        String qq = request.getParameter("qq");
//        String userName = request.getParameter("username");
//        String userPassword = request.getParameter("password");
//
//        if (!RegExpUtil.isName(name)) {
//            map.put("errorInfo", "蛋蛋昵称建议在6~18位!");
//            map.put("errorCode", "10001");
//            jsonObject.put("error", map);
//            return jsonObject.toJSONString();
//        }
//        if (!RegExpUtil.isQq(qq)) {
//            map.put("errorInfo", "QQ号建议在4~10位!");
//            map.put("errorCode", "10001");
//            jsonObject.put("error", map);
//            return jsonObject.toJSONString();
//        }
//        if (!RegExpUtil.isUserName(userName)) {
//            map.put("errorInfo", "登录账号建议在6~18位,必须是数字与字母组合!");
//            map.put("errorCode", "10001");
//            jsonObject.put("error", map);
//            return jsonObject.toJSONString();
//        }
//        if (!RegExpUtil.isUserPassword(userPassword)) {
//            map.put("errorInfo", "登录密码建议在6~18位,必须是数字与字母组合!");
//            map.put("errorCode", "10001");
//            jsonObject.put("error", map);
//            return jsonObject.toJSONString();
//        }
//
//        try {
//            // 检测该用户是否注册
//            User userInfo = userService.selectByUserName(userName);
//            if (userInfo != null) {
//                map.put("errorInfo", "该登录账号已经被注册,请换一个试试。");
//                map.put("errorCode", "10001");
//                jsonObject.put("error", map);
//                return jsonObject.toJSONString();
//            } else {
//                User user = new User();
//                user.setEggsUsername(userName);
//                user.setEggsPassword(userPassword);
//                user.setEggsKey(MD5Tools.MD5(userPassword));
//                user.setEggsDate(new Date());
//                user.setEggsQq(qq);
//                user.setEggsName(name);
//                int count = userService.insert(user);
//                if (count > 0) {
//                    Cookie cookie = new Cookie("isFlagLogin", userName);
//                    cookie.setPath("/");
//                    cookie.setMaxAge(24 * 60);
//                    response.addCookie(cookie);
//                    map.put("errorInfo", "注册成功");
//                    map.put("errorCode", "10000");
//                    jsonObject.put("error", map);
//                    return jsonObject.toJSONString();
//                } else {
//                    map.put("errorInfo", "注册失败,可能服务器正在维护...");
//                    map.put("errorCode", "10001");
//                    jsonObject.put("error", map);
//                    return jsonObject.toJSONString();
//                }
//            }
//        } catch (Exception ex) {
//            log.error("注册账号异常信息:" + ex);
//        }
//
//        return "";
//    }
//
//}
