package com.crawler.utils;

/**
 * 本系统所有常量定义
 * 
 * @author 宋开宗
 * 
 */
public interface GlobalConstant {
	public static final String START_DAY = "2016-02-29";
	public static final String END_DAY = "2016-07-10";
	public static final String INDEX_URL = "http://jwgl.fjnu.edu.cn";// 福建师范大学教务系统首页
	public static final String SECRETCODE_URL = "http://jwgl.fjnu.edu.cn/CheckCode.aspx";// 验证码页面
	public static final String LOGIN_URL = "http://jwgl.fjnu.edu.cn/default2.aspx";// 福建师范大学教务系统登录页
	public static final String MAIN_URL = "http://jwgl.fjnu.edu.cn/xs_main.aspx?xh=";// 福建师范大学教务系统主页，菜单页面

	public static final String MY_MESSAGE_URL = "http://jwgl.fjnu.edu.cn/xsgrxx.aspx?xh=";
	public static final String MY_MESSAGE_GNMKDM = "&gnmkdm=N121501";
	
<<<<<<< HEAD
	public static final String CHANGE_PASSWORD_URL = "http://jwgl.fjnu.edu.cn/mmxg.aspx?xh=";
	public static final String CHANGE_PASSWORD_GNMKDM = "&gnmkdm=N121502";
	
=======
>>>>>>> b36de55e55427063626017569e84bf29eee05f22
	public static final String QUERY_STU_COURSE_URL = "http://jwgl.fjnu.edu.cn/xskbcx.aspx?xh=";// 福建师范大学查询个人课表链接
	public static final String QUERY_STU_COURSE_GNMKDM = "&gnmkdm=N121603";// 福建师范大学查询个人课表gnmkdm
	public static final String QUERY_STU_GRADE_URL = "http://jwgl.fjnu.edu.cn/xscjcx.aspx?xh=";// 福建师范大学查询个人成绩链接
	public static final String QUERY_STU_GRADE_GNMKDM = "&gnmkdm=N121605";// 福建师范大学查询个人成绩gnmkdm
	public static final String IDENTITY_STU = "学生";// 身份：学生
	public static final String CLASS1 = "'1'|'1','0','0','0','0','0','0','0','0'";// 1，2节
	public static final String CLASS2 = "'2'|'0','3','0','0','0','0','0','0','0'";// 3，4节
	public static final String CLASS3 = "'3'|'0','0','5','0','0','0','0','0','0'";// 5，6节
	public static final String CLASS4 = "'4'|'0','0','0','7','0','0','0','0','0'";// 7，8节
	public static final String CLASS5 = "'5'|'0','0','0','0','9','0','0','0','0'";// 8，10节
	public static final String CLASS6 = "'6'|'0','0','0','0','0','11','0','0','0'";// 11，12节
	public static final String CLASS7 = "'7'|'1','3','0','0','0','0','0','0','0'";// 上午
	public static final String CLASS8 = "'8'|'0','0','5','7','0','0','0','0','0'";// 下午
	public static final String CLASS9 = "'9'|'1','3','5','7','0','0','0','0','0'";// 白天
	public static final String CLASS10 = "'10'|'0','0','0','0','9','11','0','0','0'";// 晚上
	public static final String CLASS11 = "'11'|'1','3','5','7','9','11','0','0','0'";// 全天
	public static final String BTN_XUEQI = "btn_xq";// 学期成绩
	public static final String BTN_XUENIAN = "btn_xn";// 学年成绩
	public static final String BTN_LINIAN = "btn_zcj";// 历年成绩
	public static final String UNIVERSITY_CODE_fjnu = "00001";// 福建师范大学标识代码
	public static final String USER_STATE_N = "1";// 未认证
	public static final String USER_STATE_Y = "2";// 认证通过
	public static final String COMMENT_TYPE_NEWTHINGS = "1";// 评论类型1：新鲜事
	public static final String COMMENT_TYPE_INTEREST = "2";// 评论类型2：兴趣活动
}
