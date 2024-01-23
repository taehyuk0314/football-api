package com.football.api.common.aspect.vo;


import java.util.List;

import com.football.api.common.vo.CommonVO;
import com.github.pagehelper.Page;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * boot strap data table pagination 호환 result ovo
 * @author gbun
 *
 * @param <E>
 */
@Data
public class DataTableOVO<E> {
	List<E> items;
	long recordsTotal;
	long pageNum;
	
	public DataTableOVO(Page<E> page) {
		this.items = page.getResult();
		this.recordsTotal = page.getTotal();
		this.pageNum = page.getPageNum();
	}
}
