package com.nimble.univtool.enums;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;
/**
 * 枚举类
 * @Author: Nimble
 * @Version: 1.0.0
 * @Date:  2024/7/24 10:48
 */
@Getter
public enum EnumType {
    /**
     * 火车
     */
    TRAIN("0","^[GCDZTSPKXLY1-9]\\d{1,4}$","火车车次"),
    /**
     * 手机机身号
     */
    IMEI_NUMBER("1","^\\d{15,17}$","手机机身号"),
    /**
     * 必须带有端口的网址或IP
     */
    WEBSITE_PORT("2","^((ht|f)tps?:\\/\\/)?[\\w-]+(\\.[\\w-]+)+:\\d{1,5}\\/?$","必须带端口的网址(或IP)"),
    /**
     * 网址(url,支持端口和"?+参数"和”#+参数“)
     */
    WEBSITE_PORT_PARAM("3","^(((ht|f)tps?):\\\\/\\\\/)?[\\\\w-]+(\\\\.[\\\\w-]+)+([\\\\w.,@?^=%&:/~+#-]*[\\\\w@?^=%&/~+#-])?$","网址(支持url,参数)"),
    /**
     * 社会统一信用代码
     */
    USCC("4","^[0-9A-HJ-NPQRTUWXY]{2}\\d{6}[0-9A-HJ-NPQRTUWXY]{10}$","社会统一信用代码"),
    /**
     * 迅雷连接
     */
    THUNDER("5","^thunderx?:\\/\\/[a-zA-Z\\d]+=$","迅雷连接"),
    /**
     * 子网掩码
     */
    MASK("6","^(?:\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])(?:\\.(?:\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])){3}$","子网掩码"),
    /**
     * 大于等于0，小于等于150，支持小数位出现5
     */
    EXAMINATION_PAPER("7","^150$|^(?:\\d|[1-9]\\d|1[0-4]\\d)(?:.5)?$","大于等于0，小于等于150，支持小数位出现5(用于考卷)"),
    /**
     * md5格式
     */
    MD5_FORMAT("8","^([a-f\\d]{32}|[A-F\\d]{32})$","md5格式"),
    /**
     * video连接地址
     */
    VIDEO_ADDR("9","^https?:\\/\\/(.+\\/)+.+(\\.(swf|avi|flv|mpg|rm|mov|wav|asf|3gp|mkv|rmvb|mp4))$","video连接地址"),
    /**
     * video连接地址
     */
    IMG_ADDR("10","^https?:\\/\\/(.+\\/)+.+(\\.(gif|png|jpg|jpeg|webp|svg|psd|bmp|tif))$","图片链接地址"),
    /**
     * 24小时制时间(HH:mm:ss)
     */
    HH_24("11","^(?:[01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$","24小时制时间(HH:mm:ss)"),
    /**
     * 12小时制时间(hh:mm:ss)
     */
    HH_12("12","^(?:1[0-2]|0?[1-9]):[0-5]\\d:[0-5]\\d$","12小时制时间(hh:mm:ss)"),
    /**
     * base64格式
     */
    BASE64_FORMAT("13","^\\s*data:(?:[a-z]+\\/[a-z0-9-+.]+(?:;[a-z-]+=[a-z0-9-]+)?)?(?:;base64)?,([a-z0-9!$&',()*+;=\\-._~:@/?%\\s]*?)\\s*$","base64格式"),
    /**
     * 数字/货币金额(支持负数，千分位分隔符)
     */
    AMOUNT_NEG("14","^-?\\d+(,\\d{3})*(\\.\\d{1,2})?$","数字/货币金额(支持负数，千分位分隔符)"),
    /**
     * 数字/货币金额(支持负数，千分位分隔符)
     */
    AMOUNT_POS("15","(?:^[1-9]([0-9]+)?(?:\\.[0-9]{1,2})?$)|(?:^(?:0){1}$)|(?:^[0-9]\\.[0-9](?:[0-9])?$)","数字/货币金额(支持正数，不支持千分位分隔符)"),
    /**
     * 银行卡号
     */
    BANK_CARD("16","^[1-9]\\d{9,29}$","银行卡号"),
    /**
     * 中文名
     */
    CHINA_NAME("17","^(?:[\\u4e00-\\u9fa5·]{2,16})$","中文名"),
    /**
     * 英文名
     */
    ENGLISH_NAME("18","(^[a-zA-Z]{1}[a-zA-Z\\s]{0,20}[a-zA-Z]{1}$)","英文名"),
    /**
     * 车牌号(新能源)
     */
    LICENSE_PLATE_NUMBER_ENERGY("19","[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领 A-Z]{1}[A-HJ-NP-Z]{1}(([0-9]{5}[DF])|([DF][A-HJ-NP-Z0-9][0-9]{4}))$","车牌号(新能源)"),
    /**
     * 车牌号(非新能源)
     */
    LICENSE_PLATE_NUMBER_NO_ENERGY("20","^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领 A-Z]{1}[A-HJ-NP-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$","车牌号(非新能源)"),
    /**
     * 车牌号(新能源+非新能源)
     */
    LICENSE_PLATE_NUMBER("21","^(?:[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领 A-Z]{1}[A-HJ-NP-Z]{1}(?:(?:[0-9]{5}[DF])|(?:[DF](?:[A-HJ-NP-Z0-9])[0-9]{4})))|(?:[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领 A-Z]{1}[A-Z]{1}[A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9 挂学警港澳]{1})$","车牌号"),
    /**
     * 手机号(严谨)，根据工信部2019年最新发布的号段
     */
    PHONE_NUMBER_1("22","^(?:(?:\\+|00)86)?1(?:(?:3[\\d])|(?:4[5-7|9])|(?:5[0-3|5-9])|(?:6[5-7])|(?:7[0-8])|(?:8[\\d])|(?:9[1|8|9]))\\d{8}$","手机号(严谨)"),
    /**
     * 手机号(宽松)，只要是13 14 15 16 17 18 19开头
     */
    PHONE_NUMBER_2("23","^(?:(?:\\+|00)86)?1[3-9]\\d{9}$","手机号(宽松)"),
    /**
     * 手机号(最宽松),只要是1开头即可
     */
    PHONE_NUMBER_3("24","^(?:(?:\\+|00)86)?1\\d{10}$","手机号(最宽松)"),
    /**
     * 日期
     */
    DATE("25","^\\d{4}(-)(1[0-2]|0?\\d)\\1([0-2]\\d|\\d|30|31)$","日期"),
    /**
     * 座机(国内)
     */
    TEL_PHONE("26","^\\d{3}-\\d{8}$|^\\d{4}-\\d{7}$","座机(国内)"),
    /**
     * 身份证号(1代)
     */
    ID_CARD_ONE("27","^[1-9]\\d{7}(?:0\\d|10|11|12)(?:0[1-9]|[1-2][\\d]|30|31)\\d{3}$","身份证号(1代)"),
    /**
     * 身份证号(2代)
     */
    ID_CARD_TWO("28","^[1-9]\\d{5}(?:18|19|20)\\d{2}(?:0\\d|10|11|12)(?:0[1-9]|[1-2]\\d|30|31)\\d{3}[\\dXx]$","身份证号(2代)"),
    /**
     * 身份证号(2代，18位数字)，最后一位是校验位，可能为数字或者字符X
     */
    ID_CARD("29","(^\\d{8}(0\\d|10|11|12)([0-2]\\d|30|31)\\d{3}$)|(^\\d{6}(18|19|20)\\d{2}(0\\d|10|11|12)([0-2]\\d|30|31)\\d{3}(\\d|X|x)$)","身份证号"),
    /**
     * 身份证号(1代,2代,支持15/18位数字)
     */
    ID_CARD_ALL("30","(^\\d{8}(0\\d|10|11|12)([0-2]\\d|30|31)\\d{3}$)|(^\\d{6}(18|19|20)\\d{2}(0\\d|10|11|12)([0-2]\\d|30|31)\\d{3}(\\d|X|x)$)","身份证号(1代,2代)"),
    /**
     *  护照
     */
    PASSPORT("31","(^[EeKkGgDdSsPpHh]\\d{8}$)|(^(([Ee][a-fA-F])|([DdSsPp][Ee])|([Kk][Jj])|([Mm][Aa])|(1[45]))\\d{7}$)","护照"),
    /**
     *  账号是否合法
     */
    ACCOUNT("32","^[a-zA-Z]\\w{4,15}$","账号是否合法"),
    /**
     *  中文/汉字
     */
    CHINESE_CHARACTER("33","^[\\u4E00-\\u9FA5]+$","中文/汉字"),
    /**
     *  小数
     */
    DECIMAL("34","^\\d+\\.\\d+$","小数"),
    /**
     *  小数
     */
    DIGIT("35","^\\d{1,}$","数字"),
    /**
     *  html标签(宽松匹配)
     */
    HTML("36","<(\\w+)[^>]*>(.*?<\\/\\1>)?","html标签(宽松匹配)"),
    /**
     *  qq号
     */
    QQ("37","^[1-9][0-9]{4,10}$","qq号"),
    /**
     *  数字和字母
     */
    NUM_LETTER("38","^[A-Za-z0-9]+$","数字和字母"),
    /**
     *  英文字母
     */
    ENGLISH_LETTER("39","^[a-zA-Z]+$","英文字母"),
    /**
     *  小写英文字母
     */
    SMALL_ENGLISH_LETTER("40","^[a-z]+$","小写英文字母"),
    /**
     *  大写英文字母
     */
    BIG_ENGLISH_LETTER("41","^[A-Z]+$","大写英文字母"),
    /**
     *  密码强度校验，最少6位，包括至少一个大写字母，一个小写字母，一个数字，一个特殊字符
     */
    PASSWORD("42","^\\S*(?=\\S{6,})(?=\\S*\\d)(?=\\S*[A-Z])(?=\\S*[a-z])(?=\\S*[!@#$%^&*? ])\\S*$","密码强度校验"),
    /**
     *  用户名校验(4-16位，字母，数字，下划线，减号)
     */
    USER_NAME("43","^[a-zA-Z0-9_-]{4,16}$","用户名校验"),
    /**
     *  IP-V4
     */
    IP_V4("44","^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$","IP-V4"),
    /**
     *  IP-V6
     */
    IP_V6("45","^((([0-9A-Fa-f]{1,4}:){7}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){6}:[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){5}:([0-9A-Fa-f]{1,4}:)?[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){4}:([0-9A-Fa-f]{1,4}:){0,2}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){3}:([0-9A-Fa-f]{1,4}:){0,3}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){2}:([0-9A-Fa-f]{1,4}:){0,4}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){6}((\\\\b((25[0-5])|(1\\\\d{2})|(2[0-4]\\\\d)|(\\\\d{1,2}))\\\\b).){3}(\\\\b((25[0-5])|(1\\\\d{2})|(2[0-4]\\\\d)|(\\\\d{1,2}))\\\\b))|(([0-9A-Fa-f]{1,4}:){0,5}:((\\\\b((25[0-5])|(1\\\\d{2})|(2[0-4]\\\\d)|(\\\\d{1,2}))\\\\b).){3}(\\\\b((25[0-5])|(1\\\\d{2})|(2[0-4]\\\\d)|(\\\\d{1,2}))\\\\b))|(::([0-9A-Fa-f]{1,4}:){0,5}((\\\\b((25[0-5])|(1\\\\d{2})|(2[0-4]\\\\d)|(\\\\d{1,2}))\\\\b).){3}(\\\\b((25[0-5])|(1\\\\d{2})|(2[0-4]\\\\d)|(\\\\d{1,2}))\\\\b))|([0-9A-Fa-f]{1,4}::([0-9A-Fa-f]{1,4}:){0,5}[0-9A-Fa-f]{1,4})|(::([0-9A-Fa-f]{1,4}:){0,6}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){1,7}:))$","IP-V6"),
    /**
     *  微信号
     */
    WECHAT("46","^[a-zA-Z][-_a-zA-Z0-9]{5,19}$","微信号"),
    /**
     *  邮政编码
     */
    POSTAL_CODE("47","^(0[1-7]|1[0-356]|2[0-7]|3[0-6]|4[0-7]|5[1-7]|6[1-7]|7[0-5]|8[013-6])\\d{4}$","邮政编码"),
    /**
     *  中文和数字
     */
    CHINESE_NUM("48","^((?:[\\u3400-\\u4DB5\\u4E00-\\u9FEA\\uFA0E\\uFA0F\\uFA11\\uFA13\\uFA14\\uFA1F\\uFA21\\uFA23\\uFA24\\uFA27-\\uFA29]|[\\uD840-\\uD868\\uD86A-\\uD86C\\uD86F-\\uD872\\uD874-\\uD879][\\uDC00-\\uDFFF]|\\uD869[\\uDC00-\\uDED6\\uDF00-\\uDFFF]|\\uD86D[\\uDC00-\\uDF34\\uDF40-\\uDFFF]|\\uD86E[\\uDC00-\\uDC1D\\uDC20-\\uDFFF]|\\uD873[\\uDC00-\\uDEA1\\uDEB0-\\uDFFF]|\\uD87A[\\uDC00-\\uDFE0])|(\\d))+$","中文和数字"),
    /**
     *  不能包含字母
     */
    NOT_LETTER("49","^[^A-Za-z]*$","不能包含字母"),
    /**
     *  java包名
     */
    JAVA_PACKAGE("50","^([a-zA-Z_][a-zA-Z0-9_]*)+([.][a-zA-Z_][a-zA-Z0-9_]*)+$","java包名");



