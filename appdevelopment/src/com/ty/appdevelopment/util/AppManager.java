package com.ty.appdevelopment.util;

import com.ty.appdevelopment.dao.AppDAO;
import com.ty.appdevelopment.dao.AppDAOImpl;

public class AppManager {

	private AppManager() {}
	
	public static AppDAO getAppDAO() {
		return new AppDAOImpl();
	}
}
