package com.zl.pattern.interpret;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanglan
 * @description BD谱转简谱解释器
 * @date 2020-07-15
 */
public class BlowDrawExpression implements IExpression {

	private Context context;

	private Map<Character, String> musicMap = new HashMap<Character, String>();

	public BlowDrawExpression() {
		musicMap.put('3', "低5");
		musicMap.put('③', "低7");
		musicMap.put('4', "1");
		musicMap.put('④', "2");
		musicMap.put('5', "3");
		musicMap.put('⑤', "4");
		musicMap.put('6', "5");
		musicMap.put('⑥', "6");
		musicMap.put('⑦', "7");
		musicMap.put('7', "高1");
		musicMap.put('⑧', "高2");
		musicMap.put('8', "高3");
		musicMap.put('⑨', "高4");
		musicMap.put('9', "高5");
	}

	@Override
	public void interpret(Context context) {
		String input = context.getInput();
		char[] chars = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char c: chars) {
			if (musicMap.containsKey(c)) {
				sb.append(musicMap.get(c));
			} else {
				sb.append(c);
			}
		}
		context.setOutput(sb.toString());
	}

}
