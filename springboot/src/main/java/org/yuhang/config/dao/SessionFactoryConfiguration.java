package org.yuhang.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by chinalife on 2018/5/20.
 */
@Configuration
@MapperScan("org.yuhang.dao")
public class SessionFactoryConfiguration {

    @Autowired
    @Qualifier(value = "dataSource")
    private DataSource dataSource;
    @Value("${mybatis.mybatisConfig}")
    private String mybatisConfig;
    @Value("${mybatis.type-aliases-package}")
    private String typeAliasesPath;
    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;

    @Bean(name = "sqlSessionFactoryBean")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfig));
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPath);
        String mapperSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperLocations;
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperSearchPath));
        return sqlSessionFactoryBean;
    }


}
