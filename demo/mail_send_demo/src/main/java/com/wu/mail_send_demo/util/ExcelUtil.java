package com.wu.mail_send_demo.util;

import com.alibaba.excel.EasyExcel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author benjamin_5
 * @Description
 * @date 2022/10/5
 */
public class ExcelUtil {

    /**
     * 生成excel文件
     * @param fileName excel文件路径
     * @param dataList 数据列表
     * @param clazz 导出对象类
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> File generateExcel(String fileName, List<T> dataList, Class<T> clazz) throws IOException {
        // 生成文件
        File excel = new File(fileName);
        // excel写入
        EasyExcel.write(excel,clazz).sheet(0).doWrite(dataList);
        return excel;
    }

    public static <T> ByteArrayOutputStream generateExcel(List<T> dataList, Class<T> clazz) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // excel写入
        EasyExcel.write(out,clazz).sheet(0).doWrite(dataList);
        return out;
    }
}
