package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
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
       $("[data-test-id=order-success]").shouldBe(visible);
       $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}