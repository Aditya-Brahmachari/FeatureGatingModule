package model;

import java.util.*;

public class User {
	
	Map<String, Object> userRoles;
	String name;
	String pwd;
	
	User(String name, String pwd)
	{
		this.name = name;
		this.pwd = pwd;
		userRoles = new HashMap<>();
	}

}
