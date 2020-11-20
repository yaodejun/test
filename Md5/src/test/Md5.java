package test;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author admin
 * @descript MD5加密方式
 */
public class Md5 {
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		System.out.println("=====================================普通加密=================================");
		
		System.out.println(SimpleMd5_1("1234525436543636243636364"));
		
		System.out.println("========================================选择普通加密==============================");
		
		System.out.println(SimpleMd5_2("1234525436543636243636364",1,32));
		
		System.out.println("=======================================SHA加密（安全更高）===============================");
		
		System.out.println(SimpleMd5_3("1234525436543636243636364",1,32));
	}
	
	
	/**
	 * @param passWord(密码)
	 * @return 加密后的字符串
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @describe 简单加密
	 */
	public static String SimpleMd5_1(String passWord) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
         MessageDigest md = MessageDigest.getInstance("md5");
         
         byte[] bytes = md.digest(passWord.getBytes());
         
         String Md5 = Base64.getEncoder().encodeToString(bytes);
         return Md5;
	}
	/**
	 * @param passWord(密码)
	 * @param positiveOrNegative(返回正负字符串)
	 * @param length(返回字符串长度)
	 * @return 加密后的字符串
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @describe 普通加密，可选择正负值和长度
	 */
	public static String SimpleMd5_2(String passWord,int positiveOrNegative,int length) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
        MessageDigest md = MessageDigest.getInstance("md5");
        
        md.update(passWord.getBytes());
        
        String Md5 = new BigInteger(positiveOrNegative,md.digest()).toString(length);
        return Md5.toUpperCase();
	}
	
	/**
	 * @param passWord(密码)
	 * @param positiveOrNegative(返回正负字符串)
	 * @param length(返回字符串长度)
	 * @return 加密后的字符串
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @describe SHA加密，可选择正负值和长度，更安全
	 */
	public static String SimpleMd5_3(String passWord,int positiveOrNegative,int length) throws NoSuchAlgorithmException, UnsupportedEncodingException {
			
	    MessageDigest md = MessageDigest.getInstance("SHA");
	        
	    md.update(passWord.getBytes());
	        
	    String Md5 = new BigInteger(positiveOrNegative,md.digest()).toString(length);
	    
	    return Md5.toUpperCase();
	}

}
