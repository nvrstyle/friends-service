# Сервис друзей
### Создание базы данных для сервиса друзей

    CREATE TABLE friends (
      id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
      userid INT NOT NULL,
      friendid INT NOT NULL,
      status INT NOT NULL,
    
      UNIQUE (userid,friendid)
    )ENGINE = InnoDB;
    
    INSERT INTO friends VALUES (1,1234,4321,0);
    INSERT INTO friends VALUES (2,4321,2234,0);
    INSERT INTO friends VALUES (3,1234,5678,1);
    INSERT INTO friends VALUES (4,5678,1234,1);
    INSERT INTO friends VALUES (5,1234,9876,0);
    INSERT INTO friends VALUES (6,9876,1234,0);

### API

#### Запрос - получить всех друзей пользователя {userid}
GET localhost:8000/friends/{userid}/ext

Тело ответа

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

#### Добавление в друзья

 

    POST /friends/ext
        
      
   тело запроса:
        
        {
            "userid": 1234,
            "friendid": 9876
        }
    

Возвращает в качестве ответа полный список друзей пользователя

#### Удаление из друзей 
 

    DELETE /friends/{userid}/friend/{friendid}/ext

где {userid} это id пользователя под которым зашли, {friendid} - id друга, которого хотим удалить

Возвращает в качестве ответа полный список друзей пользователя

#### Одобрение заявки в друзья

    GET /friends/{userid}/accept/{friendid}/ext

где {userid} это id пользователя под которым зашли, {friendid} - id друга, которого хотим добавить в друзья

Возвращает в качестве ответа полный список друзей пользователя

#### Являются ли два пользователя друзьями

    GET /friends/{userid}/isfriend/{friendid}

где {userid} это id пользователя под которым зашли, {friendid} - id другого пользователя

Тело ответа:

    {
        "friended": 0
    }

0 - если не друзья, 1 - если друзья
