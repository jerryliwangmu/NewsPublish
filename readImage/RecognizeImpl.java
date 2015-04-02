package com.alibaba.readImage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Jerry
 *  2015.04.01 16��25 PM
 */
public class RecognizeImpl {
   
	//��ȡ����ͼƬ������
	private List testimage = new ArrayList();
    
	//�ٶ���������
	private static final double BIGMAX = 100000000;
   
	//������Ǹ�ͼƬ
	private int nearestone = -1;
    
	
	//ģ��ģʽ
	public void process() {

		inputImagePath();
		getNearestOne();
		getClasslabel();
		getMatchImagePath();

	}

	/**
	 *  ����ͼƬ
	 */
	public void inputImagePath() {

		String imagepath = "";
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("please input the image absolute path");
			String filepath = scanner.nextLine();
			TransferImage tr = new TransferImage(filepath);
			testimage = tr.getImageRdistribute();
			System.out
					.println("input Ok,wait a moment,we are finding the match one");

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	/**
	 * @return
	 * ȡ�����
	 */
	public int getNearestOne() {

		try {
			List alllist = AllImagesFeature.getAllImageFeatures();

			double distance = BIGMAX;
			int count = alllist.size();

			for (int i = 0; i < count; i++) {

				double tempdistance = getDistance(testimage,
						(List) alllist.get(i));
				if (tempdistance < distance) {
					distance = tempdistance;
					nearestone = i;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Nearest one is the " + nearestone + " pictures");
		return nearestone;
	}

	/**
	 * @return
	 * ȡ�����
	 */
	public int getClasslabel() {

		System.out.println("we have 40 classes");
		int label = -1;
		if (nearestone != -1)
			label = nearestone / 10;

		if (label >= 0) {
			System.out.println("the picture belongs to the " + label
					+ " classes");
		}
		return label;

	}

	/**
	 * @return
	 * ���·��
	 */
	public String getMatchImagePath() {

		List<String> list = GetFilesPath.getFileList("F://faces");
		String filepath = null;
		if (nearestone != -1) {
			filepath = list.get(nearestone);
		}
		System.out.println("The match file path is " + filepath);

		return filepath;
	}

	/**
	 * @param list1
	 * @param list2
	 * @return
	 * ���ؾ���
	 */
	private double getDistance(List list1, List list2) {
		if (list1 == null || list1.isEmpty())
			return BIGMAX;
		if (list2 == null || list2.isEmpty())
			return BIGMAX;

		int len = list1.size();
		double distance = 0;
		for (int i = 0; i < len; i++) {
			Integer l1 = (Integer) list1.get(i);
			Integer l2 = (Integer) list2.get(i);
			distance = (l1 - l2) * (l1 - l2) + distance;
		}

		return distance;
	}

	public static void main(String args[]) {
		RecognizeImpl rec = new RecognizeImpl();
		rec.process();

	}
}
