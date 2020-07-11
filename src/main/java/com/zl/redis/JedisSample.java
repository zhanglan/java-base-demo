package com.zl.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/8
 */
public class JedisSample {

	private static final String host = "172.22.56.25";

	private static final int port = 6379;

	public static void main(String[] args) {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(100);
		config.setMaxIdle(50);
		config.setMinIdle(10);

		JedisPool jedisPool = new JedisPool(config, host, port, 3000, "123456a?");

		try(Jedis jedis = jedisPool.getResource()) {

//			System.out.println(jedis.set("zhanglan:0001", "0001"));
			System.out.println(jedis.lpush("zhanglan:0001", "a"));
			System.out.println(jedis.blpop(10, "zhanglan:0001"));
		}


	}


}
