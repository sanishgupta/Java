/****************************************************************************************
 * Copyright (c) 2011 KOJ Group. All Rights Reserved.
 * 
 *
 * Rev 1.0   APR 2012 Sanish Gupta
 * 
 ******************************************************************************************/

package koj.retail.ldap;

import java.io.UnsupportedEncodingException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.apache.log4j.Logger;

public class KOJEncryptDecrypt {
	
	private static Logger log = Logger.getLogger(KOJEncryptDecrypt.class);
	static Cipher ecipher;
	static Cipher dcipher;
	// 8-byte Salt
	static byte[] salt = {(byte)0xA9, (byte)0x9B, (byte)0xC8, (byte)0x32,(byte)0x56, (byte)0x35, (byte)0xE3, (byte)0x03};
	// Iteration count
	static int iterationCount = 19;

	/**
	 * This method used to encrypt the Plain Text String.
	 * 
	 * @param text
	 * @return
	 */
	public static String encryptText(String text) {
		try {
			// Create the key
			KeySpec keySpec = new PBEKeySpec(KOJLdapUtil.ENCRYPTION_DECRYPTION_KEY.toCharArray(), salt, iterationCount);
			SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
			ecipher = Cipher.getInstance(key.getAlgorithm());

			// Prepare the parameter to the ciphers
			AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

			// Create the ciphers
			ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
			// Encode the string into bytes using utf-8
			byte[] utf8 = text.getBytes("UTF8");

			// Encrypt
			byte[] enc = ecipher.doFinal(utf8);

			// Encode bytes to base64 to get a string
			return new sun.misc.BASE64Encoder().encode(enc);

		} catch (java.security.InvalidAlgorithmParameterException e) {
			e.printStackTrace();
			log.error("Error occured : "+ e);
		} catch (java.security.spec.InvalidKeySpecException e) {
			e.printStackTrace();
			log.error("Error occured : "+ e);
		} catch (javax.crypto.NoSuchPaddingException e) {
			e.printStackTrace();
			log.error("Error occured : "+ e);} catch (java.security.NoSuchAlgorithmException e) {
		} catch (java.security.InvalidKeyException e) {
			e.printStackTrace();
			log.error("Error occured : "+ e);
		} catch (javax.crypto.BadPaddingException e) {
			e.printStackTrace();
			log.error("Error occured : "+ e);
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
			log.error("Error occured : "+ e);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			log.error("Error occured : "+ e);
		}
		return null;
	}

	
	/**
	 * This method used to de-crypt the Encrypted Text by encryptText() method.
	 * 
	 * @param text
	 * @return
	 */
	public static String decryptText(String text) {
		
		try {
			// Create the key
			KeySpec keySpec = new PBEKeySpec(KOJLdapUtil.ENCRYPTION_DECRYPTION_KEY.toCharArray(), salt, iterationCount);
			SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
			dcipher = Cipher.getInstance(key.getAlgorithm());

			// Prepare the parameter to the ciphers
			AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

			// Create the ciphers
			dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
			// Decode base64 to get bytes
			byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(text);

			// Decrypt
			byte[] utf8 = dcipher.doFinal(dec);

			// Decode using utf-8
			return new String(utf8, "UTF8");

		} catch (java.security.InvalidAlgorithmParameterException e) {
			e.printStackTrace();
			log.error("Error occured : "+ e);
		} catch (java.security.spec.InvalidKeySpecException e) {
			e.printStackTrace();
			log.error("Error occured : "+ e);
		} catch (javax.crypto.NoSuchPaddingException e) {
			e.printStackTrace();
			log.error("Error occured : "+ e);
		} catch (java.security.NoSuchAlgorithmException e) {
			e.printStackTrace();
			log.error("Error occured : "+ e);
		} catch (java.security.InvalidKeyException e) {
			e.printStackTrace();
			log.error("Error occured : "+ e);
		} catch (javax.crypto.BadPaddingException e) {
			e.printStackTrace();
			log.error("Error occured : "+ e);
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
			log.error("Error occured : "+ e);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			log.error("Error occured : "+ e);
		} catch (java.io.IOException e) {
			e.printStackTrace();
			log.error("Error occured : "+ e);
		}
		return null;
	}
}