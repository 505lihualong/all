package xx.all.auth.model;

import java.io.Serializable;


/**
 * 
 * @ClassName: SysRole 
 * @Description: 角色
 * @author Dragon Li 
 * @date 2018年5月25日 上午9:14:01 
 *
 */
public class SysRole implements Serializable {
	/**
	 * 串行化版本统一标识符
	 */
	private static final long serialVersionUID = -6955545706315574169L;

	/**
	 * 主键ID
	 */
	private String id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 状态 1-删除 0-锁定 1-正常
	 */
	private int status;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
