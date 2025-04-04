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

package top.continew.admin.system.service;

import top.continew.admin.system.model.entity.DictDO;
import top.continew.admin.system.model.query.DictQuery;
import top.continew.admin.system.model.req.DictReq;
import top.continew.admin.system.model.resp.DictResp;
import top.continew.starter.data.mp.service.IService;
import top.continew.starter.extension.crud.model.resp.LabelValueResp;
import top.continew.starter.extension.crud.service.BaseService;

import java.util.List;

/**
 * 字典业务接口
 *
 * @author Charles7c
 * @since 2023/9/11 21:29
 */
public interface DictService extends BaseService<DictResp, DictResp, DictQuery, DictReq>, IService<DictDO> {

    /**
     * 查询枚举字典
     *
     * @return 枚举字典列表
     */
    List<LabelValueResp> listEnumDict();
}