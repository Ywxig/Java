# static

> [!tip] статик это ключевое слово чтобы запертить копирование в экземпляр класса

все вызовы не статических пременных и функций от имени экземпляра класса

```java
class static Man {
    String eyeColor;
    static int eyeNumber;
}
```

```java
class static Spider {
    String eyeColor;
    static int eyeNumber;
}
```

```java
Man maga = new Man;
Man freeman = new Man;

Spider holland = new Spider;
Spider maguaer = new Spider;
```
> [!tip] статические методы, не работают натовно с экземплярями класса
