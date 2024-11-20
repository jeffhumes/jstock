create table "exchange_holidays" (
   "ID" int(11) not null,
  "EVENT_NAME" varchar(255) not null,
  "AT_DATE" datetime not null,
  "TRADING_HOUR" varchar(100) default null,
    primary key ("id"),
unique key "exchange_holidays_unique" ("EVENT_NAME",
"AT_DATE",
"TRADING_HOUR")
);