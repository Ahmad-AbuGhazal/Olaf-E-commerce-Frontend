package credintals;

import org.junit.Test;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {
@Test
public void testMD5(){
	String password="admin1";
	Md5PasswordEncoder  passwordEncoder=new Md5PasswordEncoder();
      String hashpassword=	passwordEncoder.encodePassword(password, null);
	System.out.println(hashpassword);
	
}
@Test
public void test(){
	String password="admin1";
	BCryptPasswordEncoder  passwordEncoder=new BCryptPasswordEncoder();
      String hashpassword=	passwordEncoder.encode(password);
	System.out.println(hashpassword);
	
}
}
