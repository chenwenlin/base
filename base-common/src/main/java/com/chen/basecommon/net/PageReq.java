package com.chen.basecommon.net;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 分页基础请求实体
 *
 * @author chenwenlin
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PageReq implements Serializable {

    private static final long serialVersionUID = 4571622880005999036L;
    /**
     * 当前查询的页码
     */
    @Builder.Default
    private int pageNum = 1;

    /**
     * 当前查询单页的数据量
     */
    @Builder.Default
    private int pageSize = 20;

    public int getPageNum() {
        return Math.max(pageNum, 1);
    }

    public int getPageSize() {
        return Math.min(pageSize, 1000);
    }
}