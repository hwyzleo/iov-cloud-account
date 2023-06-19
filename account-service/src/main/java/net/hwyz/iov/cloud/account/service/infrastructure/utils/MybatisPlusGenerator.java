package net.hwyz.iov.cloud.account.service.infrastructure.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.dao.BaseDao;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.po.BasePo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.Collections;
import java.util.Properties;

/**
 * MyBatis-Plus代码生成器
 *
 * @author hwyz_leo
 */
public class MybatisPlusGenerator {

    @Value("${spring.datasource.url}")
    private String url;

    public static void main(String[] args) {
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(new ClassPathResource("application.yml"));
        Properties properties = factoryBean.getObject();
        String url = properties.getProperty("spring.datasource.url");
        String username = properties.getProperty("spring.datasource.username");
        String password = properties.getProperty("spring.datasource.password");
        // 数据源配置
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("hwyz_leo")        // 设置作者
                            //.enableSwagger()        // 开启 swagger 模式 默认值:false
                            .disableOpenDir()       // 禁止打开输出目录 默认值:true
                            .commentDate("yyyy-MM-dd") // 注释日期
                            .dateType(DateType.ONLY_DATE)   //定义生成的实体类中日期类型 DateType.ONLY_DATE 默认值: DateType.TIME_PACK
                            .outputDir(System.getProperty("user.dir") + "/account-service" + "/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("net.hwyz.iov.cloud.account.service") // 父包模块名
                            //.controller("controller")   //Controller 包名 默认值:controller
                            .entity("infrastructure.repository.po")           //Entity 包名 默认值:entity
                            //.service("service")         //Service 包名 默认值:service
                            .mapper("infrastructure.repository.dao")           //Mapper 包名 默认值:mapper
                            //.moduleName("xxx")        // 设置父包模块名 默认值:无
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/account-service" + "/src/main/resources/mappers")); // 设置mapperXml生成路径
                })
                .templateConfig(builder -> {
                    builder.service("") // 不生成Service
                            .serviceImpl("") // 不生成ServiceImpl
                            .controller("")
                            .mapper("/templates/HwyzMapper.java") // DAO模板
                            .xml("/templates/HwyzMapper.xml") // XML模板
                            .entity("/templates/HwyzEntity.java"); // 数据对象模板
                })
//                .injectionConfig(consumer -> {
//                    Map<String, String> customFile = new HashMap<>();
//                    // DTO、VO
//                    customFile.put("DTO.java", "/templates/entityDTO.java.ftl");
//                    customFile.put("VO.java", "/templates/entityVO.java.ftl");
//                    consumer.customFile(customFile);
//                })
                .strategyConfig(builder -> {
                    builder.addInclude("tb_account", "tb_token", "tb_client") // 设置需要生成的表名 可边长参数“user”, “user1”
                            .addTablePrefix("tb_") // 设置过滤表前缀
                            //.serviceBuilder()
                            //.serviceBuilder()//service策略配置
                            //.formatServiceFileName("%sService")
                            //.formatServiceImplFileName("%sServiceImpl")
                            .entityBuilder()// 实体类策略配置
                            .superClass(BasePo.class) // 设置父类
//                            .enableFileOverride() // 覆盖已生成文件
                            .enableLombok() // 开启lombok
                            .enableTableFieldAnnotation() // 开启生成实体时生成字段注解
                            .versionColumnName("row_version") // 乐观锁字段名(数据库)
                            .logicDeleteColumnName("is_valid")// 逻辑删除字段名(数据库)
                            .addSuperEntityColumns("is_valid", "row_version", "modify_time", "modify_by", "create_time", "create_by", "description") // 添加父类公共字段
                            .idType(IdType.AUTO) // 主键策略
                            .formatFileName("%sPo") // 格式化文件名称
                            .addTableFills(new Column("create_time", FieldFill.INSERT)) // 自动填充配置
                            .addTableFills(new Property("modify_time", FieldFill.INSERT_UPDATE))
                            //.controllerBuilder() //controller 策略配置
                            //.formatFileName("%sController")
                            //.enableRestStyle() // 开启RestController注解
                            .mapperBuilder()// mapper策略配置
                            .superClass(BaseDao.class) // DAO父类
                            //.enableFileOverride() // 覆盖已生成文件
                            .enableMapperAnnotation() // 开启 @Mapper 注解
                            .enableBaseResultMap() // 启用 BaseResultMap 生成
                            .enableBaseColumnList() // 启用 BaseColumnList
                            .formatMapperFileName("%sDao") // 格式化 mapper 文件名称
                            .formatXmlFileName("%sMapper"); // 格式化 xml 实现类文件名称
                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                //.templateEngine(new FreemarkerTemplateEngine())
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
