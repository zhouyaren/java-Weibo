package com.jaxu.utils;

import java.util.List;

public class Page {

	//��ҳ��
		private int pageCount = 0;
		
		//ҳ��(��ǰҳ)
		private int pageNo = 1;
		
		//��ҳ
		private int firstPage = 1;
		
		//βҳ
		private int lastPage = 1;
		
		//��һҳ
		private int prePage = 1;
		
		//��һҳ
		private int nextPage = 1;
		
		//������
		private int rowCount = 1;
		
		//�����
		private List<?> resultList;
		
		//��������ʼλ��
		private int startIndex = 1;
		
		//�����Ľ���λ��
		private int endIndex = 1;
		
		//ÿҳ��ʾ������
		private int pageSize = 1;
		
		public Page(int pageNo, int pageSize) {
			this.pageNo = pageNo;
			this.pageSize = pageSize;
			this.startIndex = pageSize * (pageNo - 1);
			this.endIndex = pageNo * pageSize;
		}
		
		/**
		 * ��������
		 * @author yup
		 *
		 * @param resultList
		 * @param rowCount
		 * 2017��6��8��
		 */
		public void setResult(List<?> resultList, int rowCount) {
			this.resultList = resultList;
			this.rowCount = rowCount;
			
			//��ҳ��
			if(rowCount % pageSize == 0) {
				pageCount = rowCount / pageSize;
			}else {
				pageCount = (rowCount / pageSize) + 1;
			}
			
			//βҳ
			lastPage =  pageCount;
			
			//��һҳ
			if(pageNo > 1) {
				prePage = pageNo - 1;
			}
			
			//��һҳ
			if(pageNo < lastPage) {
				nextPage = pageNo + 1;
			}else {
				nextPage = lastPage;
			}
		}

		public int getPageCount() {
			return pageCount;
		}

		public void setPageCount(int pageCount) {
			this.pageCount = pageCount;
		}

		public int getPageNo() {
			return pageNo;
		}

		public void setPageNo(int pageNo) {
			this.pageNo = pageNo;
		}

		public int getFirstPage() {
			return firstPage;
		}

		public void setFirstPage(int firstPage) {
			this.firstPage = firstPage;
		}

		public int getLastPage() {
			return lastPage;
		}

		public void setLastPage(int lastPage) {
			this.lastPage = lastPage;
		}

		public int getPrePage() {
			return prePage;
		}

		public void setPrePage(int prePage) {
			this.prePage = prePage;
		}

		public int getNextPage() {
			return nextPage;
		}

		public void setNextPage(int nextPage) {
			this.nextPage = nextPage;
		}

		public int getRowCount() {
			return rowCount;
		}

		public void setRowCount(int rowCount) {
			this.rowCount = rowCount;
		}

		public List<?> getResultList() {
			return resultList;
		}

		public void setResultList(List<?> resultList) {
			this.resultList = resultList;
		}

		public int getStartIndex() {
			return startIndex;
		}

		public void setStartIndex(int startIndex) {
			this.startIndex = startIndex;
		}

		public int getEndIndex() {
			return endIndex;
		}

		public void setEndIndex(int endIndex) {
			this.endIndex = endIndex;
		}

		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
	
}
