package kr.or.ddit.bbs.service.impl;


import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.ProcessingException;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import kr.or.ddit.bbs.service.BbsService;
import kr.or.ddit.bbs.service.FaqService;
import kr.or.ddit.sample.service.SampleDefaultVO;
import kr.or.ddit.sample.service.SampleVO;
import kr.or.ddit.sample.service.impl.SampleDAO;
import kr.or.ddit.sample.service.impl.SampleMapper;

//@Service // 이름을 지정하지 않는 경우 BbsService 이름으로 IOC 컨테이너에 생성
@Service("bbsService")
public class BbsServiceImpl extends EgovAbstractServiceImpl implements BbsService , FaqService {
	
	@Resource(name="sampleMapper")
	private SampleMapper sampleDAO;

	/** ID Generation */
	@Resource(name = "egovIdGnrService")
	private EgovIdGnrService egovIdGnrService;
	
	@Override
	public String getTitle() throws EgovBizException {
		
		egovLogger.debug("실행 클래스 : {}", this.getClass().getCanonicalName());
		
		boolean test = false;
		
		if (test) { 
		} else {
			throw new EgovBizException("에러 발생...");
		}
		
		return "test";
	}

	@Override
	public String getName() throws Exception {
		
		egovLogger.debug("실행 클래스 : {}", this.getClass().getCanonicalName());
		

		boolean test = false;
		
		if (test) { 
		} else {
			// EgovAbstractServiceImpl 제공하는 다국어 에러 메시지 처리 하는 기능
			throw processException("fail.common.sql", new String[] {"bbs", "bbs 정보등록"});
		}
		
		return "testName";
	}


	@Override
	public List getList(SampleDefaultVO searchVO) throws Exception {
		List<SampleVO> result = (List<SampleVO>) sampleDAO.selectSampleList(searchVO);
		
		for (SampleVO sampleVO : result) {
			String idgen = egovIdGnrService.getNextStringId();
			
			egovLogger.debug("as-is : {}, to-be : {}", sampleVO.getId(), idgen);
			sampleVO.setId(idgen);
			sampleVO.setDescription(sampleVO.getDescription()+idgen);
			egovLogger.debug("sampleVO : {}", sampleVO);
		}
		
		egovLogger.debug("result : {}", result);
		
		return result;
	}
	
}
