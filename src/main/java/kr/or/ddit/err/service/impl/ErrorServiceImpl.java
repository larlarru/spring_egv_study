package kr.or.ddit.err.service.impl;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.or.ddit.err.service.ErrorService;

@Service("errorService")
public class ErrorServiceImpl extends EgovAbstractServiceImpl implements ErrorService {

	@Override
	public void sendMail() {
		
		try {
			egovLogger.debug("메일 발송");
		} catch (Exception e) {
			egovLogger.error(e.getMessage(), e);
			leaveaTrace("info.nodata.msg");
		}
	}

	@Override
	public void saveDb() {
		
		try {
			egovLogger.debug("Db 저장");
		} catch (Exception e) {
			egovLogger.error(e.getMessage(), e);
			leaveaTrace("info.nodata.msg");
		}
	}

}
