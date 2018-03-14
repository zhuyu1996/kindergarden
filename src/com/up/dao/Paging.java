package com.up.dao;

import java.util.List;

public class Paging<T> {
	//http://www.cnblogs.com/wlx520/archive/2015/07/31/4693016.html
		private int pageSize;  //分页数量  
		private int totalRecord;    //总共数据  
	    private int totalPage;     //总共页数 
	    private int currentPage;     //当前页数
	    private List<T> tlist;   //数据      
	    public int getPageSize() {
			return pageSize;
		}
		@Override
		public String toString() {
			return "Paging [pageSize=" + pageSize + ", totalRecord=" + totalRecord + ", totalPage=" + totalPage
					+ ", currentPage=" + currentPage + ", tlist=" + tlist + "]";
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		public int getTotalRecord() {
			return totalRecord;
		}
		public void setTotalRecord(int totalRecord) {
			this.totalRecord = totalRecord;
		}
		public int getTotalPage() {
			return totalPage;
		}
		public void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}
		public int getCurrentPage() {
			return currentPage;
		}
		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}
		public List<T> getTlist() {
			return tlist;
		}
		public void setTlist(List<T> tlist) {
			this.tlist = tlist;
		}

	    public Paging(int pageNum,int pageSize,List<T> tList){
//	    	System.out.println(" hahha"+tList.size());
	            //总记录数
	            this.totalRecord = tList.size();
	            //每页显示几条数据
	            this.pageSize = pageSize;
	     
	            //总页数
	           if(this.totalRecord % this.pageSize == 0)
	           	 { this.totalPage = this.totalRecord/this.pageSize;
	           	 this.currentPage=this.pageSize;}
	            else{ this.totalPage = this.totalRecord/this.pageSize+1;
	                  this.currentPage=this.totalRecord%this.pageSize;
	                }
	           this.tlist=tList;
	    }
	    
	    public int[] getMaindate(int pageNum,int pagesize){
	       	int param2=0;
	    	int param3=0;
	    	 if(pageNum==this.totalPage){
	    		param2=(pageNum-1)*pagesize;param3=this.currentPage;
	    	}else if(pageNum==1){
	    		param2=0;param3=pagesize;
	    	}
	    	else if(pageNum!=this.totalPage&&pageNum!=1){  
	    		param2=(pageNum-1)*pagesize;param3=pagesize;
	    	}
	    	int a[]={param2,param3};
	    	  return a;
	}
}
