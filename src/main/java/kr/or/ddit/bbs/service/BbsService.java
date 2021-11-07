package kr.or.ddit.bbs.service;


import java.util.List;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import kr.or.ddit.sample.service.SampleDefaultVO;
import kr.or.ddit.sample.service.SampleVO;

public interface BbsService {

	public String getTitle() throws EgovBizException;
	
	public List getList(SampleDefaultVO searchVO) throws Exception;
}
