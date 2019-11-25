package com.ty.appdevelopment.dao;

import java.util.List;

import com.ty.appdevelopment.dto.AppBean;

public interface AppDAO {

	public List<AppBean> getAllContactData();
	public AppBean searchContact(String name);
	public int add(AppBean bean);
	public int delete(String name);
	public int update(AppBean bean);
	public void mainmanu();
}
