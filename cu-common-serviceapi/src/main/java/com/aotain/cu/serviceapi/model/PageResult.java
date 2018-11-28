package com.aotain.cu.serviceapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageResult<T extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	private long total;
	private List<T> rows = new ArrayList<T>();

	public PageResult() {
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	
}
