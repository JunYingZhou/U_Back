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

import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
