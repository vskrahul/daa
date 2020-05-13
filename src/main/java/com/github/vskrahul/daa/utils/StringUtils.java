package com.github.vskrahul.daa.utils;

public class StringUtils {

	public static String concat(String separator, String ...strings) {
		StringBuilder sb = new StringBuilder();
		boolean append = false;
		for(String s : strings) {
			if(s != null && !s.trim().equals("")) {
				if(append)
					sb.append(separator);
				else
					append = true;
				sb.append(s);
			}
		}
		return sb.toString();
	}
}
