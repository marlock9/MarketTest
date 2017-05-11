Meta:

Narrative:
As a guest
I want to find first phone by criteries and add it to basket
So that I can buy it

Scenario: scenario description
Given браузер с открытой страницей market.yandex.ru
When я открываю раздел 'Электроника'
And я открываю раздел 'Мобильные телефоны'
And я ввожу цену от 5000
And я ввожу цену до 10000
And я выбираю чекбокс Xiaomi
And я выбираю результат из списка с индексом 1
And я нажимаю кнопку 'В корзину'
Then я должен увидеть окно с текстом 'Товар добавлен'