package com.java.multithreading;

import java.util.Iterator;

class Chat {
	boolean flag = false;

	public synchronized void Question(String msg) {
		if (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(msg);
		flag = true;
		notify();
	}

	public synchronized void Answer(String msg) {
		if (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(msg);
		flag = false;
		notify();
	}
}

class T1 implements Runnable {

	Chat m;
	String[] s1 = { "Hi", "Who is the father of Java ?", "NullPointer is what kind of exception ?" };

	public T1(Chat m1) {
		this.m = m1;
		new Thread(this, "Question").start();
	}

	@Override
	public void run() {
		for (int i = 0; i < s1.length; i++) {
			m.Question(s1[i]);
		}
	}
}

class T2 implements Runnable {

	Chat m;
	String[] s1 = { "Hi", "James Ghosline", "It is RunTime Exception." };

	public T2(Chat m1) {
		this.m = m1;
		new Thread(this, "AnswerThread").start();
	}

	@Override
	public void run() {
		for (int i = 0; i < s1.length; i++) {
			m.Answer(s1[i]);
		}
	}
}

public class InterThreadCommunication {
	public static void main(String[] args) {
		Chat m = new Chat();
		new T1(m);
		new T2(m);
	}
}
