package com.chinalife.springmvc.aspect;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by chinalife on 2018/5/22.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSource();
    }
}
