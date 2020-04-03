package tyut.service;



import java.util.List;

import tyut.bean.School_Base;

public interface ISchool_BaseService {
	public void saveOrUpdate(School_Base school_Base)throws Exception;
	public School_Base findById(int id)throws Exception;
	public List<School_Base> findAll();
	public void deleteById(int id)throws Exception;
	
	public List<School_Base> findAllSchoolByBase(int base_id);
	public List<School_Base> findAllBaseBySchool(int school_id);
}
