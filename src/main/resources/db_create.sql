SET CACHE_SIZE 16384;
SET TRACE_LEVEL_SYSTEM_OUT 0;
SET DEFAULT_TABLE_TYPE 0;
SET CLUSTER '';
SET DEFAULT_LOCK_TIMEOUT 1000;
SET WRITE_DELAY 500;
SET TRACE_LEVEL_FILE 1;
;
CREATE USER IF NOT EXISTS SA
  SALT '6a0e04afeac6bccc' HASH '065c94fe8fb12546403bd50ab883a59cd664b25ceb9f7bd8a1420a74099d0d3b' ADMIN;

CREATE CACHED TABLE PUBLIC.USER (
  ID       INT         NOT NULL AUTO_INCREMENT,
  USERNAME VARCHAR(50) NOT NULL,
  PASSWORD VARCHAR(50) NOT NULL,
  ROLE     VARCHAR(20) NOT NULL,
  PRIMARY KEY (ID),
  UNIQUE (USERNAME)
);

CREATE CACHED TABLE PUBLIC.COUNTRY (
  NAME       VARCHAR(50) NOT NULL,
  CAPITAL    VARCHAR(50),
  AREA       INT,
  POPULATION INT,
  CURRENCY   VARCHAR(3),
  PRIMARY KEY (NAME),
  UNIQUE (NAME)
);