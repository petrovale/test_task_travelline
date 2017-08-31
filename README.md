##### Решение на тестовое задание
- [1. Набор ручных тестов для проверки формы регистрации почтового ящика rambler.ru](https://github.com/petrovale/test_task_travelline/blob/master/README.md)
- [2. Автотесты для  проверки полей: Почтовый ящик и Пароль. Selenium и  Java.](https://github.com/petrovale/test_task_travelline/blob/master/src/main/java/ru/rambler/registration/Registration.java)
- [3. Автоматическая авторизация в ящик rambler.ru и проверка наличия новых писем.](https://github.com/petrovale/test_task_travelline/tree/master/src/main/java/ru/rambler/authorization)

Тестирование на браузер Google Chrome версии 60.0.3112.113
## 1. Набор ручных тестов для проверки формы регистрации почтового ящика rambler.ru https://id.rambler.ru/account/registration

## Тест-кейс № 01. Проверка всех текстовых полей, переключателей, кнопок и т. д.
##### Шаги для выполнения:
```
1. Зайти на сайт https://id.rambler.ru/account/registration 
2. Нажимать «Чекбокс», кнопки и выпадающие меню.
Тестовые данные / ввод
```
##### Ожидаемый результат
```
1. Пользовательский интерфейс должен быть идеальным.
```
## Тест-кейс № 02. Регистрация с обязательными не заполненными полями.
##### Шаги для выполнения:
```
1. Зайти на сайт https://id.rambler.ru/account/registration 
2. Не вводить значения в обязательные поля.
3. Нажать на кнопку "Регистрация".
```

##### Ожидаемый результат
```
1. Красным цветом должны быть выделены обязательные для заполнения поля и должно запрашиваться заполнение обязательных полей.
```
## Тест-кейс № 03. Регистрация с обязательными заполненными полями.
##### Шаги для выполнения:
```
1. Зайти на сайт https://id.rambler.ru/account/registration 
2. Ввести допустимые значения в обязательные поля.
3. Нажать на кнопку "Регистрация".
```
##### Тестовые данные / ввод
##### Ожидаемый результат
```
1. Пользователь должен зарегистрироваться успешно.
2. После успешной регистрации должен быть выполнен автоматический переход на страницу профиля
3. Должно прийти письмо с благодарностью за регистрацию.
```

## Тест-кейс № 04. Регистрация с необязательными не заполненными полями.
##### Шаги для выполнения:
```
1. Зайти на сайт https://id.rambler.ru/account/registration 
2. Ввести допустимые значения в обязательные поля.
3. Не вводить какие-либо значения в необязательные поля. 
4. Нажать на кнопку "Регистрация".
```

##### Ожидаемый результат
```
1. Не должно запрашиваться заполнение необязательных полей.
2. Пользователь должен зарегистрироваться успешно. 
3. После успешной регистрации должен быть выполнен автоматический переход на страницу профиля.
4. Должно прийти письмо с благодарностью за регистрацию.
```
## Тест-кейс № 05. Регистрация с необязательными заполненными полями.
##### Шаги для выполнения:
```
1. Зайти на сайт https://id.rambler.ru/account/registration 
2. Ввести допустимые значения в обязательные поля.
3. Ввести действительные данные в необязательные поля. 
4. Нажать на кнопку "Регистрация".
```
##### Ожидаемый результат
```
1. Пользователь должен зарегистрироваться успешно. 
2. После успешной регистрации должен быть выполнен автоматический переход на страницу профиля
3. Должно прийти письмо с благодарностью за регистрацию.
```
## Тест-кейс № 06. Проверка недействительного адреса электронной почты..
##### Шаги для выполнения:
```
1. Зайти на сайт https://id.rambler.ru/account/registration 
2. Ввести недействительные адреса электронной почты.
3. Нажать на кнопку "Регистрация".
```
##### Тестовые данные / ввод
```
1. te stteee @rambler.ru
2. @rambler
```
##### Ожидаемый результат
```
1. Должно отображаться сообщение проверки правильности адреса электронной почты
```
## Тест-кейс № 07. Проверка действительного адреса электронной почты.
##### Шаги для выполнения:
```
1. Зайти на сайт https://id.rambler.ru/account/registration 
2. Ввести действительные адреса электронной почты.
3. Нажать на кнопку "Регистрация".
```
##### Тестовые данные / ввод
```
1. hjgjghjgjr@rambler.ru
```
##### Ожидаемый результат
```
1. Не должно отображаться какое-либо сообщение проверки правильности адреса электронной почты
```
## Тест-кейс № 08. Проверка пароля, когда вводите значение меньше 6 символов.
##### Шаги для выполнения:
```
1. Зайти на сайт https://id.rambler.ru/account/registration 
2. Ввести значение меньше 6 символов, которое может содержать латинские буквы и цифры, а также символы ! @ $ % ^ & * ( ) _ - +
3. Нажать на кнопку "Регистрация".
```
##### Ожидаемый результат
```
1. Появляется сообщение об ошибке “Пароль должен содержать от 6 до 32 символов”
2. Пользователь не должен зарегистрироваться.
```
## Тест-кейс № 09. Проверка пароля, когда вводите значение больше  32 символов.
##### Шаги для выполнения:
```
1. Зайти на сайт https://id.rambler.ru/account/registration 
2. Ввести значение больше 32 символов, которое может содержать латинские буквы и цифры, а также символы ! @ $ % ^ & * ( ) _ - +
3. Нажать на кнопку "Регистрация".
```
##### Ожидаемый результат
```
1. Появляется сообщение об ошибке “Пароль должен содержать от 6 до 32 символов”
2. Пользователь не должен зарегистрироваться.
```
## Тест-кейс № 10. Проверка пароля, при вводе только цифр.
##### Шаги для выполнения:
```
1. Зайти на сайт https://id.rambler.ru/account/registration 
2. Ввести значение в цифрах, которое содержать от 6 до 32 символов.
```
##### Ожидаемый результат
```
1. Появляется сообщение “Пароль средней сложности”.
```
## Тест-кейс № 11. Проверка пароля, который может содержать латинские буквы и цифры, а также символы ! @ $ % ^ & * ( ) _ - + в пределах от 6 до 32 символов.
##### Шаги для выполнения:
```
1. Зайти на сайт https://id.rambler.ru/account/registration 
2. Ввести значение в цифрах, в пределах от 6 до 32 символов, которое может содержать латинские буквы и цифры, а также символы ! @ $ % ^ & * ( ) _ - +
```
##### Ожидаемый результат
```
1. Появляется сообщение “Пароль средней сложности” или “ Сложный пароль”.
2. Желтым или зеленым цветом должны быть подчеркнуто поле, зависимости от уровня сложности пароля.
```