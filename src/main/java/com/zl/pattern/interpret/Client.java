package com.zl.pattern.interpret;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public class Client {

	public static void main(String[] args) {
		// ①②③④⑤⑥⑦⑧⑨⑩
		String bdMusic = "5⑤6⑤6⑦⑤,③5④56④,③4③46,6⑤④④⑤⑤";
		Context context = new Context(bdMusic);
		BlowDrawExpression expression = new BlowDrawExpression();
		expression.interpret(context);
		System.out.println(context.toString());
	}

}
