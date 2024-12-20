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

// import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
@CrossOrigin(origins = "*")
public class ChatController {

    //    private final ChatClient client;

    //    @Autowired
    //    public ChatController(ChatClient.Builder builder) {
    //        this.client = builder.build();
    //    }
    //
    //
    //    @GetMapping(value = "/steamChat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    //    public Flux<String> steamChat(@RequestParam(value = "input", defaultValue = "将一个笑话") String input) {
    //        return client.prompt()
    //                .user(input)
    //                .stream()
    //                .content()
    //                .doOnNext(data -> System.out.println("Data emitted: " + data))
    //                .doOnError(error -> System.err.println("Error occurred: " + error));
    //    }

    //    @GetMapping("/getMsg")
    //    public String getMessage(@RequestParam(value = "msg", defaultValue = "讲一个笑话") String msg) {
    //        return client.prompt()
    //                .user(msg)
    //                .collectList() // 收集所有流数据为列表
    //                .map(list -> String.join("", list)) // 将所有字符串拼接
    //                .block(); // 阻塞等待结果
    //    }

    //    @GetMapping("/getMsg")
    //    public String getMessage(@RequestParam(value = "msg", defaultValue = "讲一个笑话") String msg) {
    //        return client.prompt().user(msg).getContent();  // 假设返回的是字符串
    //    }

}
