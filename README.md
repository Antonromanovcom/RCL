# RESO CALC LOG COMPARE TOOL


### Что в данном коммите:

* Прикрутил JPArepository
* Так как Spring в отличие от SpringBoot'а не поддерживает из коробки автонастройку таких вещей как JPArepository или CRUDrepository без дополнительного конфигурирования, пришлось дополнительно прописывать EntityManager и прочую лабуду.
* Теперь есть возможность использовать запросы и формировать классы фильтруя параметрами.


### Что надо будет сделать в следующем коммите:

* Опробировать @Query



### Установка:


```
mvn clean install
```
либо
```
https://192.*.*.*:33246/RCCT-2.0-SNAPSHOT/ho
```
, где 192.*.*.*:33246 - адрес тестового сервера GF







