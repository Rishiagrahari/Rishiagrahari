package com.ccp.service;

import java.util.List;

import com.ccp.entities.Admin;

public interface IAdminService {

	public Admin addAdmin(Admin a);

	public Admin removeAdmin(long id);

	public Admin updateAdmin(long id, Admin a);

	public Admin getAdmin(long id);

	public List<Admin> getAllAdmins();

}
