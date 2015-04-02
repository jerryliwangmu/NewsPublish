package com.alibaba.readImage;

import java.util.List;

public interface ImageInterface {

	public ImageEntity getImageEntity(String file);// 获取图片

	public List getImageList();// 获取图片特征

	public List getImageRdistribute();// 获取图片的红色特征分布

	public List getImageGdistribute();// 获取图片的绿色特征分布

	public List getImageBdistribute();// 获取图片的蓝色特征分布

}
