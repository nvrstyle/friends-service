Сервис друзей

Порт 8000

---Запрос - получить всех друзей пользователя {userid}
GET localhost:8000/friends/{userid}/ext

Тело ответа( на данный момент)

{
    "friendsInRequest": 5,
    "friend_id": [
        5678
    ],
    "friend_out_id": [
        1235,
        2244,
        2957,
        2958,
        2959
    ],
    "friend_in_id": [
        2957,
        2958,
        2959,
        2244,
        1235
    ],
    "friendsCount": 1,
    "friendsOutRequest": 5
}

Тело ответа( в будущем)

"friendsInRequest": 5,
    "friend_id": [
        {
		"login": "vasya", 
  "name": "\u0412\u0430\u0441\u044f", 
  "password": "c4ca4238a0b923820dcc509a6f75849b", 
  "surname": "\u0418\u0432\u0430\u043d\u043e\u0432", 
  "uid": 1
  }
    ],
    "friend_out_id": [
        1235,
        2244,
        2957,
        2958,
        2959
    ],
    "friend_in_id": [
        2957,
        2958,
        2959,
        2244,
        1235
    ],
    "friendsCount": 1,
    "friendsOutRequest": 5
}

-----Добавление в друзья

POST /friends/ext

тело запроса

{
    "userid": 1234,
    "friendid": 9876
}

вернёт тоже самое что и самый первый метод


----удаление из друзей 

DELETE /friends/{userid}/friend/{friendid}/ext

где {userid} это id пользователя под которым зашли, {friendid} - id друга, которого хотим удалить

ответ такой же как и в первом методе

Одобряем запрос юзера в друзья
GET /friends/{userid}/accept/{friendid}/ext

где {userid} это id пользователя под которым зашли, {friendid} - id друга, которого хотим удалить

ответ такой же как и в первом методе

-----Являются ли два пользователя друзьями

GET /friends/{userid}/isfriend/{friendid}

где {userid} это id пользователя под которым зашли, {friendid} - id друга, которого хотим удалить

Тело ответа:

{
    "friended": 0
}

0 - если не друзья, 1 - если друзья



