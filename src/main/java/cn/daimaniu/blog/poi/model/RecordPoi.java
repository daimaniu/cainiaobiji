package cn.daimaniu.blog.poi.model;

/**
 * Author :keepcleargas
 * Date   :2016-09-07 10:19.
 */
public class RecordPoi {
    private int recordId;
    private String cname;
    private String cbank;
    private String cnum;
    private int money;
    private int type = 1;
    private String comment = "现金提现";

    public String getCbank() {
        return cbank;
    }

    public void setCbank(String cbank) {
        this.cbank = cbank;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCnum() {
        return cnum;
    }

    public void setCnum(String cnum) {
        this.cnum = cnum;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RecordPoi{" +
                "cbank='" + cbank + '\'' +
                ", recordId=" + recordId +
                ", cname='" + cname + '\'' +
                ", cnum='" + cnum + '\'' +
                ", money=" + money +
                ", type=" + type +
                ", comment='" + comment + '\'' +
                '}';
    }
}
