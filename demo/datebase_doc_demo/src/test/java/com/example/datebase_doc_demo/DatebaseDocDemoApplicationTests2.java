package com.example.datebase_doc_demo;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class DatebaseDocDemoApplicationTests2 {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void generateDBDoc2(){
        //DataSource dataSource = applicationContext.getBean(DataSource.class);

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://170.18.10.97:3306/IDSPLUS_RWANG?characterEncoding=UTF-8");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("12344");
        // 设置可以获取remark信息
        hikariConfig.addDataSourceProperty("useInformationSchema","true");
        hikariConfig.setMinimumIdle(2);
        hikariConfig.setMaximumPoolSize(5);
        DataSource dataSource = new HikariDataSource(hikariConfig);


        EngineConfig engineConfig = EngineConfig.builder()
                //生成文件路径
                .fileOutputDir("D:\\Study_Java")
                // 打开目录
                .openOutputDir(true)
                // 文件类型，支持word、md和html
                .fileType(EngineFileType.HTML)

                //生成模板实现，支持freemarker和velocity
                .produceType(EngineTemplateType.freemarker).build();

        //生成配置文档
        Configuration configuration = Configuration.builder()
                .version("1.0.0")
                .description("数据库说明文档")
                .dataSource(dataSource)
                .engineConfig(engineConfig)
                .produceConfig(getProcessConfig())
                .build();

        //执行生成
        new DocumentationExecute(configuration).execute();
    }

    /**
     * 配置想要生成的表 + 配置想要忽略的表
     * @return
     */
    private ProcessConfig getProcessConfig() {
        // 忽略表名
        List<String> ignoreTable = Arrays.asList("test_xxx");
        //忽略表前缀，如忽略a开头的数据库表
        List<String> ignorePrefix = Arrays.asList("test_");
        //忽略表后缀
        List<String> ignoreSuffix = Arrays.asList("_test");

        return ProcessConfig.builder()
                // 根据名称生成指定表
                .designatedTableName(new ArrayList<String>())
                // 根据表前缀生成
                .designatedTablePrefix(new ArrayList<String>())
                // 根据表后缀生成
                .designatedTableSuffix(new ArrayList<String>())
                // 忽略表名
                .ignoreTableName(ignoreTable)
                // 忽略表前缀
                .ignoreTablePrefix(ignorePrefix)
                // 忽略表后缀
                .ignoreTableSuffix(ignoreSuffix).build();
    }
}
