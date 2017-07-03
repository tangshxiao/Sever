package com.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.Ret;
import com.service.AdminUserService;

@Controller
@RequestMapping("/adminUser")
public class AdminUserController {

	@Autowired
	private AdminUserService adminUserService;

	@ResponseBody
	@RequestMapping(value = "/login", produces = { "application/json;charset=UTF-8" })
	public Ret login(@RequestParam Map<String, Object> params) throws Exception {
		System.out.print("来了");
		if (StringUtils.isEmpty(params.get("loginName"))) {
			return new Ret(1, "账号不能为空");
		}

		if (StringUtils.isEmpty(params.get("password"))) {
			return new Ret(1, "密码不能为空");
		}
		Map<String, Object> user = adminUserService.login(params);
		System.out.println(user);
		if (!StringUtils.isEmpty(user)) {
			return new Ret(2, "登陆成功", user);
		}
		return new Ret(3, "账户或密码错误");
	}

	@ResponseBody
	@RequestMapping(value = "/add", produces = { "application/json;charset=UTF-8" })
	public Ret add(@RequestParam Map<String, Object> params) throws Exception {

		if (StringUtils.isEmpty(params.get("loginName"))) {
			return new Ret(1, "账户为空");
		}

		if (StringUtils.isEmpty(params.get("password"))) {
			return new Ret(1, "密码为空");
		}
		int aRow = adminUserService.add(params);

		if (aRow > 0) {
			return new Ret(2, "成功");
		}
		return new Ret(3, "失败");
	}

	@ResponseBody
	@RequestMapping(value = "/create", produces = { "application/json;charset=UTF-8" })
	public Ret  create(@RequestParam Map<String, Object> params){

		return null;
	}
}
