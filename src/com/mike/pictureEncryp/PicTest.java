package com.mike.pictureEncryp;

import java.io.File;

/**
 * it's a test class for the picture encryption system
 * @author mikew
 *
 */
public class PicTest {
	public static void main(String[] args) {
		PicUtility pu = new PicUtility();
		
		// encrypt the picture
		File f1 = new File("C:\\Users\\mikew\\Desktop\\test\\1.jpg");
		File f2 = new File("C:\\Users\\mikew\\Desktop\\test\\2.jpg");
		
		pu.picEncrypt(f1, f2);
		
		// unencrypt the picture
		File f3 = new File("C:\\Users\\mikew\\Desktop\\test\\3.jpg");
		pu.picUnEncrypt(f2, f3);
	}

}
