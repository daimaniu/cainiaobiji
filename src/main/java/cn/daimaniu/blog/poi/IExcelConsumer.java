package cn.daimaniu.blog.poi;

import org.apache.poi.ss.usermodel.Sheet;

/**
 * Author :keepcleargas
 * Date   :2016-09-07 10:23.
 */
public interface IExcelConsumer {
    /**
     * 读取excel
     *
     * @param sheet
     */
    void consume(Sheet sheet);
}
