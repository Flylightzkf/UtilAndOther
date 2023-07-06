package com.example.designmodel.model.m05_factory_method.factory02;

import com.example.designmodel.model.m03_decorator.decorator02.ISale;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/19
 */
public interface IFactory {
    /**
     * 创建销售模式
     * @return
     */
    public ISale createSalesModel();

}
