package com.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.ResultDTO;
import com.java.entity.Board;
import com.java.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Board")
public class BoardController {
	
	private final BoardService boardService;

	@GetMapping(value= {"/findList", "/findList/{accept:[0-1]}"})
	public ResultDTO findList(@PathVariable(name = "accept", required = false) String accept) {
		return boardService.findList(accept);
	}
	
	@GetMapping("/detail/{no:[0-9]+}")
	public ResultDTO findOne(@PathVariable("no") int no) {
		return boardService.findOne(no);
	}
	
	@GetMapping("/save/{no:[0-9]+}/{accept:[0-1]}")
	public ResultDTO save(@PathVariable("no") int no, @PathVariable("accept") boolean accept) {
		return boardService.accept(no, accept);
	}
	
	@PostMapping("/save")
	public ResultDTO save(@ModelAttribute Board board) {
		return boardService.save(board);
	}
	
}
