package com.java.service;

import org.springframework.stereotype.Service;

import com.java.dto.ResultDTO;
import com.java.entity.Board;
import com.java.repository.BoardRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImp implements BoardService {
	
	private final BoardRepository boardRepo;
	private ResultDTO resultDTO;

	@Override
	public ResultDTO findList(String accept) {
		log.info("Accept : {}", accept);
		resultDTO = ResultDTO.builder().build();
		resultDTO.setStatus(true);
		resultDTO.setMessage("성공");
		if(accept != null) {
			resultDTO.setResult(boardRepo.findByAccept(("1".equals(accept)? true : false)));
		} else {
			resultDTO.setResult(boardRepo.findAll());
		}
		return resultDTO;
	}

	@Override
	public ResultDTO findOne(int no) {
		log.info("No : {}", no);
		resultDTO = ResultDTO.builder().build();
		resultDTO.setStatus(true);
		resultDTO.setMessage("성공");
		resultDTO.setResult(boardRepo.findById(no));
		return resultDTO;
	}

	@Transactional
	@Override
	public ResultDTO save(Board board) {
		resultDTO = ResultDTO.builder().build();
		resultDTO.setStatus(true);
		resultDTO.setMessage("성공");
		resultDTO.setResult(boardRepo.save(board));
		return resultDTO;
	}

	@Override
	public ResultDTO accept(int no, boolean accept) {
		log.info("No : {}, Accept : {}", no, accept);
		Board board = boardRepo.findById(no).orElseThrow();
		board.setAccept(accept);
		return save(board);
	}

}
