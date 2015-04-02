package com.alibaba.readImage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jerry
 * 
 *         2015.04.01 16.06 PM
 */
public class AllImagesFeature {
   
	//������ͼƬ��������һ��������
	private static List list = new ArrayList();
    
	//ͼƬ�����ڵ�
	private static final String ROOT = "F://faces";

	// ���쵥��ģʽ
	private AllImagesFeature() {

	}
   
	//���߳�Ҫ�̱߳���
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
