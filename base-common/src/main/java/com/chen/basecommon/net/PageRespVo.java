package com.chen.basecommon.net;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 分页基础响应实体
 *
 * @author chenwenlin
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PageRespVo<T> implements Serializable {

    /**
     * 当前页码, 主要给 web 端做分页校验
     */
    @Builder.Default
    private int page = 0;

    /**
     * 总数据量
     */
    @Builder.Default
    private long total = 0L;

    /**
     * 分页数据
     */
    @Builder.Default
    private Collection<T> list = new ArrayList<>();
}