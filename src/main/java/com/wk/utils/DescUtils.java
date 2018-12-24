package com.wk.utils;

import org.thymeleaf.util.StringUtils;

public enum DescUtils {
    PRDUCT("1", "相机"),

    COMPUTER("2", "电脑");

    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    DescUtils(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getVal(String key) {
        if (StringUtils.isEmpty(key)) {
            return "其他";
        }
        for (int i = 0; i < DescUtils.values().length; i++) {
            if (key.equals(DescUtils.values()[i].key)) {
                return DescUtils.values()[i].value;
            }
        }
        return "其他";
    }

    public static void main(String[] args) {
        String str=DescUtils.getVal("1");
       System.out.print(str);
    }
}
