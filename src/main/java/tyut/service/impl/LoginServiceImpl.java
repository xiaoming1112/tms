package tyut.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tyut.bean.Login;
import tyut.dao.LoginDao;
import tyut.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService {
	@Autowired
	private LoginDao loginDao;

	@Override
	public void saveOrUpdate(Login login) throws Exception {
		// TODO Auto-generated method stub
		if (login != null) {
			Integer id = login.getId();
			if (id == null) {
				loginDao.save(login);
			} else {
				// update by id
				Login login_db = loginDao.findById(id).get();
				String username = login.getUsername();
				String password = login.getPassword();
				String status = login.getStatus();
				String role = login.getRole();
				if (username != null) {
					login_db.setUsername(username);
				}
				if (password != null) {
					login_db.setPassword(password);
				}
				if (status != null) {
					login_db.setStatus(status);
				}
				if (role != null) {
					login_db.setRole(role);
				}
				loginDao.save(login_db);
			}
		} else {
			throw new Exception("参数为空");
		}
	}

	@Override
	public Login findById(int id) throws Exception {
		Optional<Login> opt = loginDao.findById(id);
		Login login = opt.isPresent() ? opt.get() : null;
		if (login != null) {
			return login;
		} else {
			throw new Exception("该id在数据库中不存在");
		}
	}

	@Override
	public Login isRealUser(Login login) throws Exception {
		// TODO Auto-generated method stub
		if ((login != null) && (login.getUsername() != null) && (login.getPassword() != null)) {
			Login login_db = loginDao.findByUsernameAndPassword(login.getUsername(), login.getPassword());
			if (login_db != null) {
				return login_db;
			} else {
				throw new Exception("请输入正确的用户名密码");
			}

		} else {
			throw new Exception("请输入用户名密码");
		}
	}

	@Override
	public List<Login> findAll() {
		List<Login> all = loginDao.findAll();
		return all;
	}

	@Override
	public List<Login> findByUsername(String username) {
		// TODO Auto-generated method stub
		List<Login> all = loginDao.findByUsernameLike("%" + username + "%");
		return all;
	}

	@Override
	public List<Login> findByStatus(String status) {
		// TODO Auto-generated method stub
		List<Login> all = loginDao.findByStatusLike("%" + status + "%");
		return all;
	}

}
