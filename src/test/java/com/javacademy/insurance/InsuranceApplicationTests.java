package com.javacademy.insurance;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InsuranceApplicationTests {

    @Test
    void contextLoads() {
    }

    //10. Создать тесты с поднятием тестового контекста (активируя соответствующие профили):
    //10.1 Покрыть тестами InsuranceCalcJapanServicе
    //Ситуация №1: Рассчитать стоимость страховки при грабеже, сумма покрытия 1 000 000. Ожидаемая стоимость: 20 000.
    //Ситуация №2: Рассчитать стоимость страховки при мед страховке,
    // сумма покрытия 10 000 000. Ожидаемая стоимость: 165 000.
    //10.2 Покрыть тестами InsuranceCalcBrazilService
    //Ситуация №1: Рассчитать стоимость страховки при грабеже, сумма покрытия 50 000. Ожидаемая стоимость: 2800.
    //Ситуация №2: Рассчитать стоимость страховки при мед страховке, сумма покрытия 200 000. Ожидаемая стоимость: 6800.


    //10.3 Покрыть тестами InsuranceServiceJapan (калькулятор, архив, генератор номеров договоров - фальшивые)
    //Ситуация №1: Получить предложение по страховке, на вход: Иванов Иван Иванович, сумма покрытия 1 000 000,
    // тип - от грабежа.
    //На выход страховка:
    //номер договора - 001 - получено от генератора номеров договоров
    //стоимость страховки - 20 000  - получено от заглушки калькулятора
    //сумма покрытия - 1 000 000
    //валюта договора - yen
    //ФИО клиента - Иванов Иван Иванович
    //страна действия - Japan
    //тип страховки: защита от грабежа
    //статусы договора:  неоплаченный договор
    //
    //Ситуация №2: Получить предложение по страховке, на вход: Иванов Иван Иванович, сумма покрытия 1 000 000, тип
    // - от грабежа.
    //На выход страховка:
    //номер договора - 001 - получено от заглушки архива
    //стоимость страховки - 165 000  - получено от заглушки калькулятора
    //сумма покрытия - 10 000 000
    //валюта договора - yen
    //ФИО клиента - Иванов Иван Иванович
    //страна действия - Japan
    //тип страховки: мед страховка
    //статусы договора:  неоплаченный договор
    //
    //Ситуация №3: Оплатить страховку, на вход: номер договора - 001.
    //Из заглушки архива получаем договор (т.е. создаем сами такой договор и заставляем архив вернуть такой договор):
    //номер договора - 001
    //стоимость страховки - 165 000
    //сумма покрытия - 10 000 000
    //валюта договора - yen
    //ФИО клиента - Иванов Иван Иванович
    //страна действия - Japan
    //тип страховки: мед страховка
    //статусы договора:  неоплаченный договор
    //
    //На выход из метода оплаты страховки получаем:
    //Из заглушки архива получаем договор:
    // номер договора - 001 - получено от заглушки архива
    //стоимость страховки - 165 000  - получено от заглушки калькулятора
    //сумма покрытия - 10 000 000
    //валюта договора - yen
    //ФИО клиента - Иванов Иван Иванович
    //страна действия - Japan
    //тип страховки: мед страховка
    //статусы договора:  оплаченный договор (!)

}
