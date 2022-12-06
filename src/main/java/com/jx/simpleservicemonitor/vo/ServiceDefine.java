package com.jx.simpleservicemonitor.vo;

import lombok.Data;

/**
 * @author jianxinliu
 * @date 2022/11/09 22:59
 */
@Data
public class ServiceDefine {
    private String url;
    private String name;
    private String alivePath;
    private Integer retries;
    /**
     * in ms
     */
    private Integer timeout;
}
