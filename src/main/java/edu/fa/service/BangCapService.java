package edu.fa.service;

import org.springframework.stereotype.Service;

import edu.fa.model.BangCap;

@Service
public interface BangCapService {
	void themBangCap(BangCap bangCap);
	void updateBangCap(BangCap bangCap);
}
