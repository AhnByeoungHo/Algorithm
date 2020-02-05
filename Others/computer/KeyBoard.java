package com.computer;

public class KeyBoard {

	String maker;
	String type;
	
	public KeyBoard(String string, String string2) {
		this.maker = string;
		this.type = string2;
	}
	void keyType() {
		System.out.println("key board key Type method");
	}
	void info() {
		System.out.println("KEYBOARD");
		System.out.println("maker: " + maker);
		System.out.println("type: " + type);
		System.out.println("----------------");
	}
}
