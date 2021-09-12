# Source code of my [blog](https://www.dhaval-shah.com/performance-comparison-rsocket-webflux/) on [RSocket](https://principlesofchaos.org/) and comparing its performance against _Webflux_  

#### Card Service APIs
Comprises of business flow which allows consumer of this application to view card based on Id or fetch all the cards

| HTTP Method   | URI     | Description   |
| :--------:  | :--------: | :------ |
| GET | rx/card/{id} | Fetches a card from Redis based on cardId |
| GET | rx/cards/ | Fetches all the cards from Redis  |