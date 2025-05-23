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

package top.continew.admin.news.service;

import top.continew.admin.news.model.ChatDO;
import top.continew.admin.news.model.NewsDO;
import top.continew.admin.news.model.RepoDO;
import top.continew.admin.news.model.VO.ChatVO;

import java.util.List;

public interface ChatService {
    /**
     * 根据用户id查数据
     * 
     * @param categoryId, userId
     * @return
     */
    List<ChatDO> getChatById(Long categoryId, Long userId);


    Long addChatInfo(ChatVO chatDO);

    RepoDO getRepoByCategoryId(Long categoryId);

}
