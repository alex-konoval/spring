package com.alex.aspect;

import java.math.BigDecimal;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Реализация совета "вместо" для вызова метода ("интерсептор").
 */
public class PaymentAdviser implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation object) 
			                   throws Throwable {
		
		//аргуметы, переданные целевому методу
		Object[] arguments = object.getArguments();
		
		for (Object buff: arguments) {
			
			if (buff instanceof Bill) {
				Bill bill = (Bill) buff;
				
				if (bill.getCurrency() == null ||
					bill.getCurrency().isEmpty() ||
					bill.getSumm() == null  ||
					bill.getSumm().equals(BigDecimal.valueOf(0))) {
					
					return "Не указаны: сумма и/или валюта счета!";
				}
				
				//Для этой страны обработка счета идет по
				//другому, отдельному сценарию
				if (bill.getCountry() != null)
				if (bill.getCountry().equals("Кокосовые острова"))
					return this.proceedBill3(bill);
			}	
		}
		
		//если все проверки пройдены - мы просто 
		//вызываем целевой метод	
		return object.proceed();
	}
	
	private String proceedBill3 (Bill input) {
		//какие-то действия, которые не предусмотрены 
		//в сервисе обработки счетов
		return "Это счастливый счет, для него у нас" +
				" есть специальный вариант обработки!";
	}
}