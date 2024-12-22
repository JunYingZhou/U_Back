package top.continew.admin.news.service.impl;

import org.springframework.stereotype.Service;
import top.continew.admin.news.model.UserExcelDO;
import top.continew.admin.news.service.EasyExcelService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class EasyExcelServiceImpl implements EasyExcelService {
    @Override
    public List<UserExcelDO> getUserData() {
        ArrayList<UserExcelDO> userExcelDOS = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            UserExcelDO ud = UserExcelDO.builder()
                    .userId(i)
                    .userName("张三" + i)
                    .gender(i % 2 == 0 ? "男" : "女")
                    .salary(i * 1000.00)
                    .hireDate(new Date())
                    .build();
            userExcelDOS.add(ud);
        }
        return userExcelDOS;
    }
}
