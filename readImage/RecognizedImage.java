package com.alibaba.readImage;

/**
 * @author Jerry
 * 2015.04.01 16��24PM
 */
public interface RecognizedImage {

	public void inputImagePath();// ����ͼƬ

	public int getNearestOne();// ȡ��������Ǹ�

	public int getClasslabel();// ��ȡ���

	/**
	 * @return
	 */
	public String getMatchImagePath();// �ҵ���ƥ����Ǹ�·��

}
