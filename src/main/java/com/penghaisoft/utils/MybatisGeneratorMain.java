package com.penghaisoft.utils;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zhengwenxin
 * @Date 2021/3/3 15:33
 * @Version 1.0
 * @Description
 * Mybatis逆向生成工具
 */
public class MybatisGeneratorMain {

    /**
     * ！！！！！！！ 该Main方法 重复执行会覆盖代码文件，执行前请检查 ！！！！！！！！！！！！！
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        //此处写mybatisGenerator配置文件的路径
        Configuration config = cp.parseConfiguration(new File
                ("F:\\dev\\IDEAWorkSpace\\generator\\src\\main\\resources\\mybatis\\mybatisGeneratorConfig.xml"));
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
