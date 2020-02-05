package com.computer;

public class MyComputer {
	MainFrame frame;
	KeyBoard keyboard;
	Mouse mouse;
	Monitor monitor;

	public MyComputer() {
		frame = new MainFrame("intel","samsung");
		keyboard = new KeyBoard("prince","qwerty");
		mouse = new Mouse("logitec",true);
		monitor = new Monitor("LG",15.4);
	}
//	void init() {
//		frame = new MainFrame("intel","samsung");
//		keyboard = new KeyBoard("prince","qwerty");
//		mouse = new Mouse("logitec",true);
//		monitor = new Monitor("LG",15.4);
//	}
	void powerOn() {
		frame.powerOn();
		monitor.powerOn();
	}
	void powerOff() {
		frame.powerOff();
		monitor.powerOff();
	}
	void doJob() {
		keyboard.keyType();
		mouse.leftClick();
		mouse.rightClick();
		mouse.wheeling();
		keyboard.keyType();
	}
	void info() {
		frame.info();
		keyboard.info();
		mouse.info();
		monitor.info();
	}
}
