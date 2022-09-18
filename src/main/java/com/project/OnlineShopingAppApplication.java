package com.project;

import com.project.service.EmailSenderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
//import javax.mail.MessageException;
import javax.mail.MessagingException;

import org.springframework.context.event.EventListener;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class OnlineShopingAppApplication {

	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(OnlineShopingAppApplication.class, args);
	}

	@Bean
	public LocalValidatorFactoryBean validator(MessageSource ms) {
	LocalValidatorFactoryBean lvfb=new LocalValidatorFactoryBean();
	lvfb.setValidationMessageSource(ms);
	return lvfb;
	}
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail()  {
		senderService.sendSimpleEmail("dk62253@gmail.com",
				"TAX INVOICE RECEIPT",

				"ITEM PURCHASED:productId: 1266,\n" +
						"      productName:iPhone 14,\n" +
						"      price: 180000,\n" +
						"      color: white,\n" +
						"      dimension: 20x15,\n" +
						"      specification: Pro,\n" +
						"      manufacturer: Apple,\n" +
						"      quantity: 1,\n" +
						"      category: MOBILES");

	}
}
