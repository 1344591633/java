package com.fy.test;

import java.util.Scanner;

/**
 * 
 * 当当平台购买图书
 * @author djy QQ:523906275
 * @2020年7月6日
 *
 */
public class BookTest {
	//临时存放图书名称
	static String dataBook1 = "你好，钟南山,记录了钟南山院士迎战新冠肺炎、抗击非典的英雄事迹，通过追溯他不寻常的成长历程以及在医学领域的突出贡献，回顾他八十多年人生的奋斗历程！";
	static String dataBook2 = "数学  我爱你,大数学家的故事";
	static String dataBook3 = "码农翻身,会讲故事的书";
	//临时存储账号与密码
	final static String DATANAME = "djy";
	final static String DATAPWD  = "123456";
	
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		//String searchName = "Spring";//想要搜寻此图书
		
		runWelcome();
		showBookList();
		String searchName = getBookName();
		String resultMsg = msgByBookName(searchName);
		System.out.println(resultMsg);
		//加入购买车
		boolean flag = addCarBook(searchName);
		boolean payFlag = false;//false没有结算,true可以进行操作结算
		if(flag){//if(flag == true){	
			System.out.println(searchName+"已经成功加入购物车");
			payFlag = true;
		}else{
			System.out.println(searchName+"没有加入购物车");
		}
		
		//结算
		if(payFlag){//true调用结算方法
			doPayFlag(resultMsg);//判定登录，进行支付
		}else{
			System.out.println("没有做结算操作");
		}
		
		//close资源
		close();
	}
	
	//6).结算(要求看是否登录true)
	public static void doPayFlag(String resultMsg) {
		
		if(doLogin()){//true为登录成功，false未登录
			System.out.println(DATANAME+"您登录成功，请进行支付操作");
			truePay(resultMsg);
		}
	}
	
	//8).支付
	public static void truePay(String resultMsg) {
		System.out.println("==========进入支付的界面==================");
		System.out.println(resultMsg);//拿到的是具体的价格
		//System.out.println(resultMsg.substring(resultMsg, endIndex));
		System.out.println("请输入要支付的价格");
		//从订单信息里截取价格
		double dataPrice= Double.valueOf(resultMsg.substring(resultMsg.indexOf("¥")+1, resultMsg.lastIndexOf(",")));
		double price = in.nextDouble();
		if(price == dataPrice){
			System.out.println("您已经成功支付"+price+"元");
			//生成订单信息
			info(resultMsg);
		}else{
			System.out.println("请您重新支付...");
		}
	}
	
	//9.订单信息(随机)
	public static void info(String resultMsg) {
		System.out.println(DATANAME+"您购卖:"+resultMsg+"，您的订单号为:z"+System.currentTimeMillis());
	}
	
	//7).登录功能
	public static boolean doLogin() {
		System.out.println("===========进入登录界面===================");
		System.out.println("请输入用户名:");
		String username = in.next();
		System.out.println("请输入密码:");
		String password = in.next();
		boolean loginFlag = false;//false没有登录成功，true登录成功
		if((username == null || "".equals(username))){
			System.out.println("用户名不能为空...");
		}
		else if((password == null || "".equals(password))){
			System.out.println("密码不能为空...");
		}
		else if(username.equals(DATANAME) && password.equals(DATAPWD)){
			loginFlag = true;
		}
		
		return loginFlag;
	}
	
	//5).加入购物车
	public static boolean addCarBook(String searchName) {
		return (searchName != null && !"".equals(searchName))?true:false;
	}
	
	public static void close() {
		in.close();
	}
	
	//4.输入框输入图书名称，把结果返回到main方法
	public static String getBookName() {
		System.out.println("==========进入搜寻图书============");
		System.out.println("请输入图书名称:");
		String searchName=in.next();
		return searchName;
	}
	
	//3).输入框里搜寻到<码农翻身>,如搜寻到，则罗列出来，若搜寻结果没有，提示"抱歉，没有找到与“xxwww”相关的商品，为您推荐“西夏文物”的相关商品"
	public static String msgByBookName(String searchName) {
		String msg = "抱歉，没有找到与“"+searchName+"”相关的商品，为您推荐“西夏文物”的相关商品";
		if(dataBook1.contains(searchName) || dataBook2.contains(searchName) || dataBook3.contains(searchName)){//包含有码农翻身这本书
			msg = "码农翻身,价格:¥47.60,作者:刘欣";
		}//过后补充?
		return msg;
	}
	
	//2).有图书列表
	public static void showBookList() {
		System.out.println("============图书列表=====================");
		System.out.println("1."+dataBook1);
		System.out.println("2."+dataBook2);
		System.out.println("3."+dataBook3);
	}
	
	//1).访问平台
	public static void runWelcome() {
		System.out.println("欢迎进入当当平台");
	}
	
	

}
