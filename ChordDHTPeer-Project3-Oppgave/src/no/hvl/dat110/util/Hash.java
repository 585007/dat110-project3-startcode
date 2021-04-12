package no.hvl.dat110.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * project 3
 * @author Ruben
 */
public class Hash { 
	private static BigInteger hashint;
	
	public static BigInteger hashOf(String entity) {
		
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		// we use MD5 with 128 bits digest
		
		// compute the hash of the input 'entity'
		
		// convert the hash into hex format
		
		// convert the hex into BigInteger
		
		// return the BigInteger
		
		try {
			byte[] entityBytes = entity.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			byte[] entityMD5 = md.digest(entityBytes);
			hashint = new BigInteger(1, entityMD5);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		
		// get the digest length
		
		// compute the number of bits = digest length * 8
		
		// compute the address size = 2 ^ number of bits
		
		// return the address size
		
		int bits = bitSize();
		String bit = "2";
		BigInteger singleBit = new BigInteger(bit.getBytes());
		
		BigInteger addressSize = singleBit.pow(bits);
		
		return addressSize;
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			digestlen = md.digest().length;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
