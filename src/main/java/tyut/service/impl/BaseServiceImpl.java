package tyut.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tyut.bean.Base;
import tyut.dao.BaseDao;
import tyut.service.IBaseService;

@Service
public class BaseServiceImpl implements IBaseService{
	@Autowired
	private BaseDao baseDao;

	@Override
	public void saveOrUpdate(Base base) throws Exception {
		// TODO Auto-generated method stub
		if(base!=null) {
			Integer id=base.getId();
			if(id==null) {
				baseDao.save(base);
			}else {
				//update by id
				Base base_db=baseDao.findById(id).get();
				String name=base.getName();
				String address=base.getAddress();
				String phone=base.getPhone();
				String content=base.getContent();
				String web=base.getWeb();
				if(name!=null) {
					base_db.setName(name);
				}
				if(address!=null) {
					base_db.setAddress(address);
				}
				if(phone!=null) {
					base_db.setPhone(phone);
				}
				if(content!=null) {
					base_db.setContent(content);
				}
				if(web!=null) {
					base_db.setWeb(web);
				}
				baseDao.save(base_db);
			}
		}else {
			throw new Exception("参数为空");
		}
	}

	@Override
	public Base findById(int id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Base> opt = baseDao.findById(id);
		Base base=opt.isPresent()?opt.get():null;
		if(base!=null) {
			return base;
		}else {
			throw new Exception("该id在数据库中不存在");
		}
	}

	@Override
	public List<Base> findAll() {
		// TODO Auto-generated method stub
		List<Base> all = baseDao.findAll();
		return all;
	}

	@Override
	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Base> opt = baseDao.findById(id);
		Base base=opt.isPresent()?opt.get():null;
		if(base!=null) {
			baseDao.deleteById(id);
		}else {
			throw new Exception("id在数据库中不存在");
		}
	}

	@Override
	public List<Base> findByName(String name){
		// TODO Auto-generated method stub
		List<Base> all=baseDao.findByNameLike("%"+name+"%");
		return all;
	}
	
	

}
