package jh.zkj.com.yf.Bean;

/**
 * Created by wdefer
 * 2018/11/16
 * use
 */
public class CommodityTreeBean {
    /**
     * 节点Id
     */
    private int id;
    /**
     * 节点父id
     */
    private int pId;
    /**
     * 节点name
     */
    private String name;
    /**
     *
     */
    private String desc;
    /**
     * 节点名字长度
     */
    private long length;
    /**
     * 库存数量
     */
    private Object obj;


    public CommodityTreeBean(int id, int pId, String name, long qty) {
        super();
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.obj = qty;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPid() {
        return pId;
    }
    public void setPid(int pId) {
        this.pId = pId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public long getLength() {
        return length;
    }
    public void setLength(long length) {
        this.length = length;
    }

    public Object getQty() {
        return obj;
    }

    public void setQty(Object qty) {
        this.obj = qty;
    }
}
