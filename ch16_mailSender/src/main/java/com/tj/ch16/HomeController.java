package com.tj.ch16;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@Autowired
	private JavaMailSender mailSender;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "join";
	}
	
	@RequestMapping(value="textMail", method = RequestMethod.POST)
	public String textMail(String name, String mailaddr, Model model) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("warugen12@gmail.com");					// 관리자 메일 주소(보내는 사람)
		message.setTo(mailaddr);								// 받을 메일 주소
		message.setSubject(name + "님 회원가입 감사합니다.");	// 받는 메일 제목
		String content = name + "님 회원가입 감사합니다.\n <h1>태그안먹는다.</h1>";
		message.setText(content);
		mailSender.send(message);	// 메일 발송
		model.addAttribute("result", "TEXT메일이 발송되었습니다.");
		
		return "sendResult";
	}
	
	@RequestMapping(value="htmlMail", method = RequestMethod.POST)
	public String htmlMail(final String name, final String mailaddr, Model model) {
		MimeMessagePreparator messege = new MimeMessagePreparator() {
			String content = "  <h1>"+name+"님의 회원가입을 축하드립니다</h1>"+
					"  <div>" + 
					"    <div>" + 
					"      아무개 싸이트에서만 쓰실 수 있는 쿠폰을 드립니다\n\n" + 
					"      <hr color=\"red\"/>" + 
					"    </div>" + 
					"    <div>" + 
					"      <p style=\"color:blue;\" >파란색 글씨부분</p>" + 
					"      <p style=\"color:red;\">빨간색 글씨부분</p>" + 
					"    </div>" + 
					"  </div>" + 
					"    <div>" + 
					"      <img src=\"https://t1.daumcdn.net/daumtop_chanel/op/20170315064553027.png\" />\n" + 
					"    </div>" + 
					"    <div style=\"font-weight: blod; font-size: 1.2em;\">아무개 사이트 일동</div>\n" + 
					"    <div style=\"color:red;\">서울시 종로구 몰라17길 51 어떤빌딩 8층</div>";
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(mailaddr));	// 받는 메일
				mimeMessage.setFrom(new InternetAddress("warugen12@gmail.com"));
				mimeMessage.setSubject(name + "님 회원가입 감사합니다.(html)");
				mimeMessage.setText(content, "utf-8", "html");
			}
		};
		
		mailSender.send(messege);
		model.addAttribute("result", "HTML메일이 발송되었습니다.");
		return "sendResult";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
