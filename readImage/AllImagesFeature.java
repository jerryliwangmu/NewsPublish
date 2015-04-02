package com.alibaba.readImage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jerry
 * 
 *         2015.04.01 16.06 PM
 */
public class AllImagesFeature {
   
	//将所有图片特征放在一个对列中
	private static List list = new ArrayList();
    
	//图片的所在地
	private static final String ROOT = "F://faces";

	// 构造单例模式
	private AllImagesFeature() {

	}
   
	//多线程要线程保护
	public static synchronized List getAllImageFeatures() {

		if (list.isEmpty()) {
			List<String> filepathlist = GetFilesPath.getFileList(ROOT);
			for (int i = 0; i < filepathlist.size(); i++) {

				TransferImage image = new TransferImage(filepathlist.get(i));
				list.add(image.getImageRdistribute());

			}
		}

		return list;

	}

	public static void main(String args[]) {

		getAllImageFeatures();

	}
}
