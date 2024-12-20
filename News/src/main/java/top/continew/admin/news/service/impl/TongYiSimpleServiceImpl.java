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

package top.continew.admin.news.service.impl;

import com.alibaba.cloud.ai.tongyi.audio.api.SpeechClient;
import com.alibaba.dashscope.audio.tts.SpeechSynthesisAudioFormat;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.StreamingChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.image.ImageClient;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import top.continew.admin.news.service.TongYiService;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Map;

@Service
public class TongYiSimpleServiceImpl implements TongYiService {
    /**
     * 自动注入ChatClient、imageClient、StreamingChatClient，屏蔽模型调用细节
     */
    private final ChatClient chatClient;

    private final ImageClient imageClient;

    private final StreamingChatClient streamingChatClient;

    // stream 流式客户端
    private final SpeechClient speechClient;

    @Autowired
    public TongYiSimpleServiceImpl(ChatClient chatClient,
                                   StreamingChatClient streamingChatClient,
                                   ImageClient imageClient,
                                   SpeechClient speechClient) {
        this.chatClient = chatClient;
        this.imageClient = imageClient;
        this.streamingChatClient = streamingChatClient;
        this.speechClient = speechClient;
    }

    /**
     * 具体实现：
     */
    @Override
    public String completion(String message) {
        Prompt prompt = new Prompt(new UserMessage(message));
        return chatClient.call(prompt).getResult().getOutput().getContent();
    }

    @Override
    public ResponseEntity<byte[]> genImg(String imgPrompt) {
        ImagePrompt imagePrompt = new ImagePrompt(imgPrompt);
        ImageResponse response = imageClient.call(imagePrompt);
        //处理生成的图片base64码
        String b64Json = response.getResult().getOutput().getB64Json();
        //将b64转换成图片返回给前端
        byte[] decode = Base64.getDecoder().decode(b64Json);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(decode, httpHeaders, HttpStatus.OK);
    }

    @Override
    public Map<String, String> streamCompletion(String message) {

        StringBuilder fullContent = new StringBuilder();

        streamingChatClient.stream(new Prompt(message))
            .flatMap(chatResponse -> Flux.fromIterable(chatResponse.getResults()))
            .map(content -> content.getOutput().getContent())
            .doOnNext(fullContent::append)
            .last()
            .map(lastContent -> Map.of(message, fullContent.toString()))
            .block();
        return Map.of(message, fullContent.toString());
    }

    @Override
    public String genAudio(String text) {
        var resWAV = speechClient.call(text);
        return save(resWAV, SpeechSynthesisAudioFormat.WAV.getValue());
    }

    /**
     * 将语音保存到本地的方法
     *
     * @param audio
     * @param type
     * @return
     */
    private String save(ByteBuffer audio, String type) {
        String currentPath = System.getProperty("user.dir");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-HH-mm-ss");
        String fileName = currentPath + File.separator + now.format(formatter) + "." + type;
        File file = new File(fileName);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(audio.array());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return fileName;
    }

}
