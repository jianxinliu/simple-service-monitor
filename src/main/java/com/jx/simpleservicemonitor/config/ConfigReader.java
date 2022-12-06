package com.jx.simpleservicemonitor.config;

import com.google.gson.Gson;
import com.jx.simpleservicemonitor.vo.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Optional;

/**
 * read config file as object
 * @author jianxinliu
 * @date 2022/11/09 23:05
 */
@Slf4j
public class ConfigReader {

    public static Optional<AppConfig> readConfigJson(String cfgPath) throws FileNotFoundException {
        boolean exists = Files.exists(Paths.get(cfgPath));
        if (!exists) {
            throw new FileNotFoundException("指定的配置文件不存在！");
        }
        InputStream resourceAsStream = ConfigReader.class.getResourceAsStream(cfgPath);
        Gson gson = new Gson();
        AppConfig appConfig;
        try {
            appConfig = gson.fromJson(new InputStreamReader(resourceAsStream), AppConfig.class);
        } catch (Exception e) {
            log.error("read config file failed!");
            throw e;
        }
        return Optional.ofNullable(appConfig);
    }

//    public static AppConfig readConfigYaml(String cfgPath) throws FileNotFoundException {
//        Yaml yaml = new Yaml();
//        FileInputStream fileInputStream = new FileInputStream(cfgPath);
//        HashMap<String, Object> yamlMap = yaml.load(fileInputStream);
//
//    }
}
