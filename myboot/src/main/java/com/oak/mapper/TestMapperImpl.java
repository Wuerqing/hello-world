package com.oak.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestMapperImpl implements  TestMapper{
    @Autowired
    private TestMapper testMapper;
    @Override
    public String getTime() {
        return testMapper.getTime();
    }
}
