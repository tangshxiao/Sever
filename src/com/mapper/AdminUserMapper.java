package com.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AdminUserMapper {

	int add(@Param("params") Map<String, Object> params);

	Map<String, Object> login(@Param("params") Map<String, Object> params);

}
