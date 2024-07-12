package com.java.service;

import com.java.dto.ResultDTO;
import com.java.entity.Board;

public interface BoardService {
	
	public ResultDTO findList(String accept);
	public ResultDTO findOne(int no);
	public ResultDTO save(Board board);
	public ResultDTO accept(int no, boolean accept);

}
