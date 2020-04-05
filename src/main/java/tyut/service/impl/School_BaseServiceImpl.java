package tyut.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tyut.bean.Base;
import tyut.bean.School;
import tyut.bean.School_Base;
import tyut.dao.School_BaseDao;
import tyut.service.ISchool_BaseService;

@Service
public class School_BaseServiceImpl implements ISchool_BaseService{
	@Autowired
	private School_BaseDao school_BaseDao;
	
	@Override
	public void saveOrUpdate(School_Base school_base) throws Exception {
		// TODO Auto-generated method stub
		if(school_base!=null) {
			Integer id=school_base.getId();
			if(id==null) {
				school_BaseDao.save(school_base);
			}else {
				//update by id
				School_Base school_base_db=school_BaseDao.findById(id).get();
				School school=school_base.getSchool();
				Base base=school_base.getBase();
				String status=school_base.getStatus();
				if(school!=null) {
					school_base_db.setSchool(school);
				}
				if(base!=null) {
					school_base_db.setBase(base);
				}
				if(status!=null) {
					school_base_db.setStatus(status);
				}
				school_BaseDao.save(school_base_db);
			}
		}else {
			throw new Exception("参数为空");
		}
	}

	@Override
	public School_Base findById(int id) throws Exception {
		// TODO Auto-generated method stub
		Optional<School_Base> opt = school_BaseDao.findById(id);
		School_Base school_Base=opt.isPresent()?opt.get():null;
		if(school_Base!=null) {
			return school_Base;
		}else {
			throw new Exception("该id在数据库中不存在");
		}
	}

	@Override
	public List<School_Base> findAll() {
		// TODO Auto-generated method stub
		List<School_Base> all = school_BaseDao.findAll();
		return all;
	}

	@Override
	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		Optional<School_Base> opt = school_BaseDao.findById(id);
		School_Base school_Base=opt.isPresent()?opt.get():null;
		if(school_Base!=null) {
			school_BaseDao.deleteById(id);
		}else {
			throw new Exception("id在数据库中不存在");
		}
	}


	@Override
	public List<School_Base> findAllSchoolByBase (int base_id) {
		Base base=new Base();
		base.setId(base_id);
		List<School_Base> school = school_BaseDao.findByBase(base);
		return school;
		
	}


	@Override
	public List<School_Base> findAllBaseBySchool(int school_id) {
		School school=new School();
		school.setId(school_id);
		List<School_Base> bases = school_BaseDao.findBySchool(school);
		return bases;
	}

	
	

}
