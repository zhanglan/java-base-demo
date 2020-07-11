package com.zl.controller;

import com.zl.ws.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/27
 */
@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private WebSocket webSocket;

	@GetMapping("say")
	public Map<String, Object> say(@RequestParam String words) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("words", words);
		return map;
	}

	@GetMapping("send")
	public Map<String, Object> sendMessage(@RequestParam("user_id") String userId, @RequestParam String msg) {
		Map<String, Object> map = new HashMap<String, Object>();
		webSocket.sendMessage(userId, msg);
		map.put("success", true);
		map.put("msg", "发送成功");
		return map;
	}

}
