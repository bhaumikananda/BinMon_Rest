package org.binmon.demo.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dept {

    @Id
	private String deptId;
    private String deptName;
    private String deptHead;
	
    public Dept() {
	}

	public Dept(String deptId, String deptName, String deptHead) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptHead = deptHead;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptHead=" + deptHead + "]";
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptHead() {
		return deptHead;
	}

	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptId == null) ? 0 : deptId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dept other = (Dept) obj;
		if (deptId == null) {
			if (other.deptId != null)
				return false;
		} else if (!deptId.equals(other.deptId))
			return false;
		return true;
	}

    
}
