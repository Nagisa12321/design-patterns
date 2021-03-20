package com.jtchen.adapter.duck;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/19 10:30
 */
// �������������Ҫת���ɵ����ͽӿ�
// �������Ŀͻ����������Ľӿ�
public class TurkeyAdapter implements Duck {

	private final Turkey turkey;

	// ����, ��Ҫȡ��Ҫ����Ķ�������
	// ���������ù�����ȡ���������
	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}

	// ����������Ҫʵ�ֽӿ��е����з���
	@Override
	public void quack() {
		turkey.gobble();
	}

	// �𼦷�5�� = Ѽ�ӷ�һ��
	@Override
	public void fly() {
		for (int i = 0; i < 5; i++) {
			turkey.fly();
		}
	}
}
