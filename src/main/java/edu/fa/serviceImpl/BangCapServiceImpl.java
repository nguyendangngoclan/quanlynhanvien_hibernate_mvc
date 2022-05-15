package edu.fa.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fa.model.BangCap;
import edu.fa.repository.BangCapRepository;
import edu.fa.service.BangCapService;

@Service
public class BangCapServiceImpl implements BangCapService {

	@Autowired
	private BangCapRepository bangCapRepository;

	public void themBangCap(BangCap bangCap) {
		bangCapRepository.themBangCap(bangCap);

	}

	public void updateBangCap(BangCap bangCap) {
		bangCapRepository.updateBangCap(bangCap);

	}

}
