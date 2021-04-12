package cn.lemon.common.lang;

import lombok.Data;

@Data
public class Result {
    private int code;//状态码
    private String msg;//消息
    private Object data;//内容

    public static Result succ(int code,String msg,Object data){
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static Result succ(Object data){
        return succ(200,"操作成功",data);
    }

    public static Result fail(int code,String msg,Object data){
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static Result fail(String msg,Object data){
        return fail(400,msg,data);
    }

    public static Result fail(String msg){
        return fail(400,msg,null);
    }
}
