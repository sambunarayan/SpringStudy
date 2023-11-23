package jp.co.jeus.spring_study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Result {
	private int left = 0;
	private int right = 0;
	private long answer = 0L;
	
	public Result(int left, int right, long answer) {
		this.left = left;
		this.right = right;
		this.answer = answer;
	}
}