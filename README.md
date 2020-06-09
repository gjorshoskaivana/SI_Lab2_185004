## Втора лабораториска вежба пo Софтверско инженерство

### Ивана Ѓоршоска, бр. на индекс: 185004

#### Група на код
Ја добив групата на код 2.

#### Control Flow Graph 
![alt text](Control%20Flow%20Diagram.png)

#### Цикломатска комплексност
Цикломатската комплексност на графот е 8. Ја добив употребувајќи ја формулата со јазли и ребра. Бројот на ребра е 27, бројот на јазли е 21, па соодветно 27 - 21 + 2 = 8.
(Формулата е E-N+2, каде што Е = бр. на ребра, N = бр. на јазли)

#### Тест случаи според Every Statement
При сите тест случаи, не се проверува дали листата со корисници е празна, па истата може да биде што било.

Тест случаи:
1. user = null (неиницијализиран корисник)
    * ги опфaќа: 1, 2, 3, 20 
2. user.username = null (невалидно корисничко име)
    * ги опфаќа: 1, 2, 4, 5, 20 
3. list.contains(user.username) (корисникот веќе се наоѓа во листата на корисници)
    * ги опфаќа: 1, 2, 4, 5, 20  
4. user.email = null (нема email адреса и го нема во листата на корисници)
    * ги опфаќа: 1, 2, 4, 6, 7, 20 
5. user.email не содржи @ (и го нема во листата на корисници)
    * ги опфаќа: 1, 2, 4, 6, 8, 9.1, 9.2, 9.3, 10, 12, 14, 15, 16, 20
6. user.email не содржи . (и го нема во листата на корисници)
    * ги опфаќа: 1, 2, 4, 6, 8, 9.1, 9.2, 9.3, 10, 11, 12, 14, 15, 16, 20
7. сите услови се задоволени, корисничките информации се во ред
    * ги опфаќа: 1, 2, 4, 6, 8, 9.1, 9.2, 9.3, 10, 11, 12, 13, 14, 15, 17,18, 19 20

#### Тест случаи според Every Branch
И со овој критериум важи истото во врска со листата на постоечки корисници како и во Every Statement критериумот.

Тест случаи (важат истите тест случаи од претходно):
1. user = null (неиницијализиран корисник)
    * ги опфаќа: 1-2, 2-3, 3-20 
2. user.username = null (невалидно корисничко име)
    * ги опфаќа: 1-2, 2-4, 4-5, 5-20
3. list.contains(user.username) (корисникот веќе се наоѓа во листата на корисници)
    * ги опфаќа: 1-2, 2-4, 4-5, 5-20  
4. user.email = null (нема email адреса и го нема во листата на корисници)
    * ги опфаќа: 1-2, 2-4, 4-6, 6-7, 7-20 
5. user.email не содржи @ (и го нема во листата на корисници)
    * ги опфаќа: 1-2, 2-4, 4-6, 6-8, 8-9.1, 9.1-9.2, 9.2-10, 9.2-14, 10-12, 12-9.3, 9.3-9.2, 14-15, 15-16, 16-20
6. user.email не содржи . (и го нема во листата на корисници)
    * ги опфаќа: 1-2, 2-4, 4-6, 6-8, 8-9.1, 9.1-9.2, 9.2-10, 9.2-14, 10-11, 10-12, 11-12, 12-9.3, 9.3-9.2, 14-15, 15-16, 16-20
7. сите услови се задоволени, корисничките информации се во ред
    * ги опфаќа: 1-2, 2-4, 4-6, 6-8, 8-9.1, 9.1-9.2, 9.2-10, 9.2-14, 10-11, 10-12, 11-12, 12-13, 12-9.3, 13-9.3, 9.3-9.2, 14-15, 15-17,18, 17,18-19, 19-20
    
#### Тест случаи според Every Path
Забелешка: секаде каде што има само allUsers се мисли дека приложеното корисничко име за тест случајот не се содржи во листата.

1. 1, 2, 3, 20 - user=null, AllUsers
2. 1, 2, 4, 5, 20 - user(null, anything, anything), allUsers
3. 1, 2, 4, 5, 20 - user("username", anything, anything), allUsers(contains "username")
4. 1, 2, 4, 6, 7, 20 - user("username", anything, null), allUsers
5. 1, 2, 4, 6, 8, 9.1, 9.2, 14, 15, 16, 20 - user("username", anything, null), allUsers; ова е невозможно, не може да се помине условот за email, а тој да биде null
6. 1, 2, 4, 6, 8, 9.1, 9.2, 14, 15, 17,18, 19, 20 - user("username", anything, null), allUsers; ова е невозможно, не може да се помине условот за email, а тој да биде null
7. 1, 2, 4, 6, 8, 9.1, (9.2, 10, 12, 9.3), 14, 15, 16, 20 - user("username", anything, "email.com"), allUsers
8. 1, 2, 4, 6, 8, 9.1, (9.2, 10, 12, 9.3), 14, 15, 17,18, 19, 20 - user("username", anything, "email.com"), allUsers, не е можно бидејќи email не содржи @, не може да помине во условот во јазол 15
9. 1, 2, 4, 6, 8, 9.1, (9.2, 10, 11, 12, 9.3), 14, 15, 16, 20 - user("username", anything, "email@com"), allUsers
10. 1, 2, 4, 6, 8, 9.1, (9.2, 10, 11, 12, 9.3), 14, 15, 17,18, 19, 20 - user("username", anything, "email@com"), allUsers, не е можно бидејќи email не содржи ., не може да помине во условот во јазол 15
11. 1, 2, 4, 6, 8, 9.1, (9.2, 10, 11, 12, 13, 9.3), 14, 15, 17,18, 19, 20 - user("username", anything, "email@email.com"), allUsers

#### Објаснување за напишаните Unit test
Unit тестовите во класата SILab2Test се напишани според горенаведените тест случаи соодветно за побарувањата на двете прашања (јас имав за Every Branch и Every Path).
Секој assert од двете функции за тестирање според Every Branch и Every Path критериумот соодветно, претставува даден тест случај од претходно објаснетите тест случаи. Тест случаите се направено така што програмот да влезе во секоја линија по завршување на сите. Па така, првиот тест почнува со тестирање на условот за дали е инстанциран User и истиот е ставен дека не е, па програмата фрла Runtime исклучок и завршува. Вториот тест е направен според тоа корисничкото име во инстанцата од User да е null, и истиот го тестира првиот услов од else делот од кодот. Соодветно, со третиот тест се проверува вториот дел од првиот услов во else делот. На сличен начин се направени и останатите тестови, да исполнуваат соодветни if услови и со тоа да таргетираат специфичен дел  од кодот во функцијата. 
