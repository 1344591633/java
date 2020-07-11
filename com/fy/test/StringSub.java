package com.fy.test;

public class StringSub {

	public static void main(String[] args) {
		String msg = "码农翻身,价格:¥47.60,作者:刘欣";
		System.out.println(msg.indexOf("¥"));//从左到右找
		System.out.println(msg.substring(msg.indexOf("¥")));
		System.out.println(msg.lastIndexOf(","));//从右到左
		System.out.println(msg.substring(msg.lastIndexOf(",")));
		
		System.out.println(msg.substring(msg.indexOf("¥")+1, msg.lastIndexOf(",")));
		
		System.out.println(System.currentTimeMillis());
		//1594005738661

	}

}
