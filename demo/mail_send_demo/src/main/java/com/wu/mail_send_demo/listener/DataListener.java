package com.wu.mail_send_demo.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.util.ConverterUtils;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author benjamin_5
 * @Description 数据监听类
 * @date 2022/10/5
 */
@EqualsAndHashCode(callSuper = true)
public class DataListener<T> extends AnalysisEventListener<T> {

    /**
     * 缓存数据列表
     */
    private final List<T> dataList = new ArrayList<>();

    @Override
    public void invoke(T data, AnalysisContext context) {
        dataList.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
        this.invokeHeadMap(ConverterUtils.convertToStringMap(headMap,context),context);
    }

    public List<T> getDataList() {
        return dataList;
    }

}
