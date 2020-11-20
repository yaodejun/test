package test;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author admin
 * @descript MD5���ܷ�ʽ
 */
public class Md5 {
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		System.out.println("=====================================��ͨ����=================================");
		
		System.out.println(SimpleMd5_1("1234525436543636243636364"));
		
		System.out.println("========================================ѡ����ͨ����==============================");
		
		System.out.println(SimpleMd5_2("1234525436543636243636364",1,32));
		
		System.out.println("=======================================SHA���ܣ���ȫ���ߣ�===============================");
		
		System.out.println(SimpleMd5_3("1234525436543636243636364",1,32));
	}
	
	
	/**
	 * @param passWord(����)
	 * @return ���ܺ���ַ���
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @describe �򵥼���
	 */
	public static String SimpleMd5_1(String passWord) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
         MessageDigest md = MessageDigest.getInstance("md5");
         
         byte[] bytes = md.digest(passWord.getBytes());
         
         String Md5 = Base64.getEncoder().encodeToString(bytes);
         return Md5;
	}
	/**
	 * @param passWord(����)
	 * @param positiveOrNegative(���������ַ���)
	 * @param length(�����ַ�������)
	 * @return ���ܺ���ַ���
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @describe ��ͨ���ܣ���ѡ������ֵ�ͳ���
	 */
	public static String SimpleMd5_2(String passWord,int positiveOrNegative,int length) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
        MessageDigest md = MessageDigest.getInstance("md5");
        
        md.update(passWord.getBytes());
        
        String Md5 = new BigInteger(positiveOrNegative,md.digest()).toString(length);
        return Md5.toUpperCase();
	}
	
	/**
	 * @param passWord(����)
	 * @param positiveOrNegative(���������ַ���)
	 * @param length(�����ַ�������)
	 * @return ���ܺ���ַ���
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @describe SHA���ܣ���ѡ������ֵ�ͳ��ȣ�����ȫ
	 */
	public static String SimpleMd5_3(String passWord,int positiveOrNegative,int length) throws NoSuchAlgorithmException, UnsupportedEncodingException {
			
	    MessageDigest md = MessageDigest.getInstance("SHA");
	        
	    md.update(passWord.getBytes());
	        
	    String Md5 = new BigInteger(positiveOrNegative,md.digest()).toString(length);
	    
	    return Md5.toUpperCase();
	}

}
