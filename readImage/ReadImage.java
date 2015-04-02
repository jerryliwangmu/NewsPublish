package com.alibaba.readImage;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ReadImage {

	private static final int N = 3;

	public static void main(String args[]) {
		int[] rgb = new int[N];
	 	File file = new File("C:/Users/Jerry/Desktop/1.bmp");
		//File file = new File("F:\faces\s1\1.bmp");
	
		BufferedImage bi = null;

		try {
			bi = ImageIO.read(file);

		} catch (Exception e) {
			e.printStackTrace();
		}

		int width = bi.getWidth();
		int height = bi.getHeight();
		int minx = bi.getMinY();
		int miny = bi.getMinY();
		System.out.println("Width is" + ":" + width + " Height is " + ":"
				+ height);
		getRGB(bi, rgb, width, height, minx, miny);

	}

	public static void getRGB(BufferedImage bi, int rgb[], int width,
			int height, int minx, int miny) {

		if (bi == null || rgb == null)
			return;

		for (int i = minx; i < width; i++) {
			for (int j = miny; j < height; j++) {

				int pixel = bi.getRGB(i, j);
				rgb[0] = (pixel & 0xff0000) >> 16;
				rgb[1] = (pixel & 0xff00) >> 8;
				rgb[2] = (pixel & 0xff);
				System.out.println("i=" + i + ",j=" + j + ":(" + rgb[0] + ","
						+ rgb[1] + "," + rgb[2] + ")");
			}
		}

	}
}
