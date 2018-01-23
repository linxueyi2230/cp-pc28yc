package com.dandanyc.util;

import java.util.regex.Pattern;

/**
 * Created by prothezou on 2017/2/7.
 */
public class RegExpUtil {

    private static final String NameReg = "[0-9a-zA-Z]{6,18}";

    private static final String QqReg = "[0-9]{4,10}";

    private static final String UserNameReg = "[0-9a-zA-Z]{6,18}";

    private static final String UserPasswordReg = "[0-9a-zA-Z]{6,18}";

    /**
     * 判断用户名
     *
     * @param name
     * @return
     */
    public static boolean isName(String name) {
        if (Pattern.matches(NameReg, name)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断QQ
     *
     * @param qq
     * @return
     */
    public static boolean isQq(String qq) {
        if (Pattern.matches(QqReg, qq)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断登录名
     *
     * @param uname
     * @return
     */
    public static boolean isUserName(String uname) {
        if (Pattern.matches(UserNameReg, uname)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断登录密码
     *
     * @param password
     * @return
     */
    public static boolean isUserPassword(String password) {
        if (Pattern.matches(UserPasswordReg, password)) {
            return true;
        } else {
            return false;
        }
    }
}
