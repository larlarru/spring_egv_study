package kr.or.ddit.bbs.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import kr.or.ddit.bbs.service.BbsService;
import kr.or.ddit.bbs.service.FaqService;
import kr.or.ddit.sample.service.SampleDefaultVO;

@Controller
@RequestMapping(value = {"/test", "/test2"})
public class BbsController {
	
//	@Autowired // 같은녀석 찾아서 주입
//	@Resource(name="bbsService")
//	private BbsService bbsService;
	
//	@Resource(name="bbsService")
	@Autowired
	@Qualifier(value = "qnaService")
	private FaqService faqService; //이렇게 소스처리한게 성능은 가장 빠르다.
	
	@Autowired
	@Qualifier(value = "bbsService")
	private BbsService qnaService;
	
	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	// url / test/test.do
//	@RequestMapping(value = {"/test.do" , "/test2.do"}, method = RequestMethod.POST)
	@GetMapping(value = {"/test.do" , "/test2.do"})
//	@PostMapping(value = {"/test.do" , "/test2.do"})
//	@PutMapping
//	@DeleteMapping
	public String selectList(@ModelAttribute("searchVO") SampleDefaultVO searchVO,
			ModelMap model ,
			@RequestParam Map params) throws EgovBizException , Exception {
		
		
		/** EgovPropertyService.sample */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List result = qnaService.getList(searchVO);
		
//		System.out.println(bbsService.getTitle());
//		System.out.println(faqService.getName());
//		System.out.println(faqService.getTitle());
		
//		System.out.println(qnaService.getName());
//		System.out.println(qnaService.getTitle());
		
		model.addAttribute("resultList", result);
		
		paginationInfo.setTotalRecordCount(100);
		model.addAttribute("paginationInfo", paginationInfo);
		
		return "test";
	}

}
