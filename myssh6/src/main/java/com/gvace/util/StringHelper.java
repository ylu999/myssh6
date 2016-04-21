package com.gvace.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;


public class StringHelper {
	public static String MD5(String md5) {
		 try {
		  java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		  byte[] array = md.digest(md5.getBytes());
		  StringBuilder sb = new StringBuilder();
		  for (int i = 0; i < array.length; ++i) {
		   sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
		  }
		  return sb.toString();
		 } catch (java.security.NoSuchAlgorithmException e) {
			 throw new RuntimeException(e.getMessage());
		 }
	}
	public static Integer getIntegerParameter(HttpServletRequest request, String name){
		String valueStr = (String)request.getParameter(name);
		if(valueStr==null)return null;
		else if(StringUtils.isNumeric(valueStr)){
			return Integer.parseInt(valueStr);
		}
		return null;
	}
}
