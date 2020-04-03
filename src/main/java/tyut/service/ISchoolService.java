package tyut.service;



import java.util.List;

import tyut.bean.School;

public interface ISchoolService {
	public void saveOrUpdate(School school)throws Exception;
	public School findById(int id)throws Exception;
	public List<School> findAll();
	public void deleteById(int id)throws Exception;
	public List<School> findByName(String name);
}
