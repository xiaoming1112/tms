package tyut.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tyut.bean.School;
import tyut.dao.SchoolDao;
import tyut.service.ISchoolService;




@Service
public class SchoolServiceImpl implements ISchoolService{
	@Autowired
	private SchoolDao schoolDao;

	@Override
	public void saveOrUpdate(School school) throws Exception {
		// TODO Auto-generated method stub
		if(school!=null) {
			Integer id=school.getId();
			if(id==null) {
				schoolDao.save(school);
			}else {
				//update by id
				School school_db=schoolDao.findById(id).get();
				String name=school.getName();
				String address=school.getAddress();
				String phone=school.getPhone();
				String content=school.getContent();
				String web=school.getWeb();
				if(name!=null) {
					school_db.setName(name);
				}
				if(address!=null) {
					school_db.setAddress(address);
				}
				if(phone!=null) {
					school_db.setPhone(phone);
				}
				if(content!=null) {
					school_db.setContent(content);
				}
				if(web!=null) {
					school_db.setWeb(web);
				}
				schoolDao.save(school_db);
			}
		}else {
			throw new Exception("参数为空");
		}
	}

	@Override
	public School findById(int id) throws Exception {
		// TODO Auto-generated method stub
		Optional<School> opt = schoolDao.findById(id);
		School school=opt.isPresent()?opt.get():null;
		if(school!=null) {
			return school;
		}else {
			throw new Exception("该id在数据库中不存在");
		}
	}

	@Override
	public List<School> findAll() {
		// TODO Auto-generated method stub
		List<School> all = schoolDao.findAll();
		return all;
	}

	@Override
	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		Optional<School> opt = schoolDao.findById(id);
		School school=opt.isPresent()?opt.get():null;
		if(school!=null) {
			schoolDao.deleteById(id);
		}else {
			throw new Exception("id在数据库中不存在");
		}
	}

	@Override
	public List<School> findByName(String name){
		// TODO Auto-generated method stub
		List<School> all=schoolDao.findByNameLike("%"+name+"%");
		return all;
	}

	
	

}
