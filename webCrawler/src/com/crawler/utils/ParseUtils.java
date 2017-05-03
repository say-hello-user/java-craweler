package com.crawler.utils;

public class ParseUtils {
	/**
	 * 获取课程节次对应的字符串
	 * @param course
	 * @return
	 */
	public static String parseWeek(String course) {
		String sjd="";
		int nowCourse = Integer.parseInt(course);
		switch (nowCourse) {
		case 1:
			sjd=GlobalConstant.CLASS1;
			break;
		case 2:
			sjd=GlobalConstant.CLASS2;
			break;
		case 3:
			sjd=GlobalConstant.CLASS3;
			break;
		case 4:
			sjd=GlobalConstant.CLASS4;
			break;
		case 5:
			sjd=GlobalConstant.CLASS5;
			break;
		case 6:
			sjd=GlobalConstant.CLASS6;
			break;
		case 7:
			sjd=GlobalConstant.CLASS7;
			break;
		case 8:
			sjd=GlobalConstant.CLASS8;
			break;
		case 9:
			sjd=GlobalConstant.CLASS9;
			break;
		case 10:
			sjd=GlobalConstant.CLASS10;
			break;
		case 11:
			sjd=GlobalConstant.CLASS11;
			break;
		default:
			sjd=GlobalConstant.CLASS1;
			break;
		}

		return sjd;
	}
}
