package org.me.controller;

import org.me.domain.PaymentVO;
import org.me.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;		
	
	@RequestMapping(value = "/paymentProcess.do")
	public void paymentDone(@RequestBody PaymentVO vo) {
		paymentService.insertPaymentSuccess(vo);
	}	
	
	@RequestMapping(value = "paymentDone.do")
	public ModelAndView fwdPaymentSuccessPage() {
		return new ModelAndView("/payment/paymentSuccess");
	}
	
	@RequestMapping(value = "payment.do")
	public ModelAndView fwdPaymentPage() {
		return new ModelAndView("/payment/payment");
	}
	

	
	@RequestMapping(value = "/")
	public ModelAndView goMain() {
		return new ModelAndView("index");
	}
	
	
}
