package cn.daimaniu.blog.poi.impl;

import cn.daimaniu.blog.poi.IExcelExport;
import cn.daimaniu.blog.poi.model.RecordPoi;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author :keepcleargas
 * Date   :2016-09-07 10:36.
 */
public class RecordExport implements IExcelExport<RecordPoi> {
    List<RecordPoi> poiList = new ArrayList<>();
    private String title;
    String[] headers = {"序号", "收款人姓名", "银行名称", "银行卡号", "付款金额", "到账方式", "备注"};

    public String[] getHeader() {
        return headers;
    }

    public int getHeaderSize() {
        return headers.length;
    }

    public String getTitle() {
        if (StringUtils.isEmpty(title)) {
            return formatDate(new Date(), "yyyy-MM-dd_HH-mm-ss") + "-提现记录.xls";
        } else {
            return title;
        }
    }

    private String formatDate(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public boolean containSpecialField(String filedName) {
        return false;
    }

    public String getSpecialFieldValue(String filedName) {
        return null;
    }

    public List<RecordPoi> getPoiList() {
        return this.poiList;
    }

    public void setPoiList(List<RecordPoi> data) {
        this.poiList = data;
    }
}
