package com.crawler.utils;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;

public class IOUtils {
	/**
	 * 指定编码格式 ，把输入流转化为字符串
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static String getHtml(InputStream is, String encoding)
			throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = is.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		is.close();
		return new String(bos.toByteArray(), encoding);
	}

	/**
	 * 下载图片
	 * 
	 * @param urlString
	 * @param filename
	 * @param savePath
	 * @throws Exception
	 */
	public static void download(String urlString, String filename,
			String savePath) throws Exception {
		// 构造URL
		URL url = new URL(urlString);
		// 打开连接
		URLConnection con = url.openConnection();
		// 设置请求超时为5s
		con.setConnectTimeout(5 * 1000);
		// 输入流
		InputStream is = con.getInputStream();

		// 1K的数据缓冲
		byte[] bs = new byte[1024];
		// 读取到的数据长度
		int len;
		// 输出的文件流
		File sf = new File(savePath);
		if (!sf.exists()) {
			sf.mkdirs();
		}
		OutputStream os = new FileOutputStream(sf.getPath() + "\\" + filename);
		// 开始读取
		while ((len = is.read(bs)) != -1) {
			os.write(bs, 0, len);
		}
		// 完毕，关闭所有链接
		os.close();
		is.close();
	}

	/**
	 * 图片裁剪工具类
	 * 
	 * @param src
	 * @param dest
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @throws IOException
	 */
	public static void cutImage(String src, String dest, int x, int y, int w,
			int h) throws IOException {
		Iterator iterator = ImageIO.getImageReadersByFormatName("jpg");
		ImageReader reader = (ImageReader) iterator.next();
		InputStream in = new FileInputStream(src);
		ImageInputStream iis = ImageIO.createImageInputStream(in);
		reader.setInput(iis, true);
		ImageReadParam param = reader.getDefaultReadParam();
		Rectangle rect = new Rectangle(x, y, w, h);
		param.setSourceRegion(rect);
		BufferedImage bi = reader.read(0, param);
		ImageIO.write(bi, "jpg", new File(dest));
		in.close();

	}

	/**
	 * 判断字符编码集
	 * 
	 * @param str
	 * @return
	 */
	public static String getEncoding(String str) {
		String encode = "GB2312";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s = encode;
				return s;
			}
		} catch (Exception exception) {
		}
		encode = "ISO-8859-1";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s1 = encode;
				return s1;
			}
		} catch (Exception exception1) {
		}
		encode = "UTF-8";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s2 = encode;
				return s2;
			}
		} catch (Exception exception2) {
		}
		encode = "GBK";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s3 = encode;
				return s3;
			}
		} catch (Exception exception3) {
		}
		return "未知";
	}

	/**
	 * 把输入流转换成图片---》获取验证码
	 * 
	 * @param is
	 * @param filename
	 * @param savePath
	 * @throws Exception
	 */
	public static void getSecret(InputStream is, String filename,
			String savePath) throws Exception {
		// 1K的数据缓冲
		byte[] bs = new byte[1024];
		// 读取到的数据长度
		int len;
		// 输出的文件流
		File sf = new File(savePath);
		if (!sf.exists()) {
			sf.mkdirs();
		}
		OutputStream os = new FileOutputStream(sf.getPath() + "\\" + filename);
		// 开始读取
		while ((len = is.read(bs)) != -1) {
			os.write(bs, 0, len);
		}
		// 完毕，关闭所有链接
		os.close();
		is.close();
	}

	/**
	 * 获取隐藏字段的__VIEWSTATE值
	 * 
	 * @param url
	 * @param cookie
	 * @param referer
	 * @return
	 * @throws UnsupportedOperationException
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String getViewState(String url, String cookie, String referer)
			throws UnsupportedOperationException, ClientProtocolException,
			IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet getViewState = new HttpGet(url);
		getViewState.setHeader("Cookie", cookie);
		getViewState.setHeader("Referer", referer);// 设置头信息
		String s = IOUtils.getHtml(client.execute(getViewState).getEntity()
				.getContent(), "GB2312");
		String viewstate = Jsoup.parse(s).select("input[name=__VIEWSTATE]")
				.val();
		client.close();
		return viewstate;
	}
}
