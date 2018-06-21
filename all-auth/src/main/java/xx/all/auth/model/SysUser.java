package xx.all.auth.model;

import java.io.Serializable;
import java.util.Set;

/**
 * 用户
 * @ClassName: SysUser 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Dragon Li 
 * @date 2018年5月25日 上午9:14:27 
 *
 */
public class SysUser implements Serializable {

	private static final long serialVersionUID = -4211673833443687592L;
	/**
	 * 主键ID
	 */
	private String id;
	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 状态 1-删除 0-锁定 1-正常
	 */
	private int status;
	/**
	 * 密码
	 */
	private String password;

	/**
	 * 随机盐
	 */
	private String salt;

	/**
	 * 手机号码
	 */
	private String phone;

	/**
	 * 部门ID
	 */
	private Integer deptId;
	/**
	 * 部门名称
	 */
	private String deptName;

	/**
	 * 角色列表
	 */
	private Set<SysRole> roleSet;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	
	public Set<SysRole> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<SysRole> roleSet) {
		this.roleSet = roleSet;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
