package edu.mum.olaf.expressionhanlder;

import java.io.Serializable;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

public class OlafWebPermittionEvaluator implements PermissionEvaluator {
	@Autowired
private DataSource dataSource;
	@Override
	public boolean hasPermission(Authentication auth, Object target, Object permission) {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	Object[] args={((User)auth.getPrincipal()).getUsername(),target.getClass().getName(),permission.toString()};
		int count=jdbcTemplate.queryForObject("select count(*) from permissions p where p.username=? and p.target=? and p.permission=? ",Integer.class);
         if(count>=1)
        	 return true;
         else return false;
		
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		// TODO Auto-generated method stub
		return false;
	}

}
