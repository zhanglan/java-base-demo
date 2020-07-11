package com.zl.pattern.memento;

import lombok.Data;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/4/22
 */
@Data
public class Originator {

	private String state = "";

	public Memento createMemento() {
		return new MementoImp(state);
	}

	public void recoverFromMemento(Memento memento) {
		MementoImp mementoImp = (MementoImp) memento;
		this.state = mementoImp.getState();
	}

	private static class MementoImp implements Memento {

		private String state = "";

		private MementoImp(String state) {
			this.state = state;
		}

		private String getState() {
			return this.state;
		}
	}

}
