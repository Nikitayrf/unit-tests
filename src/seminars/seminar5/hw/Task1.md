# Задание 1. 
Представьте, что вы работаете над разработкой простого приложения для записной книжки, которое позволяет пользователям добавлять, редактировать и удалять контакты.
Ваша задача - придумать как можно больше различных тестов (юнит-тесты, интеграционные тесты, сквозные тесты) для этого приложения. Напишите название каждого теста, его тип и краткое описание того, что этот тест проверяет.

### Решение
1. Юнит-тесты:
    1.1 Проверка, что функция addContact корректно добавляет новый контакт в список контактов 
    1.2 Проверка, что функция deleteContact корректно удаляет контакт из списка контактов
    1.3 Проверка, что функция EditContact корректно редактирует контакт из списка контактов
    
2. Интеграционный тест:
    2.1 Проверка, что функция addContactReadFromRepositoryContacts корректно добавляет контакт в репозитарий и считывает добавленный контакт из репозитария.
    2.2 Проверка, что функция deteleContactReadFromRepositoryContacts корректно удаляет контакт из репозитория и при попытке считывание удаленного контакта, не находит его в репозитории контактов.
3. Сквозной тест:
    3.1 Проверка, что функция addContactFromUIEditConnactReadFromRepositotyContacts корректно добавляет контакт через UI интерфейс, редактирует контакт и считывает отредактированный контакт из репозитория контактов. 

# Задание 2
   Ниже список тестовых сценариев. Ваша задача - определить тип каждого теста (юнит-тест, интеграционный тест, сквозной тест) и объяснить, почему вы так решили.
    
   ● Проверка того, что функция addContact корректно добавляет новый контакт в список контактов".

    Это юнит-тест, так как он проверяет работу одного модуля.

   ● "Проверка того, что при добавлении контакта через пользовательский интерфейс, контакт корректно отображается в списке контактов". 
   
    Это интеграциооный-тест, т.к. он проверяет взаимодействие 2-х модулей: пользовательского интерфейса и репозитория (списка) контактов

   ● "Проверка полного цикла работы с контактом: создание контакта, его редактирование и  последующее удаление".

    Это сквозной тест, т.к. он проверяет полный цикл работы приложения.
    