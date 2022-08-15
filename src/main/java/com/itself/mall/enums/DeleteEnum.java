package com.itself.mall.enums;

import java.util.Objects;

/**
 * @Author xxw
 * @Date 2022/08/09
 *
 * 逻辑删除枚举类
 */
public enum DeleteEnum {

    UN_DELETE(0,"未删除"),

    DELETE(1,"已删除");

    private Integer code;

    private String message;

    DeleteEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * 根据code获取枚举类型
     */
    public DeleteEnum findByCode(Integer code) {
        for (DeleteEnum deleteEnum : DeleteEnum.values()) {
            if (Objects.equals(deleteEnum.getCode(),code)){
                return deleteEnum;
            }
        }
        return null;
    }
}
