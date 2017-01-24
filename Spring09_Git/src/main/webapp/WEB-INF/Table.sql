CREATE TABLE client_account(
	id VARCHAR2(100) PRIMARY KEY, 
	balance NUMBER CHECK(balance >= 0), 
	bounsPoint NUMBER CHECK(bounsPoint >= 0));