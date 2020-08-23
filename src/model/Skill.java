package model;

public class Skill {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Skill(int id2, String name) {
		super();
		this.id = id2;
		this.name = name;
	}
	public Skill()
	{
		
	}

}
