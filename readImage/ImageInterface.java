package com.alibaba.readImage;

import java.util.List;

public interface ImageInterface {

	public ImageEntity getImageEntity(String file);// ��ȡͼƬ

	public List getImageList();// ��ȡͼƬ����

	public List getImageRdistribute();// ��ȡͼƬ�ĺ�ɫ�����ֲ�

	public List getImageGdistribute();// ��ȡͼƬ����ɫ�����ֲ�

	public List getImageBdistribute();// ��ȡͼƬ����ɫ�����ֲ�

}
