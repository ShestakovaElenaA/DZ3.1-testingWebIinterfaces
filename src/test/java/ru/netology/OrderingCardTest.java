package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OrderingCardTest {

    @Test
    void ShouldSendRequestToTheCard () {
        open("http://localhost:9999/");
        //SelenideElement form =$("[data-test-id=form action]");
       $("[data-test-id=name] input").setValue("Иванов Василий");
       $("[data-test-id=phone] input").setValue("+79221052200");
       $("[data-test-id=agreement]").click();
       $(By.className("button")).click();
       String text = $("[data-test-id=order-success]").getText();
       Assertions.assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }
}