package com.chen.basecommon.enumeration;

/**
 * 默认的布尔枚举类
 *
 * @author itfinally
 */
public enum Bool {
    // 布尔枚举
    YES {
        @Override
        public boolean asBoolean() {
            return true;
        }

        @Override
        public int getCode() {
            return 1;
        }
    },

    NO {
        @Override
        public boolean asBoolean() {
            return false;
        }

        @Override
        public int getCode() {
            return 0;
        }
    };

    /**
     * 转换布尔
     *
     * @return boolean
     */
    public abstract boolean asBoolean();

    /**
     * 代码
     *
     * @return int
     */
    public abstract int getCode();

    public static Bool of(boolean val) {
        return val ? YES : NO;
    }

    public static Bool of(int code) {
        return code == 1 ? YES : NO;
    }


}
