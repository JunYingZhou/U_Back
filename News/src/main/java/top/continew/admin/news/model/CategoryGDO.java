package top.continew.admin.news.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Data
@Setter
public class CategoryGDO {
    private Integer categoryId;
    private String categoryName;
    private Date createTime;
    private Date modifyTime;
}
