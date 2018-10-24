package org.binmon.demo.topic;

public class Topic {
	
	private String deptId;
	private String name;
	private String description;
	
	
	public Topic() {
	}

	public Topic(String id, String name, String description) {
		super();
		this.deptId = id;
		this.name = name;
		this.description = description;
	}
	
	public String getId() {
		return deptId;
	}
	public void setId(String id) {
		this.deptId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
