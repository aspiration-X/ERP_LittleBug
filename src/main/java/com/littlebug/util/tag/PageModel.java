package com.littlebug.util.tag;


import com.littlebug.util.common.ERPConstants;

import java.util.List;

/**
 *  分页实体 
 */
public class PageModel<T> {
	/** 分页总数据条数  */
	private int recordCount;
	/** 当前页面 */
	private int pageIndex ;
	/** 每页分多少条数据   */
	private int pageSize = ERPConstants.PAGE_DEFAULT_SIZE = 4;
	
	/** 总页数  */
	private int totalSize;

	/** 每页数据 */
    private List<T> lists;


    public int getRecordCount() {
		this.recordCount = this.recordCount <= 0 ? 0:this.recordCount;
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getPageIndex() {
		this.pageIndex = this.pageIndex <= 0?1:this.pageIndex;
		/** 判断当前页面是否超过了总页数:如果超过了默认给最后一页作为当前页  */
		this.pageIndex = this.pageIndex>=this.getTotalSize()?this.getTotalSize():this.pageIndex;
		
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		this.pageSize = this.pageSize <= ERPConstants.PAGE_DEFAULT_SIZE? ERPConstants.PAGE_DEFAULT_SIZE:this.pageSize;
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getTotalSize() {
		if(this.getRecordCount() <=0){
			totalSize = 0 ;
		}else{
			totalSize = (this.getRecordCount() -1)/this.getPageSize() + 1;
		}
		return totalSize;
	}
	
	
	public int getFirstLimitParam(){
		return (this.getPageIndex()-1)*this.getPageSize() ;
	}

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }
}
