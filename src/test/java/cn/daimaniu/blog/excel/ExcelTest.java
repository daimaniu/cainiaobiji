package cn.daimaniu.blog.excel;

import cn.daimaniu.blog.poi.ExcelUtil;
import cn.daimaniu.blog.poi.IExcelExport;
import cn.daimaniu.blog.poi.impl.RecordExport;
import cn.daimaniu.blog.poi.impl.consumer.RecordComsumer;
import cn.daimaniu.blog.poi.model.RecordPoi;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author :keepcleargas
 * Date   :2016-09-07 10:42.
 */
public class ExcelTest {
    @Test
    public void TestExcel() {
        IExcelExport excelExport = new RecordExport();

        List<RecordPoi> recordPoiList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            RecordPoi recordPoi = new RecordPoi();
            recordPoi.setRecordId(i);
            recordPoi.setCname("提现人" + i);
            recordPoi.setCbank("CBB");
            recordPoi.setCnum("33425678902");
            recordPoi.setMoney(1500);

            recordPoiList.add(recordPoi);
        }
        excelExport.setPoiList(recordPoiList);
        System.out.println("导出大小为size:" + excelExport.getPoiList().size() + "的Excel");
        String fileName = System.getProperty("java.io.tmpdir") + File.separator + excelExport.getTitle();
        File file = new File(fileName);
        System.out.println("将Excel写入到路径:" + file.getAbsolutePath());
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            ExcelUtil.export(excelExport, out);

            ExcelUtil.excelImport(file, fileName, new RecordComsumer());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
