package com.xhui.sum;

public class Constant {

    public static final int SUCCESS = 0;

    public static class Error {
        public static final int ERROR_NULL_PARAM = -1;
        public static final int ERROR_EXIT_USER = -2;
        public static final int ERROR_DB = -3;
    }

    public static class Msg {
        public static final String ERROR_NULL_PARAM = "传入空的参数！";

        public static final String ERROR_EXIT_USER = "该账号已被已注册！";
        public static final String ERROR_REGISTER = "注册失败！";
        public static final String SUCCESS_REGISTER = "注册成功！";

        public static final String ERROR_UPLOAD = "上传失败！";
        public static final String SUCCESS_UPLOAD = "上传成功！";

        public static final String ERROR_UPDATE = "修改失败！";
        public static final String SUCCESS_UPDATE = "修改成功！";
    }
}
