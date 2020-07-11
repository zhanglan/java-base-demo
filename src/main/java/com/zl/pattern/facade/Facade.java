package com.zl.pattern.facade;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/10
 */
public class Facade {

	private SubSystemA systemA;

	private SubSystemB systemB;

	private SubSystemC systemC;

	public Facade() {
		this.systemA = new SubSystemA();
		this.systemB = new SubSystemB();
		this.systemC = new SubSystemC();
	}

	public void methodOne() {
		System.out.println("第一组方法：");

		this.systemA.operationA();
		this.systemB.operationB();
	}

	public void methodTwo() {
		System.out.println("第二组方法：");

		this.systemA.operationA();
		this.systemC.operationC();
	}

}
