package com.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.AdminUserMapper;

@Service
public class AdminUserService {

	@Resource
	private AdminUserMapper adminUserMapper;

	@Transactional
	public Map<String, Object> login(Map<String, Object> params) {
		return adminUserMapper.login(params);
	}

	@Transactional
	public int add(Map<String, Object> params) {
		return adminUserMapper.add(params);
	}

}
