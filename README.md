# quotes task

База данных (PostgreSQL), Миграции (Liquibase)

![db](https://user-images.githubusercontent.com/29467133/217855795-acc435fe-70f4-4320-99c0-a7fd0f0284a1.PNG)

API:

UserController:  @post user/create (String login, String password)

QuoteController: @post quote/create (long userId, String description),

                 @post quote/delete/{quoteId},
                 
                 @post quote/modify (long quoteId, String description)
                 
                 @get quote/getRandom
                 
                 @get quote/getTop10
                 
                 @get quote/getWorse10
                 
VoteController:  @post vote/upToQuote/{quoteId},

                 @post vote/downToQuote/{quoteId}
               
Docker-hub: https://hub.docker.com/r/avetisyanincorporation/quotes-app-java-hub/tags

Локальный запуск:
1) Перейти в каталог с кодом /quotes-task
2) docker-compose up --build
3) docker exec -it quotes-db-postgres bash - поключиться к консоли базы
4) psql -U postgres                        - войти в базу под юзером
5) \c quotes_db                            - подключиться к БД
6) create schema quotes;                   - создать схему в БД

Работа заняла 6 часов
