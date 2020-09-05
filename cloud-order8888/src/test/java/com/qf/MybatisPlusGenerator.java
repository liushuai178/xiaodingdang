package com.qf;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class MybatisPlusGenerator {
    public static void main(String[] args) {

        AutoGenerator mpg = new AutoGenerator();
        // 选择 freemarker 引擎，默认 Veloctiy
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("lcs");
        gc.setOutputDir("H:\\GitWork\\xiaodingdang\\cloud-order8888\\src\\main\\java");
        gc.setFileOverride(true);// 是否覆盖同名文件，默认是false
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        //gc.setSwagger2(true); 实体属性 Swagger2 注解
        /* 自定义文件命名，注意 %s 会自动填充表实体属性！ */
        gc.setServiceName("%sService");//去掉Service的前缀I
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();

        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:mysql://39.99.155.151:3306/xiaodingdang?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //手动指定映射表名
        strategy.setInclude("order");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        mpg.setStrategy(strategy);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("xdd");
        pc.setParent("com");
        //手动设置包名
        pc.setEntity("pojo");
        pc.setMapper("dao");
        pc.setXml("mapper");
        mpg.setPackageInfo(pc);
        // 执行生成
        mpg.execute();
    }

}
