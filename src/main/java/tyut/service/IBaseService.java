package tyut.service;

import java.util.List;

import tyut.bean.Base;

public interface IBaseService {
	public void saveOrUpdate(Base base) throws Exception;

	public Base findById(int id) throws Exception;

	public List<Base> findAll();

	public void deleteById(int id) throws Exception;

	public List<Base> findByName(String name);
}
