package com.alex.aspect;

/**
 * Сервис, который отвечает за обработку платежей.
 * В нем может быть множество различных методов
 * для работы со счетами.
 *
 */
public class PaymentService {
	
	public String proceedBill1(Bill input) {
		if (input == null)
			throw new IllegalArgumentException("bill == null");
		//какие-то действия со счетом
		return "Обработка счета по варианту #1 завершена";
	}

	public String proceedBill2(Bill input) {
		if (input == null)
			throw new IllegalArgumentException("bill == null");
		//какие-то другие действия со счетом
		return "Обработка счета по варианту #2 завершена";
	}
}
