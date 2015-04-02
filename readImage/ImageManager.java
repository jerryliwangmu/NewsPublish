package com.alibaba.readImage;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * @author Jerry 2015.04.01 16��22 PM
 */
public class ImageManager {

	// ͼƬ·��
	/**
	 * 
	 */
	private String filepath;

	private BufferedImage bi = null;

	/**
	 * @param filepath
	 * ��ʼ��һЩ������Ϣ
	 */
	public ImageManager(String filepath) {
		this.filepath = filepath;
		try {
			File file = new File(filepath);
			bi = ImageIO.read(file);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	/**
	 * @return
	 * ����ͼƬ�Ŀ��
	 */
	public int getImageWidth() {
		if (bi != null) {
			return bi.getWidth();
		}
		return 0;
	}

	/**
	 * @return
	 * ����ͼƬ�ĸ߶�
	 */
	public int getImageHeight() {
		if (bi != null) {
			return bi.getHeight();
		}
		return 0;
	}

	/**
	 * @return
	 * ����ͼƬ������߿�ʼ
	 */
	public int getImageMinX() {
		if (bi != null) {
			return bi.getMinX();
		}
		return 0;
	}

	/**
	 * @return
	 * ����ͼƬ���ұ߿�ʼ
	 */
	public int getImageMinY() {
		if (bi != null) {
			return bi.getMinY();
		}
		return 0;
	}

	/**
	 * @return
	 * ��ȡͼƬ��rgb����
	 */
	public ImageEntity getImageInfo() {
		ImageEntity image = new ImageEntity();
		int r[][] = new int[this.getImageWidth()][this.getImageHeight()];
		int g[][] = new int[this.getImageWidth()][this.getImageHeight()];
		int b[][] = new int[this.getImageWidth()][this.getImageHeight()];

		for (int i = this.getImageMinX(); i < this.getImageWidth(); i++) {

			for (int j = this.getImageMinY(); j < this.getImageHeight(); j++) {

				int pixel = bi.getRGB(i, j);
				r[i][j] = (pixel & 0xff0000) >> 16;
				g[i][j] = (pixel & 0xff00) >> 8;
				b[i][j] = (pixel & 0xff);

			}

		}
		image.setR(r);
		image.setB(b);
		image.setG(g);
		return image;
	}

}
