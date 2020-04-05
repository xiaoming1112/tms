package tyut.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tyut.bean.Base;
import tyut.bean.Login;
import tyut.bean.School;
import tyut.bean.Teacher;
import tyut.dao.LoginDao;
import tyut.dao.TeacherDao;
import tyut.service.ITeacherService;

@Service
public class TeacherServiceImpl implements ITeacherService {

	@Autowired
	private TeacherDao teacherDao;
	@Autowired
	private LoginDao loginDao;

	@Override
	public void saveOrUpdate(Teacher teacher) throws Exception {
		// TODO Auto-generated method stub
		if (teacher != null) {
			Integer id = teacher.getId();
			if (id == null) {
				Login login = new Login();
				login.setUsername(teacher.getLogin().getUsername());
				login.setPassword(teacher.getLogin().getPassword());
				login.setStatus(teacher.getLogin().getStatus());
				login.setRole(teacher.getLogin().getRole());
				loginDao.save(login);
				teacher.setLogin(login);
				teacherDao.save(teacher);
			} else {
				Teacher teacher_db = teacherDao.findById(id).get();
				String name = teacher_db.getName();
				String gender = teacher_db.getGender();
				String phone = teacher_db.getPhone();
				String content = teacher_db.getContent();
				String status = teacher_db.getstatus();
				if (name != null) {
					teacher_db.setName(name);
				}
				if (gender != null) {
					teacher_db.setGender(gender);
				}
				if (phone != null) {
					teacher_db.setPhone(phone);
				}
				if (content != null) {
					teacher_db.setContent(content);
				}
				if (status != null) {
					teacher_db.setstatus(status);
				}

				teacherDao.save(teacher_db);
			}
		} else {
			throw new Exception("参数为空");
		}

	}

	@Override
	public Teacher findById(int id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Teacher> optional = teacherDao.findById(id);
		Teacher teacher = optional.isPresent() ? optional.get() : null;
		if (teacher != null) {
			return teacher;
		} else {
			throw new Exception("该id在数据库中不存在");
		}
	}

	@Override
	public Teacher findByLogin(Login login) throws Exception {
		// TODO Auto-generated method stub
		Teacher teacher = teacherDao.findByLogin(login);
		if (teacher != null) {
			return teacher;
		} else {
			throw new Exception("该id在数据库中不存在");
		}
	}

	@Override
	public List<Teacher> findBySchool(School school) {
		// TODO Auto-generated method stub
		List<Teacher> list = teacherDao.findBySchool(school);
		return list;
	}

	@Override
	public List<Teacher> findByBase(Base base) {
		// TODO Auto-generated method stub
		List<Teacher> list = teacherDao.findByBase(base);
		return list;
	}

	@Override
	public List<Teacher> findByStatus(String status) {
		// TODO Auto-generated method stub
		List<Teacher> list = teacherDao.findByStatus(status);
		return list;
	}

	@Override
	public List<Teacher> findAll() {
		// TODO Auto-generated method stub
		List<Teacher> list = teacherDao.findAll();
		return list;
	}

	@Override
	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Teacher> optional = teacherDao.findById(id);
		Teacher teacher = optional.isPresent() ? optional.get() : null;
		if (teacher != null) {
			Login login = loginDao.findById(teacher.getLogin().getId()).get();
			loginDao.deleteById(login.getId());
		} else {
			throw new Exception("该id在数据库中不存在");
		}
	}

	@Override
	public List<Teacher> findByName(String name) {
		// TODO Auto-generated method stub
		List<Teacher> list = teacherDao.findByNameLike("%" + name + "%");
		return list;
	}

}
