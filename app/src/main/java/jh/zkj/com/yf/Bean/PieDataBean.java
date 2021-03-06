package jh.zkj.com.yf.Bean;

import java.util.List;

/**
 * Created by linyujie on 18/11/7.
 */

public class PieDataBean {

    /**
     * data : [{"target_data":11093.600036621094,"name":"浙江公司test","uuid":"1426d062-1b36-4faf-a414-a04f1c8f2c22"}]
     * msg : success
     * code : 0
     */

    private String msg;
    private int code;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * target_data : 11093.600036621094
         * name : 浙江公司test
         * uuid : 1426d062-1b36-4faf-a414-a04f1c8f2c22
         */

        private double target_data;
        private String name;
        private String uuid;

        public double getTarget_data() {
            return target_data;
        }

        public void setTarget_data(double target_data) {
            this.target_data = target_data;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }
    }
}
