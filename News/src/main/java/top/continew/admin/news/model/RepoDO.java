package top.continew.admin.news.model;


import lombok.Data;

import java.util.Date;

@Data
public class RepoDO {

    private Long repoId;
    private Long categoryId;
    private String repoContentOne;
    private String repoContentTwo;
    private String repoContentThree;
    private String repoContentFour;
    private String repoContentFive;
    private String repoContentSix;
    private String repoContentSeven;
    private String repoContentEight;
    private String repoContentNine;
    private String repoContentTen;
    private Date createTime;
    private Date modifyTime;


}
