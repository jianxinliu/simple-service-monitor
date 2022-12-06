package com.jx.simpleservicemonitor.vo;

import lombok.Data;

import java.util.List;

/**
 * @author jianxinliu
 * @date 2022/11/09 23:06
 */
@Data
public class AppConfig {
    private List<ServiceDefine> serviceDefines;
}