    private final String code;
    private final String regex;
    private final String name;

    EnumType(String code, String regex, String name) {
        this.code = code;
        this.regex = regex;
        this.name = name;
    }
    /**
     * 根据编码获取对应的枚举名
     *
     * @param code 校验枚举码
     * @return String
     */
    public static String getNameByCode(String code){
        EnumType e = getEnumByCode(code);
        String name = e == null ? StringUtils.EMPTY : e.getName();
        return name;
    }
    /**
     * 根据给定的代码获取对应的枚举类型。
     *
     * @param code 要查找的枚举代码
     * @return 匹配的枚举类型，如果未找到则返回null
     */
    public static EnumType getEnumByCode(String code){
        for (EnumType e : EnumType.values()) {
            if(e.getCode().equals(code)){
                return e;
            }
        }
        return null;
    }
     /**
     * 根据编码和要校验的内容，获取校验结果
     *
     * @param code 用于查找枚举的代码
     * @param str 需要匹配的字符串
     * @return 如果字符串匹配正则表达式，则返回true；否则返回false
     */
    public static Boolean getResultByCode(String code,String str){
        if(StringUtils.isNotEmpty(code) && StringUtils.isNotEmpty(str)){
            EnumType e = getEnumByCode(code);
            Pattern pattern = Pattern.compile(e.regex);
            return pattern.matcher(str).matches();
        }else{
            return false;
        }
    }
    /**
     * 根据编码获取正则表达式
     *
     * @param code 用于查找枚举的代码
     * @return 返回对应的正则表达式
     */
    public static String getRegexByCode(String code){
        if(StringUtils.isNotEmpty(code)){
            EnumType e = getEnumByCode(code);
            return e.regex;
        }else{
            return "";
        }
    }
}
