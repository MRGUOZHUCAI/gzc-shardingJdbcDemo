package com.gzc.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import io.shardingsphere.core.api.ShardingDataSourceFactory;
import io.shardingsphere.core.api.config.ShardingRuleConfiguration;


import io.shardingsphere.core.api.config.TableRuleConfiguration;
import io.shardingsphere.core.api.config.strategy.InlineShardingStrategyConfiguration;

import org.apache.catalina.valves.CrawlerSessionManagerValve;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


import javax.sql.DataSource;
import java.sql.Driver;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author YCKJ0750
 * @date 2018/9/14 10:57
 */
@Configuration
public class DataSourceConfig {

    /**
     * 配置数据源
     * @return
     */
    private static DataSource createDataSource(final String dataSourceName) {
        //使用druid连接数据库
        DruidDataSource result = new DruidDataSource();
        result.setDriverClassName("com.mysql.jdbc.Driver");
        result.setUrl(String.format("jdbc:mysql://localhost:3306/%s", dataSourceName));
        result.setUsername("root");
        result.setPassword("20180716");
        return result;
    }

    /**
     * 配置数据源规则，即将多个数据源交给sharding-jdbc管理，并且可以设置默认的数据源，
     *   当表没有配置分库规则时会使用默认的数据源
     * @return
     */
    @Bean(name = "dataSourceMap")
    public Map<String,DataSource>getDataSourceMap(){
        Map<String,DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("dataSource0",createDataSource("db0"));
        dataSourceMap.put("dataSource1",createDataSource("db1"));
        return dataSourceMap;
    }


    /**
     * 配置分片规则：
     * 1.逻辑表和实际表
     * 2.配置分库分表策略
     * 3.设置分片参数
     * @return
     */

    @Bean(name = "orderTableShardingRule")
    public ShardingRuleConfiguration getOrderTableRule(){

        /**
         * 配置order表规则
         */
        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration();
        //逻辑表
        orderTableRuleConfig.setLogicTable("t_order");
        //实际表(数据源名称+表名)
        //orderTableRuleConfig.setActualDataNodes("dataSource$->{0..1}.t_order_$->{0..1}");
        orderTableRuleConfig.setActualDataNodes("dataSource0.t_order_0,dataSource0.t_order_1,dataSource1.t_order_0,dataSource1.t_order_1");
        //分库策略（order_id为数据库中字段名，dataSource为数据源名）
        InlineShardingStrategyConfiguration s1 = new InlineShardingStrategyConfiguration("order_id","dataSource${order_id % 2}");
        orderTableRuleConfig.setDatabaseShardingStrategyConfig(s1);
        //分表策略
        InlineShardingStrategyConfiguration s2 = new InlineShardingStrategyConfiguration("user_id","t_order_${user_id % 2}");
        orderTableRuleConfig.setTableShardingStrategyConfig(s2);

        /**
         * 配置order_item表规则
         */
        TableRuleConfiguration orderItemTableRuleConfig = new TableRuleConfiguration();
        orderItemTableRuleConfig.setLogicTable("t_order_items");
        orderItemTableRuleConfig.setActualDataNodes("dataSource${0..1}.t_order_items_${0..1}");
        InlineShardingStrategyConfiguration s3 = new InlineShardingStrategyConfiguration("order_id","dataSource${order_id % 2}");
        orderItemTableRuleConfig.setDatabaseShardingStrategyConfig(s3);
        InlineShardingStrategyConfiguration s4 = new InlineShardingStrategyConfiguration("order_id","t_order_items_${order_id % 2}");
        orderItemTableRuleConfig.setDatabaseShardingStrategyConfig(s4);

        //配置分片规则
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);
        shardingRuleConfig.getTableRuleConfigs().add(orderItemTableRuleConfig);
        //设置默认的数据库
        shardingRuleConfig.setDefaultDataSourceName("dataSource1");
       // shardingRuleConfig.getBindingTableGroups().add("t_order");

        return shardingRuleConfig;
    }

    /**
     *获取数据源对象
     */
    @Bean(name = "ShardingDataSource")
    public DataSource getDataSource(@Qualifier("dataSourceMap")Map<String,DataSource> dataSourceMap,
                                    @Qualifier("orderTableShardingRule")ShardingRuleConfiguration  orderTableRule){
        DataSource dataSource = null;
        try {
             dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap,orderTableRule,new ConcurrentHashMap(),new Properties());
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataSource;
    }

}
