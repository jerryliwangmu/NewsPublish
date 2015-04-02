package com.alibaba.readImage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jerry 2015.04.01
 */
public class TransferImage implements ImageInterface {

	private String filepath;
	private ImageEntity image = null;
	private static final int N = 256;

	public TransferImage(String filepath) {

		this.filepath = filepath;
		ImageManager imagemanager = new ImageManager(filepath);
		image = imagemanager.getImageInfo();

	}

	public ImageEntity getImageEntity(String file) {

		ImageManager imagemanager = new ImageManager(file);
		image = imagemanager.getImageInfo();
		return image;
	}

	public List getImageList() {
		if (image != null) {
			List list = new ArrayList();
			try {
				int r[][] = image.getR();
				int g[][] = image.getG();
				int b[][] = image.getB();

				for (int rows = 0; rows < r.length; rows++)
					for (int columns = 0; columns < r[rows].length; columns++) {
						int sum = r[rows][columns] + g[rows][columns]
								+ b[rows][columns];
						int pix = sum / 3;
						list.add(pix);

					}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return list;

		}
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.alibaba.readImage.ImageInterface#getImageRdistribute()
	 */
	public List getImageRdistribute() {

		if (image != null) {

			int r[][] = image.getR();
			List list = new ArrayList();
			int count[] = new int[N];
			for (int i = 0; i < N; i++) {
				count[i] = 0;
			}
			for (int number = 0; number < N; number++) {
				for (int rows = 0; rows < r.length; rows++) {
					for (int columns = 0; columns < r[rows].length; columns++) {

						if (r[rows][columns] == number) {
							count[number]++;

						}

					}

				}
			}

			for (int k = 0; k < N; k++) {
				list.add(count[k]);

			}
			return list;
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.alibaba.readImage.ImageInterface#getImageGdistribute()
	 * 
	 * 获取G的分布
	 */
	public List getImageGdistribute() {

		if (image != null) {

			int g[][] = image.getG();
			List list = new ArrayList();
			int count[] = new int[N];
			for (int i = 0; i < N; i++) {
				count[i] = 0;
			}
			for (int number = 0; number < N; number++) {
				for (int rows = 0; rows < g.length; rows++) {
					for (int columns = 0; columns < g[rows].length; columns++) {

						if (g[rows][columns] == number) {
							count[number]++;

						}

					}

				}
			}

			for (int k = 0; k < N; k++) {
				list.add(count[k]);

			}
			return list;
		}

		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.alibaba.readImage.ImageInterface#getImageBdistribute()
	 */
	public List getImageBdistribute() {

		if (image != null) {

			int b[][] = image.getB();
			List list = new ArrayList();
			int count[] = new int[N];
			for (int i = 0; i < N; i++) {
				count[i] = 0;
			}
			for (int number = 0; number < N; number++) {
				for (int rows = 0; rows < b.length; rows++) {
					for (int columns = 0; columns < b[rows].length; columns++) {

						if (b[rows][columns] == number) {
							count[number]++;

						}

					}

				}
			}

			for (int k = 0; k < N; k++) {
				list.add(count[k]);

			}
			return list;
		}

		return null;
	}

}
