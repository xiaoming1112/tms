package tyut.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Service;

import io.swagger.annotations.ApiModelProperty;
import tyut.bean.Adminuser;
import tyut.bean.Base;
import tyut.bean.Login;
import tyut.bean.School;
import tyut.dao.AdminuserDao;
import tyut.service.IAdminuserService;
@Service
public class AdminuserServiceImpl implements IAdminuserService {

	@Autowired
	private AdminuserDao adminuserDao;
	@Override
	public void saveOrUpdate(Adminuser adminuser) throws Exception {
		// TODO Auto-generated method stub
		if(adminuser!=null) {
			Integer id=adminuser.getId();
			if(id==null) {
				adminuserDao.save(adminuser);
			}else {
				Adminuser adminuser_db=adminuserDao.findById(id).get();
				Integer  name=adminuser_db.getName();
				String phone=adminuser_db.getPhone();
				String status=adminuser_db.getStatus();
				Integer newadmin_role=adminuser_db.getNewadmin_role();
				Integer base_role=adminuser_db.getBase_role();
				Integer message_role=adminuser_db.getMessage_role();
				Integer student_role=adminuser_db.getStudent_role();
				Integer teaching_role=adminuser_db.getTeaching_role();
				Integer steacher_role=adminuser_db.getSteacher_role();
				Integer studenthost_role=adminuser_db.getStudenthost_role();
				if(name!=null) {
					adminuser_db.setName(name);
				}
				if(phone!=null) {
					adminuser_db.setPhone(phone);
				}
				if(status!=null) {
					adminuser_db.setStatus(status);
				}
				if(newadmin_role!=null) {
					adminuser_db.setNewadmin_role(newadmin_role);
				}
				if(base_role!=null) {
					adminuser_db.setBase_role(base_role);
				}
				if(message_role!=null) {
					adminuser_db.setMessage_role(message_role);
				}
				if(student_role!=null) {
					adminuser_db.setStudent_role(student_role);
				}
				if(teaching_role!=null) {
					adminuser_db.setTeaching_role(teaching_role);
				}
				if(steacher_role!=null) {
					adminuser_db.setSteacher_role(steacher_role);
				}
				if(studenthost_role!=null) {
					adminuser_db.setStudenthost_role(studenthost_role);
				}
				adminuserDao.save(adminuser_db);
			}
		}else {
			throw new Exception("参数为空");
		}
	}

	@Override
	public Adminuser findById(int id) throws Exception {
		Optional<Adminuser> opt = adminuserDao.findById(id);
		Adminuser adminuser=opt.isPresent()?opt.get():null;
		if(adminuser!=null) {
			return adminuser;
		}else {
			throw new Exception("该id在数据库中不存在");
		}
	}

	@Override
	public Adminuser findByLogin(Login login) throws Exception {
		// TODO Auto-generated method stub
		Adminuser adminuser = adminuserDao.findByLogin(login);
		if(adminuser!=null) {
			return adminuser;
		}else {
			throw new Exception("该id在数据库中不存在");
		}
	}

	@Override
	public List<Adminuser> findBySchool(School school){
		// TODO Auto-generated method stub
		List<Adminuser> list = adminuserDao.findBySchool(school);
		return list;
	}

	@Override
	public List<Adminuser> findByBase(Base base){
		// TODO Auto-generated method stub
		List<Adminuser> list = adminuserDao.findByBase(base);
		return list;
	}

	@Override
	public List<Adminuser> findByStatus(String status) {
		// TODO Auto-generated method stub
		List<Adminuser> list = adminuserDao.findByStatus(status);
		return list;
	}

	@Override
	public List<Adminuser> findAll() {
		// TODO Auto-generated method stub
		List<Adminuser> list = adminuserDao.findAll();
		return list;
	}

	@Override
	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Adminuser> optional = adminuserDao.findById(id);
		Adminuser adminuser=optional.isPresent()?optional.get():null;
		if(adminuser!=null) {
			adminuserDao.deleteById(id);
		}else {
			throw new Exception("该id在数据库中不存在");
		}
	}

}
