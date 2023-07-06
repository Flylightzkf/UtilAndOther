package com.wu.mail_send_demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author benjamin_5
 * @Description
 * @date 2022/10/5
 */
@Data
public class CustomerData implements Serializable {

    @ExcelProperty(value = "客户名称")
    @ColumnWidth(value = 25)
    private String name;

    @ExcelProperty(value = "客户地址")
    @ColumnWidth(value = 50)
    private String address;

    @ExcelProperty(value = "联系电话")
    @ColumnWidth(value = 20)
    private String phone;

    @ExcelProperty(value = "金额")
    private BigDecimal amount;

    @ExcelProperty(value = "注册日期")
    @DateTimeFormat(value = "yyyy-MM-dd")
    @ColumnWidth(value = 20)
    private Date createDate;
}
