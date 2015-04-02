package com.alibaba.readImage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetFilesPath {
   
	//所有图片的绝对路径
	private static List<String> filelist = new ArrayList<String>();

	public static void recursing(String root) {
		try {
			File file = new File(root);
			File[] subFile = file.listFiles();
			for (int i = 0; i < subFile.length; i++) {

				if (subFile[i].isDirectory()) {

					recursing(subFile[i].getAbsolutePath());

				} else {

					String filename = subFile[i].getName();
					int index = filename.indexOf("bmp");
					if (index != -1) {
						// String temp=subFile[i].getAbsolutePath();
						// String bb= temp.replaceAll("\\","/");
						filelist.add(subFile[i].getAbsolutePath());
					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static List getFileList(String root) {

		recursing(root);
		// for (int i = 0; i < filelist.size(); i++)
		// System.out.println(filelist.get(i));
		// String temp = filelist.get(0);
		// TransferImage tt = new TransferImage(temp);
		// List list = tt.getImageList();

		return filelist;

	}

	public static void main(String args[]) {
		getFileList("F://faces");
	}

	// public List getFilePathList(String path) {
	//
	// try {
	//
	// File file = new File(path);
	// File[] files = file.listFiles();
	// for (int i = 0; i < files.length; i++) {
	//
	// String test[] = files[i].list();
	// for (int k = 0; k < test.length; k++) {
	//
	// int len = test[k].indexOf("bmp");
	// if (len != -1) {
	// System.out.println(test[k]);
	//
	// }
	//
	// }
	//
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	//
	// }
	// return null;
	// }
	//
	// public static void main(String args[]) {
	//
	// GetFilesPath file=new GetFilesPath();
	// file.getFilePathList("F://faces");
	// System.out.println("hi good");
	// }
}
