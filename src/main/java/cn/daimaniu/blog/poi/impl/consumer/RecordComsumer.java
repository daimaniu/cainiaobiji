package cn.daimaniu.blog.poi.impl.consumer;

import cn.daimaniu.blog.poi.IExcelConsumer;
import cn.daimaniu.blog.poi.model.RecordPoi;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.List;

/**
 * Author :keepcleargas
 * Date   :2016-09-07 10:48.
 */
public class RecordComsumer implements IExcelConsumer {
    @Override
    public void consume(Sheet sheet) {
        List<RecordPoi> recordPois = new ArrayList<>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            if (i % 500 == 0) {
                //在这里 处理 提取出来的数据
//                recordPoiMapper.batchInsert(recordPois);
                System.out.println("Excel解析出 size:" + recordPois.size() + "recordPois:" + recordPois.toString());
                recordPois = null;
                recordPois = new ArrayList<>();
            }
            Row row = sheet.getRow(i);
            RecordPoi recordPoi = new RecordPoi();

            recordPoi.setRecordId(Integer.parseInt(row.getCell(0).getStringCellValue()));
            recordPoi.setCname(row.getCell(1).getStringCellValue());
            recordPoi.setCbank(row.getCell(2).getStringCellValue());
            recordPoi.setCnum(row.getCell(3).getStringCellValue());
            recordPoi.setMoney(Integer.parseInt(row.getCell(4).getStringCellValue()));
            recordPoi.setType(Integer.parseInt(row.getCell(5).getStringCellValue()));
            recordPoi.setComment(row.getCell(6).getStringCellValue());

            recordPois.add(recordPoi);
        }
        if (recordPois != null && recordPois.size() > 0) {
            //在这里 处理 500除余,提取出来的数据
//            recordPoiMapper.batchInsert(recordPois);
            System.out.println("Excel解析出 size:" + recordPois.size() + "recordPois:" + recordPois.toString());
            recordPois = null;
        }
    }
}
