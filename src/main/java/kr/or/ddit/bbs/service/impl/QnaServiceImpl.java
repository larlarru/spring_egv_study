package kr.or.ddit.bbs.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import kr.or.ddit.bbs.service.BbsService;
import kr.or.ddit.bbs.service.FaqService;
import kr.or.ddit.sample.service.SampleDefaultVO;
import kr.or.ddit.sample.service.SampleVO;

@Service("qnaService")
public class QnaServiceImpl implements FaqService, BbsService {

	@Override
	public String getName() throws EgovBizException {
		return "qna";
	}

	@Override
	public String getTitle() throws EgovBizException {
		return "질의응답";
	}

	@Override
	public List getList(SampleDefaultVO searchVO) throws EgovBizException {
		return null;
	}

}
