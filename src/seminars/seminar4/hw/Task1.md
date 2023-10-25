# 1)  Почему использование тестовых заглушек может быть полезным при написании модульных тестов?
Так как тестовая заглушка представляет собой упрощенную версию кода, более удобную для тестирования. То при тестировании класса или юнита возникает проблема, то мы точно уверены, что проблема не в заглушках, а в тестируемом коде.

# 2) Какой тип тестовой заглушки следует использовать, если вам нужно проверить, что метод был вызван с определенными аргументами?
Mock

# 3) Какой тип тестовой заглушки следует использовать, если вам просто нужно вернуть определенное значение или исключение в ответ на вызов метода?
Stub

# 4) Какой тип тестовой заглушки вы бы использовали для имитации  взаимодействия с внешним API или базой данных?
Fake