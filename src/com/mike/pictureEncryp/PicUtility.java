package com.mike.pictureEncryp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * the class include the functions which copies the original picture, makes it
 *  encrypted / un-encrypted, and saves it as a new file.
 * @author mikew
 */
public class PicUtility {
	
	/**
	 * the method is basically a normal function which copies the file and save
	 * as a new one, however, when reading the byte values from the input stream,
	 * the method uses ^3 to switch the byte values and then write the new values 
	 * into the output stream. So the new file will have different byte values and
	 * shows a totally different "looking" as the original one
	 * @param oldJPG	the original picture to be copied and encrypted
	 * @param newJPG	the new saved pricture after being encrypted
	 */
	public void picEncrypt(File oldJPG, File newJPG) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        
        try {
        	// create the input and output stream
            fis = new FileInputStream(oldJPG);
            fos = new FileOutputStream(newJPG);

            // create the byte array to catch the value of the file stream
            byte[] buffer = new byte[10];
            
            // declare the length of the array
            int len;
            
            /*
             *  read the value of the old JPG and put the values into the buffer array, 
             *  then write the values into the new file
             */
            while ((len = fis.read(buffer)) != -1) {
                for (int i = 0; i < len; i++) {
                	// when reading, use ^3 to switch the byte values in the array
                    buffer[i] = (byte) (buffer[i] ^ 3);
                }
                // write the values into the new file
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	// close the stream
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

	}
	
	
	/**
	 * similar with the picEncrypt() method, the picUnEncrypt() is also a normal
	 * copy function which copies 1 file and saves it as a new one. Just like
	 * picEncrypt(), picUnEncrypt() is using ^3, too, during the process when reading
	 * byte values from the input stream, and save the switched values to the new
	 * file, which makes the byte values of the new saving file exactly the same 
	 * as the very oringinal picture.
	 * @param oldJPG   the file which has been encrypted
	 * @param newJPG	the file to be saved and un-encrypted
	 */
	public void picUnEncrypt(File oldJPG, File newJPG) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        
        try {
        	// create the input and output streams
            fis = new FileInputStream(oldJPG);
            fos = new FileOutputStream(newJPG);
            
            // create the byte array to catch the value of the file stream
            byte[] buffer = new byte[10];

            // read the value of the old JPG and write into the new file
            int len;
            
            /*
             *  read the value of the old JPG and put the values into the buffer array, 
             *  then write the values into the new file
             */
            while ((len = fis.read(buffer)) != -1) {
                for (int i = 0; i < len; i++) {
                	/*
                	 *  switch the values in the array via ^3, which means changing the 
                	 *  picture "back" to the original value
                	 */
                    buffer[i] = (byte) (buffer[i] ^ 3);
                }

                // write the value into the new file
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	// close the stream
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
	}

}
