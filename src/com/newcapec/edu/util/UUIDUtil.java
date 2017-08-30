package com.newcapec.edu.util;

import java.util.UUID;

public class UUIDUtil {
	public static String getUUID(){
		//把-给替换掉
		return UUID.randomUUID().toString().replace("-", "");//�õ������һ���ַ���
	}
	
/*	public static void main(String[] args) {
		System.out.println(getUUID());
	}*/
}
