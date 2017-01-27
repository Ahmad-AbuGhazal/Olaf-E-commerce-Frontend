package edu.mum.olaf.credantial;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class MD5PasswordEncoder {
	
	public static String encode(String password){
	Md5PasswordEncoder  passwordEncoder=new Md5PasswordEncoder();
    String hashpassword=	passwordEncoder.encodePassword(password, null);
    return hashpassword;
}
}
