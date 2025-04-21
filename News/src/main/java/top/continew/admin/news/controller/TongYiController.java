/*
 * Copyright (c) 2022-present Charles7c Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.continew.admin.news.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.continew.admin.news.model.Req.AntiMessageReq;
import top.continew.admin.news.service.TongYiService;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/ai")
public class TongYiController {

    @Resource
    private TongYiService tongYiService;

    /**
     * 聊天对话体验
     * 
     * @param msg
     * @return
     */
    @GetMapping("/getMsg")
    public String getMessage(@RequestParam(value = "msg", defaultValue = "讲一个笑话") String msg) {


        return tongYiService.completion(msg);
    }

    /**
     * 聊天对话体验
     * @param antiMessageReq
     * @return
     */
    @SaIgnore
    @PostMapping("/getAntiMsg")
    public String getAntiMessage(@RequestBody AntiMessageReq antiMessageReq) {
        System.out.println("题目种类" + antiMessageReq.getQuestionCategory());
        System.out.println("题目内容:" +antiMessageReq.getQuestionContent());
        String example = "### 用户能力分析\\n\\n从提供的题目和答案来看，这些问题是典型的网络钓鱼测试题。用户的回答可以直接反映出其在网络环境中的安全意识、判断能力和防骗技巧。\\n\\n1. **立即开始**：这是直接的指令行为。\\n2. **马上给**：多次出现，说明用户可能缺乏基本的安全防范意识，在面对陌生人的请求或诱惑时容易上当受骗。\\n3. **接受**：表示用户可能会轻信来源不明的信息，没有辨别真伪的习惯。\\n4. **加入**：显示用户可能容易被利益诱惑而忽视潜在的风险。\\n5. **下载**：表明用户可能不够谨慎，随意安装未知来源的应用程序。\\n6. **配合**：暗示用户在遇到权威身份（如“警察”）的要求时，缺乏质疑精神。\\n7. **马上给**：再次强调用户在紧急情况下缺乏冷静思考的能力。\\n8. **加入**：与之前的选项类似，用户容易受到虚假宣传的影响。\\n9. **点击**：尽管有“国家反诈中心”的警告，用户仍选择忽略提醒，这暴露了其对于网络安全知识的欠缺。\\n\\n总体而言：\\n- 用户普遍表现出较高的易受骗倾向；\\n- 缺乏必要的网络安全常识；\\n- 对于潜在危险信号识别不足；\\n- 容易因小额付出或短期收益而放松警惕。\\n\\n### ECharts 数据 JSON 格式输出\\n\\n```json\\n{\\n    \\\"series\\\": [\\n        {\\n            \\\"name\\\": \\\"答题结果分布\\\",\\n            \\\"type\\\": \\\"pie\\\",\\n            \\\"radius\\\": [\\\"50%\\\", \\\"70%\\\"],\\n            \\\"data\\\": [\\n                { \\\"value\\\": 3, \\\"name\\\": \\\"立即开始\\\" },\\n                { \\\"value\\\": 5, \\\"name\\\": \\\"马上给\\\" },\\n                { \\\"value\\\": 1, \\\"name\\\": \\\"接受\\\" },\\n                { \\\"value\\\": 1, \\\"name\\\": \\\"加入\\\" },\\n                { \\\"value\\\": 1, \\\"name\\\": \\\"下载\\\" },\\n                { \\\"value\\\": 1, \\\"name\\\": \\\"配合\\\" },\\n                { \\\"value\\\": 1, \\\"name\\\": \\\"点击\\\" }\\n            ]\\n        }\\n    ],\\n    \\\"title\\\": {\\n        \\\"text\\\": \\\"用户能力分析 - 题目种类: 网络钓鱼\\\"\\n    },\\n    \\\"tooltip\\\": {\\n        \\\"trigger\\\": \\\"item\\\",\\n        \\\"formatter\\\": \\\"{a} <br/>{b}: {c} ({d}%)\\\"\\n    }\\n}\\n```\\n\\n此JSON数据可用于生成ECharts饼图，直观地展示不同答案的比例情况。";
//        String msg = "题目的种类是" + antiMessageReq.getQuestionCategory() + ", 请根据题目内容对用户的能力进行分析，并给出数据用做echart图表展示(Echart的数据放在最后，并且是JSON格式，不用markdown的形式)，内容是:" + antiMessageReq.getQuestionContent() + "这是模板" + example;
        String msg = "题目的种类是" + antiMessageReq.getQuestionCategory() + ", 请根据题目内容对用户的能力进行分析，并给出数据用做echart图表展示用户的优缺点(Echart的数据放在最后，并且是JSON格式), 并以Markdown的形式，内容是:" + antiMessageReq.getQuestionContent() ;

        String completion = tongYiService.completion(msg);
        System.out.println("completion = " + completion);
        return completion;
    }

    /**
     * 体验生成图片
     * 
     * @param msg
     * @return
     */
    @GetMapping("/getImage")
    public ResponseEntity<byte[]> getImage(@RequestParam(value = "msg", defaultValue = "动漫女主图片") String msg) {
        ResponseEntity<byte[]> responseEntity = tongYiService.genImg(msg);
        return responseEntity;
    }


    /**
     * 流式客户端形式
     * 
     * @param message
     * @return
     */
    @GetMapping("/stream")
    public Map<String, String> streamCompletion(@RequestParam(value = "message", defaultValue = "请告诉我西红柿炖牛腩怎么做？") String message) {
        return tongYiService.streamCompletion(message);
    }

    /**
     * 生成语音
     * 
     * @param prompt
     * @return
     */
    @GetMapping("/audio")
    public String genAudio(@RequestParam(value = "prompt", defaultValue = "你好，Spring Cloud Alibaba AI 框架！") String prompt) {

        return tongYiService.genAudio(prompt);
    }

}
