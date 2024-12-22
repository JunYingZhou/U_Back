package top.continew.admin.news.controller;


import com.alibaba.excel.EasyExcel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.continew.admin.news.model.UserExcelDO;
import top.continew.admin.news.service.EasyExcelService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/anti/easyexcel")
public class EasyExcelController {

    private final EasyExcelService excelService;

    private static final String FILE_PATH = "D:\\bishe\\backend\\U_Back\\user.xlsx";

    @GetMapping("/getUsersExcel")
    public void download() {
        EasyExcel.write(FILE_PATH, UserExcelDO.class)
                .sheet("用户信息")
                .doWrite(excelService.getUserData());
    }

}
