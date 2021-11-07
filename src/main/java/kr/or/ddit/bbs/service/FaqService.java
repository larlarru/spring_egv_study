package kr.or.ddit.bbs.service;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;

public interface FaqService {
	
	public String getName() throws Exception;
	
	public String getTitle() throws EgovBizException;
	
}
