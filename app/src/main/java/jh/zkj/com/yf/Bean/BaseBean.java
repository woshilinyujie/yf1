package jh.zkj.com.yf.Bean;

/**
 * Created by wdefer
 * 2018/10/23
 * use
 */
public class BaseBean<T> {

    private T data;
    private String msg;
    private int code;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
