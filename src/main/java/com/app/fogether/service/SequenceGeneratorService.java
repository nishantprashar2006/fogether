package com.app.fogether.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.fogether.domain.DatabaseSequence;
import com.app.fogether.repository.SequenceGeneratorRepository;

@Service
public class SequenceGeneratorService {

	@Autowired
	private SequenceGeneratorRepository sequenceGeneratorRepo;

	public Long generateSequence(String seqName) {

		Optional<DatabaseSequence> ds = sequenceGeneratorRepo.findById(seqName);
		Long newSeq = 10000L;
		if (!ds.isPresent()) {
			DatabaseSequence initialds = new DatabaseSequence();
			initialds.setId(seqName);
			initialds.setSeq(newSeq);
			sequenceGeneratorRepo.save(initialds);
		} else {
			Long seq = ds.get().getSeq();
			newSeq = seq + 1L;
			ds.get().setSeq(newSeq);
			sequenceGeneratorRepo.save(ds.get());
		}
		return newSeq;
	}
}
