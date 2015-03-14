package com.itwill.util;

import java.io.UnsupportedEncodingException;

public class BoardUtils {
	/*
	 * \r\n �� html�� <br>�� convert�Ѵ�
	 */
	public static String convertHtmlBr(String comment) {
		//**********************************************************************
		if (comment == null)
			return "";
		int length = comment.length();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			String tmp = comment.substring(i, i + 1);
			if ("\r".compareTo(tmp) == 0) {
				tmp = comment.substring(++i, i + 1);
				if ("\n".compareTo(tmp) == 0)
					buffer.append("<br>\r");
				else
					buffer.append("\r");
			}
			buffer.append(tmp);
		}
		return buffer.toString();
	}

	public static String ascToksc(String str, boolean isEncode)
		throws UnsupportedEncodingException {
		String result = str;
		if (result == null || result == "")
			return null;

		return new String(result.getBytes("8859_1"), "KSC5601");
	}

	public static String kscToasc(String str)
		throws UnsupportedEncodingException {
		if (str == null || str == "")
			return null;
		//character�� �ڵ带 �ٲپ��ش�.
		return new String(str.getBytes("KSC5601"), "8859_1");
	}

}
