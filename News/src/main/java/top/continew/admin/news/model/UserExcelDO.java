package top.continew.admin.news.model;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserExcelDO {
    @ExcelProperty(value = "用户编号")
    private Integer userId;
    @ExcelProperty(value = "姓名")
    private String userName;
    @ExcelProperty(value = "性别")
    private String gender;
    @ExcelProperty(value = "工资")
    private Double salary;
    @ExcelProperty(value = "入职时间")
    private Date hireDate;

}
