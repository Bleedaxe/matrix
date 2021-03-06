Проект по Паралелно програмиране

Качения проект е написан на програмния език Java и реализира проблема за умножение на 2 матрици.

Програмата очаква подаване на на число като command line argument. При въвеждане на невалидна или липсваща стойност стартира програмата използвайки тестовите матрици.

За реализация на проблема е използвана Stream библиотеката предоставена от Java 8.

Проекта е направен посредством build tool-a Gradle, като това позволява лесно добавянето на нови библиотеки. До момента се използват Slf4j и Log4j, чиято цел е подобряване на логването и абстракция над директното принтиране в конзолата.

Реализация:
Всички Out операции се печатат в logs/app.log файла.
За умножение на 2 матрици е нужно да се завъртят 3 вложени цикъла за умножението и още 2 такива за преобразуването на матрицата в низ. Тъй като дадения код използваше процедурен подход, това правеше паралелизацията много по-трудна за реализация. За да се намали нивото на сложност всички цикли са преобразувани към функционален подход, което означава, че итерирането на елементите става, чрез вътрешен итератор.
След премахване на for циклите и заместването им със Stream и IntStream обекти единствената стъпка за паралелизация на изпълнението е извикаване на parallel() метода на обектите. След набор от тестове на умножение на големи матрици и различни комбинации от паралелни стриймове стана ясно, че най-добра ефективност има при паралелизация само на най-външният такъв.

Кода на програмата се състои от 4 класа:
- Application - това е входната точка на приложението. Той се грижи за четене на данните от конзолата и стартиране на процеса за умножение.
- Utils - статичен клас, който държи константата за нов ред (зависеща от операционната система, на която се изпълнява кода) и метод за генериране на произволна матрица по даден размер.
- MatrixMultiplyProcess - клас състоящ се от factory method, който приема 2 матрици и ги умножава. Получената матрица я прави на низ. Също така замерва времето, което е отнело за изпълнението на предходните 2 операции.
- Matrix - клас направен за абстракция над двумерния масив. Има 2 полета (size и data) и 2 метода multiply и toString. Двата метода се изпълняват паралелно.