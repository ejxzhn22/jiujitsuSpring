package com.sujin.spring.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.sujin.spring.service.MemberService;
import com.sujin.spring.vo.Member;

@Controller
public class LoginController {
	@Inject
	private MemberService memberService;
	private KakaoLoginApi kakaoLoginApi;
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	
	@Autowired
	public void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}
	
	@Autowired
	public void setNaverLoginBO(KakaoLoginApi kakaoLoginApi) {
		this.kakaoLoginApi = kakaoLoginApi;
	}
	
	//로그인 첫 화면 요청 메소드
    @RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
    public String login(Model model, HttpSession session) {
    	
    	//네이버 로그인
        /* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
        //네이버 
        model.addAttribute("url", naverAuthUrl);
        
        //카카오 로그인
        String kakaoUrl = kakaoLoginApi.getAuthorizationUrl(session);
        
        /* 생성한 인증 URL을 View로 전달 */
        model.addAttribute("kakao_url", kakaoUrl);
 
        /* 생성한 인증 URL을 View로 전달 */
        return "login";
    }
    
    //기본 로그인
    @RequestMapping(value="/commonlogin", method=RequestMethod.POST)
    public String login(Model model, Member member, HttpSession session) {
    	Boolean bl = memberService.login(member);
    	
    	if( bl == true) {
    		session.setAttribute("sessionId", member.getMb_id());
    		
    		return "redirect:/";
    	}else {
    		model.addAttribute("msg", "비밀번호 다름");
			return "alert";
    	}
    }
 
    //네이버 로그인 성공시 callback호출 메소드
    @RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
    public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
            throws IOException, ParseException {
        System.out.println("여기는 callback");
        OAuth2AccessToken oauthToken;
        oauthToken = naverLoginBO.getAccessToken(session, code, state);
      //1. 로그인 사용자 정보를 읽어온다.
        apiResult = naverLoginBO.getUserProfile(oauthToken); //String형식의 json데이터
        /** apiResult json 구조
        {"resultcode":"00",
        "message":"success",
        "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
        **/
        //2. String형식인 apiResult를 json형태로 바꿈
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(apiResult);
        JSONObject jsonObj = (JSONObject) obj;
        //3. 데이터 파싱
        //Top레벨 단계 _response 파싱
        JSONObject response_obj = (JSONObject)jsonObj.get("response");
        //response의 nickname값 파싱
        String name = (String)response_obj.get("name");
        String id = (String)response_obj.get("id");
        String email = (String)response_obj.get("email");
        String nickname = (String)response_obj.get("nickname");
        System.out.println(name);
        //4.파싱 닉네임 세션으로 저장
        session.setAttribute("sessionId",id); //세션 생성
        session.setAttribute("sessionName",name);
        session.setAttribute("sessionEmail",email);
        session.setAttribute("sessionNickname",nickname);
        model.addAttribute("result", apiResult);

        /* 네이버 로그인 성공 페이지 View 호출 */
        return "index";
    }
    
    /**
     * 카카오 로그인 콜백
     *
     * @return String
     * @throws Exception
     */
    @RequestMapping(value = "/kakaologin", produces = "application/json", method = { RequestMethod.GET, RequestMethod.POST }) 
    public ModelAndView kakaoLogin(@RequestParam("code") String code, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception { 
    	ModelAndView mav = new ModelAndView(); 
    	// 결과값을 node에 담아줌 
    	JsonNode node = kakaoLoginApi.getAccessToken(code); 
    	// accessToken에 사용자의 로그인한 모든 정보가 들어있음 
    	JsonNode accessToken = node.get("access_token"); 
    	// 사용자의 정보 
    	JsonNode userInfo = kakaoLoginApi.getKakaoUserInfo(accessToken); 
    	String kemail = null; 
    	String kname = null; 
    	String kgender = null; 
    	String kbirthday = null; 
    	String kage = null; 
    	String kimage = null; 
    	// 유저정보 카카오에서 가져오기 Get properties 
    	JsonNode properties = userInfo.path("properties"); 
    	JsonNode kakao_account = userInfo.path("kakao_account"); 
    	kemail = kakao_account.path("email").asText(); 
    	kname = properties.path("nickname").asText(); 
    	kimage = properties.path("profile_image").asText(); 
    	kgender = kakao_account.path("gender").asText(); 
    	kbirthday = kakao_account.path("birthday").asText(); 
    	kage = kakao_account.path("age_range").asText(); 
    	session.setAttribute("kemail", kemail); 
    	session.setAttribute("sessionId", kname); 
    	session.setAttribute("kimage", kimage); 
    	session.setAttribute("kgender", kgender); 
    	session.setAttribute("kbirthday", kbirthday); 
    	session.setAttribute("kage", kage); 
    	mav.setViewName("index"); 
    	
    	return mav; 
    	
   }// end kakaoLogin()

    

    
    //로그아웃
    @RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
    public String logout(HttpSession session)throws IOException {
    	System.out.println("여기는 logout");
    	session.invalidate();
    return "redirect:/";
    }

}
