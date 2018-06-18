package com.dev.rsa;
import java.io.File; 
 import java.io.FileInputStream; 
 import java.io.FileOutputStream; 
 import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher; 
 import javax.crypto.spec.SecretKeySpec; 
  
 public class TestFileEncryptionWithRSA { 
   
  private static final String ALGORITHM = "Blowfish";
  private static final String ALGORITHM_RSA = "RSA"; 
  private static String keyString = "Desire"; 
  
  public static void encrypt(File inputFile, File outputFile) 
    throws Exception { 
   doCrypto(Cipher.ENCRYPT_MODE, inputFile, outputFile); 
   System.out.println("File encrypted successfully!"); 
  } 
  
  public static void decrypt(File inputFile, File outputFile) 
    throws Exception { 
   doCrypto(Cipher.DECRYPT_MODE, inputFile, outputFile); 
   System.out.println("File decrypted successfully!"); 
  } 
  
  private static void doCrypto(int cipherMode, File inputFile, 
    File outputFile) throws Exception { 
  
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM_RSA);
		Cipher cipherRSA = Cipher.getInstance(ALGORITHM_RSA);
		keyPairGenerator.initialize(1024);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		PrivateKey privKey = keyPair.getPrivate();
		PublicKey pubKey = keyPair.getPublic();
		
		Key secretKeyRSA = new SecretKeySpec(privKey.toString().getBytes(), ALGORITHM); 
		cipherRSA.init(cipherMode, secretKeyRSA);
	  
   /*Key secretKey = new SecretKeySpec(keyString.getBytes(), ALGORITHM); 
   Cipher cipher = Cipher.getInstance(ALGORITHM); 
   cipher.init(cipherMode, secretKey); */

  
   FileInputStream inputStream = new FileInputStream(inputFile); 
   byte[] inputBytes = new byte[(int) inputFile.length()]; 
   inputStream.read(inputBytes); 
  
   //byte[] outputBytes = cipher.doFinal(inputBytes);
   
   byte[] outputBytesRSA = cipherRSA.doFinal(inputBytes); 
  
   FileOutputStream outputStream = new FileOutputStream(outputFile); 
   //outputStream.write(outputBytes);
   outputStream.write(outputBytesRSA); 
  
   inputStream.close(); 
   outputStream.close(); 
  
  } 
  
  public static void main(String[] args) { 
    
   File inputFile = new File("C:/ATG/test/cleartext.xlsx"); 
   File encryptedFile = new File("C:/ATG/test/cleartext1.xlsx"); 
    
   File decryptedFile = new File("C:/ATG/test/cleartext2.xlsx"); 
  
   
   
   
   try { 
    TestFileEncryptionWithRSA.encrypt(inputFile, encryptedFile); 
    TestFileEncryptionWithRSA.decrypt(encryptedFile, decryptedFile); 
   } catch (Exception e) { 
    e.printStackTrace(); 
   } 
    
    
  } 
 } 
