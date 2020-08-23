package dao;

import model.Skill;

public interface CrudDaoInterface {
	public void addSkill(Skill skill);
	public void delete(int id);
	public void update(Skill skill);
	public void display();
	
	

}
