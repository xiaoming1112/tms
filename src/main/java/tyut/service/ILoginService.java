package tyut.service;

import java.util.List;

import tyut.bean.Login;

public interface ILoginService {
	public void saveOrUpdate(Login login) throws Exception;
	public Boolean IsexactUsername(String userName);
	public Login findById(int id) throws Exception;

	public List<Login> findByUsername(String username);

	public List<Login> findByStatus(String status);

	public List<Login> findAll();

	public Login isRealUser(Login login) throws Exception;
}
