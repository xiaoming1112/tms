package tyut.service;



import java.util.List;


import tyut.bean.Adminuser;
import tyut.bean.Base;
import tyut.bean.Login;
import tyut.bean.School;

public interface IAdminuserService {
	public void saveOrUpdate(Adminuser adminuser)throws Exception;
	public Adminuser findById(int id)throws Exception;
	public Adminuser findByLogin(Login login)throws Exception;
	public List<Adminuser> findBySchool(School school);
	public List<Adminuser> findByBase(Base base);
	public List<Adminuser> findByStatus(String status);
	public List<Adminuser> findAll();
	public void deleteById(int id)throws Exception;
}
