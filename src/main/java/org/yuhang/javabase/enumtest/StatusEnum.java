package org.yuhang.javabase.enumtest;

public enum StatusEnum {
     NORMAL("0001","正常","正常的状态"),
     ACTIVE("0002","激活","激活的状态"),
     EXCPTION("0003","异常","异常的状态");


     private String code;
     private String msg;
     private String descrption;

    StatusEnum(String code, String msg, String descrption) {
        this.code = code;
        this.msg = msg;
        this.descrption = descrption;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }
}
