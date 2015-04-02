package com.alibaba.readImage;

/**
 * @author Jerry
 * 2015.04.01 16：24PM
 */
public interface RecognizedImage {

	public void inputImagePath();// 输入图片

	public int getNearestOne();// 取出最近的那个

	public int getClasslabel();// 获取类别

	/**
	 * @return
	 */
	public String getMatchImagePath();// 找到最匹配的那个路径

}
