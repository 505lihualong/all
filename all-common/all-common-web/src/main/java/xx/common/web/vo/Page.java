package xx.common.web.vo;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页封装函数
 * 
 */
public class Page<E> implements Serializable {

	private static final long serialVersionUID = 4278444672724984873L;

	/**
	 * 总页数 这个数是计算出来的
	 * 
	 */
	private long tatolPage;

	/**
	 * 每页显示几条记录
	 */
	private int pageSize = 10;

	/**
	 * 当前页
	 * 默认 当前页 为第一页 这个数是计算出来的
	 */
	private int page = 1;
	
	private String sort;
	
	private String order;

	/**
	 * 总记录数
	 */
	private long total;

	/**
	 * 从第几条记录开始
	 */
	private int startPage;
	
	private Map<String, Object> params = new HashMap<String, Object>();// 其他的参数我们把它分装成一个Map对象
	/**
	 * 分页数据
	 */
	private List<E> rows;

	public Page() {
	}

	/**
	 * 要获得记录的开始索引 即 开始页码
	 * 
	 * @return
	 */
	public int getFirstResult() {
		return (this.page - 1) * this.pageSize;
	}

	

	/**
	 * 使用构造函数，，强制必需输入 每页显示数量 和 当前页
	 * 
	 * @param pageSize
	 *            每页显示数量
	 * @param pageNow
	 *            当前页
	 */
	public Page(int pageSize, int pageNow) {
		this.pageSize = pageSize;
		this.page = pageNow;
	}

	/**
	 * 使用构造函数，，强制必需输入 当前页
	 * 
	 * @param pageNow
	 *            当前页
	 */
	public Page(int pageNow) {
		this.page = pageNow;
		startPage = (this.page - 1) * this.pageSize;
	}

	/**
	 * 查询结果方法 把 记录数 结果集合 放入到 PageView对象
	 * 
	 * @param rowCount
	 *            总记录数
	 * @param records
	 *            结果集合
	 */

	public void setQueryResult(long rowCount, List<E> records) {
		setTatolPage(rowCount);
		setRows(records);
	}

	public List<E> getRows() {
		return rows;
	}

	public void setRows(List<E> rows) {
		this.rows = rows;
	}

	public long getTatolPage() {
		return tatolPage;
	}

	public void setTatolPage(long tatolPage) {
		this.tatolPage = tatolPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
		setTatolPage( this.total % this.pageSize == 0 ? this.total / this.pageSize : this.total / this.pageSize + 1);
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}


	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}


	@Override
	public String toString() {
		return "Page [tatolPage=" + tatolPage + ", pageSize=" + pageSize + ", page=" + page + ", sort=" + sort
				+ ", order=" + order + ", total=" + total + ", startPage=" + startPage + ", params=" + params
				+ ", rows=" + rows + "]";
	}

	
}