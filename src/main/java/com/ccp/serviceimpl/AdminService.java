package com.ccp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ccp.entities.Admin;
import com.ccp.exceptions.NoAdminException;
import com.ccp.exceptions.UserAlreadyExistException;
import com.ccp.repositories.IAdminRepository;
import com.ccp.service.IAdminService;

@Service("adminServ")
public class AdminService implements IAdminService {
	@Autowired
	private IAdminRepository adminRepo;
	@Override
	public Admin addAdmin(Admin a) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedPassword = bcrypt.encode(a.getPassword());
		a.setPassword(encryptedPassword);
		Admin newAdmin = adminRepo.addAdmin(a);
		if (newAdmin != null) {
			throw new UserAlreadyExistException("User already exists sign in instead");
		} else {
			adminRepo.save(a);
			return a;

		}
	}

	@Override
	public Admin removeAdmin(long id) {
		 Optional<Admin> adminOp = adminRepo.findById(id);
		   if(adminOp.isPresent())
		   {
		adminRepo.removeAdmin(id);
		return adminOp.get();
		}
		else {
			throw new NoAdminException("No Admin with given id");
		}
	}

	@Override
	public Admin updateAdmin(long id, Admin a) {
		 Optional<Admin> adminOp = adminRepo.findById(id);
		   if(adminOp.isPresent())
		   {
			   adminRepo.updateAdmin(id, a);
				return a;
		   }
		   else {
			   throw new NoAdminException("Admin doesn't exist");
		   }
	}

	@Override
	public Admin getAdmin(long id) {
		
		if(adminRepo.getAdmin(id)==null)
		{
			throw new NoAdminException("Admin not found");
		}
		else
		{
			return adminRepo.getAdmin(id);
		}
	}

	@Override
	public List<Admin> getAllAdmins() {

		if(adminRepo.getAllAdmins().isEmpty())
		{
			throw new NoAdminException("Admin not found");
		}
		else
		{
			return adminRepo.getAllAdmins();
		}
	}


}