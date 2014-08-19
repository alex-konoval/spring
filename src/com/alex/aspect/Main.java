package com.alex.aspect;

import java.math.BigDecimal;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Пример реализации АОП с помощью Spring
 *
 */
public class Main {
	public static void main(String[] args) {
		
		//прокси - реализация АОП в Spring
		ProxyFactory pf = new ProxyFactory();
		//объект, для которого будет выполняться совет
		pf.setTarget(new PaymentService());
		//созданный нами совет
		pf.addAdvice(new PaymentAdviser());
		
		//объект "сервис платежей" с которым будем работать
		PaymentService service = (PaymentService) pf.getProxy();
		
		//тесты для трех вариантов, предусмотренных в совете
		Bill test1 = new Bill();
		test1.setCountry("Россия");
		test1.setCurrency("RUB");
		test1.setSumm(new BigDecimal("100.50"));
		
		Bill test2 = new Bill();
		test2.setCountry("США");
		test2.setCurrency("USD");
		
		Bill test3 = new Bill();
		test3.setCountry("Кокосовые острова");
		test3.setCurrency("USD");
		test3.setSumm(new BigDecimal("1000000.00"));
		
		//вызываем ЛЮБОЙ из методов на целевом объекте
		System.out.println("Счет 1: " + service.proceedBill1(test1));
		System.out.println("Счет 2: " + service.proceedBill2(test2));
		System.out.println("Счет 3: " + service.proceedBill1(test3));	
	}
}
