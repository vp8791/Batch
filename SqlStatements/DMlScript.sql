drop table BATCH_STEP_EXECUTION_CONTEXT;
drop table BATCH_STEP_EXECUTION;
drop table BATCH_JOB_EXECUTION_CONTEXT;
drop table BATCH_JOB_EXECUTION_PARAMS;
drop table BATCH_JOB_EXECUTION;
drop table BATCH_JOB_INSTANCE;
drop table ACQUIRER_SETTLEMENTS;
drop table CONFIGURATION_PARAMETERS;
drop sequence JOB_ID_SEQUENCE;

--------------------------------------------------------
--  File created - Sunday-July-22-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BATCH_JOB_EXECUTION
--------------------------------------------------------

  CREATE TABLE BATCH_JOB_EXECUTION
   (	"JOB_EXECUTION_ID" NUMBER(19,0), 
	"VERSION" NUMBER(19,0), 
	"JOB_INSTANCE_ID" NUMBER(19,0), 
	"CREATE_TIME" TIMESTAMP (6), 
	"START_TIME" TIMESTAMP (6) DEFAULT NULL, 
	"END_TIME" TIMESTAMP (6) DEFAULT NULL, 
	"STATUS" VARCHAR2(10 CHAR), 
	"EXIT_CODE" VARCHAR2(2500 CHAR), 
	"EXIT_MESSAGE" VARCHAR2(2500 CHAR), 
	"LAST_UPDATED" TIMESTAMP (6), 
	"JOB_CONFIGURATION_LOCATION" VARCHAR2(2500 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table BATCH_JOB_INSTANCE
--------------------------------------------------------

  CREATE TABLE BATCH_JOB_INSTANCE
   (	"JOB_INSTANCE_ID" NUMBER(19,0), 
	"VERSION" NUMBER(19,0), 
	"JOB_NAME" VARCHAR2(100 CHAR), 
	"JOB_KEY" VARCHAR2(32 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table BATCH_JOB_EXECUTION_PARAMS
--------------------------------------------------------

  CREATE TABLE BATCH_JOB_EXECUTION_PARAMS
   (	"JOB_EXECUTION_ID" NUMBER(19,0), 
	"TYPE_CD" VARCHAR2(6 CHAR), 
	"KEY_NAME" VARCHAR2(100 CHAR), 
	"STRING_VAL" VARCHAR2(250 CHAR), 
	"DATE_VAL" TIMESTAMP (6) DEFAULT NULL, 
	"LONG_VAL" NUMBER(19,0), 
	"DOUBLE_VAL" NUMBER, 
	"IDENTIFYING" CHAR(1 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table BATCH_JOB_EXECUTION_CONTEXT
--------------------------------------------------------

  CREATE TABLE BATCH_JOB_EXECUTION_CONTEXT
   (	"JOB_EXECUTION_ID" NUMBER(19,0), 
	"SHORT_CONTEXT" VARCHAR2(2500 CHAR), 
	"SERIALIZED_CONTEXT" CLOB
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" 
 LOB ("SERIALIZED_CONTEXT") STORE AS SECUREFILE (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192
  NOCACHE LOGGING  NOCOMPRESS  KEEP_DUPLICATES 
  STORAGE(INITIAL 106496 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) ;
--------------------------------------------------------
--  DDL for Table BATCH_STEP_EXECUTION
--------------------------------------------------------

  CREATE TABLE BATCH_STEP_EXECUTION 
   (	"STEP_EXECUTION_ID" NUMBER(19,0), 
	"VERSION" NUMBER(19,0), 
	"STEP_NAME" VARCHAR2(100 CHAR), 
	"JOB_EXECUTION_ID" NUMBER(19,0), 
	"START_TIME" TIMESTAMP (6), 
	"END_TIME" TIMESTAMP (6) DEFAULT NULL, 
	"STATUS" VARCHAR2(10 CHAR), 
	"COMMIT_COUNT" NUMBER(19,0), 
	"READ_COUNT" NUMBER(19,0), 
	"FILTER_COUNT" NUMBER(19,0), 
	"WRITE_COUNT" NUMBER(19,0), 
	"READ_SKIP_COUNT" NUMBER(19,0), 
	"WRITE_SKIP_COUNT" NUMBER(19,0), 
	"PROCESS_SKIP_COUNT" NUMBER(19,0), 
	"ROLLBACK_COUNT" NUMBER(19,0), 
	"EXIT_CODE" VARCHAR2(2500 CHAR), 
	"EXIT_MESSAGE" VARCHAR2(2500 CHAR), 
	"LAST_UPDATED" TIMESTAMP (6)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table BATCH_STEP_EXECUTION_CONTEXT
--------------------------------------------------------

  CREATE TABLE BATCH_STEP_EXECUTION_CONTEXT 
   (	"STEP_EXECUTION_ID" NUMBER(19,0), 
	"SHORT_CONTEXT" VARCHAR2(2500 CHAR), 
	"SERIALIZED_CONTEXT" CLOB
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" 
 LOB ("SERIALIZED_CONTEXT") STORE AS SECUREFILE (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192
  NOCACHE LOGGING  NOCOMPRESS  KEEP_DUPLICATES 
  STORAGE(INITIAL 106496 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) ;
--------------------------------------------------------
--  DDL for Index SYS_C0012237
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0012237" ON "BATCH_JOB_EXECUTION" ("JOB_EXECUTION_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012232
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0012232" ON "BATCH_JOB_INSTANCE" ("JOB_INSTANCE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index JOB_INST_UN
--------------------------------------------------------

  CREATE UNIQUE INDEX "JOB_INST_UN" ON "BATCH_JOB_INSTANCE" ("JOB_NAME", "JOB_KEY") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012257
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0012257" ON "BATCH_JOB_EXECUTION_CONTEXT" ("JOB_EXECUTION_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012249
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0012249" ON "BATCH_STEP_EXECUTION" ("STEP_EXECUTION_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012253
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0012253" ON "BATCH_STEP_EXECUTION_CONTEXT" ("STEP_EXECUTION_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table BATCH_JOB_EXECUTION
--------------------------------------------------------

  ALTER TABLE "BATCH_JOB_EXECUTION" ADD PRIMARY KEY ("JOB_EXECUTION_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "BATCH_JOB_EXECUTION" MODIFY ("CREATE_TIME" NOT NULL ENABLE);
  ALTER TABLE "BATCH_JOB_EXECUTION" MODIFY ("JOB_INSTANCE_ID" NOT NULL ENABLE);
  ALTER TABLE "BATCH_JOB_EXECUTION" MODIFY ("JOB_EXECUTION_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table BATCH_JOB_INSTANCE
--------------------------------------------------------

  ALTER TABLE "BATCH_JOB_INSTANCE" ADD CONSTRAINT "JOB_INST_UN" UNIQUE ("JOB_NAME", "JOB_KEY")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "BATCH_JOB_INSTANCE" ADD PRIMARY KEY ("JOB_INSTANCE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "BATCH_JOB_INSTANCE" MODIFY ("JOB_KEY" NOT NULL ENABLE);
  ALTER TABLE "BATCH_JOB_INSTANCE" MODIFY ("JOB_NAME" NOT NULL ENABLE);
  ALTER TABLE "BATCH_JOB_INSTANCE" MODIFY ("JOB_INSTANCE_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table BATCH_JOB_EXECUTION_PARAMS
--------------------------------------------------------

  ALTER TABLE "BATCH_JOB_EXECUTION_PARAMS" MODIFY ("IDENTIFYING" NOT NULL ENABLE);
  ALTER TABLE "BATCH_JOB_EXECUTION_PARAMS" MODIFY ("KEY_NAME" NOT NULL ENABLE);
  ALTER TABLE "BATCH_JOB_EXECUTION_PARAMS" MODIFY ("TYPE_CD" NOT NULL ENABLE);
  ALTER TABLE "BATCH_JOB_EXECUTION_PARAMS" MODIFY ("JOB_EXECUTION_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table BATCH_JOB_EXECUTION_CONTEXT
--------------------------------------------------------

  ALTER TABLE "BATCH_JOB_EXECUTION_CONTEXT" ADD PRIMARY KEY ("JOB_EXECUTION_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "BATCH_JOB_EXECUTION_CONTEXT" MODIFY ("SHORT_CONTEXT" NOT NULL ENABLE);
  ALTER TABLE "BATCH_JOB_EXECUTION_CONTEXT" MODIFY ("JOB_EXECUTION_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table BATCH_STEP_EXECUTION
--------------------------------------------------------

  ALTER TABLE "BATCH_STEP_EXECUTION" ADD PRIMARY KEY ("STEP_EXECUTION_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "BATCH_STEP_EXECUTION" MODIFY ("START_TIME" NOT NULL ENABLE);
  ALTER TABLE "BATCH_STEP_EXECUTION" MODIFY ("JOB_EXECUTION_ID" NOT NULL ENABLE);
  ALTER TABLE "BATCH_STEP_EXECUTION" MODIFY ("STEP_NAME" NOT NULL ENABLE);
  ALTER TABLE "BATCH_STEP_EXECUTION" MODIFY ("VERSION" NOT NULL ENABLE);
  ALTER TABLE "BATCH_STEP_EXECUTION" MODIFY ("STEP_EXECUTION_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table BATCH_STEP_EXECUTION_CONTEXT
--------------------------------------------------------

  ALTER TABLE "BATCH_STEP_EXECUTION_CONTEXT" ADD PRIMARY KEY ("STEP_EXECUTION_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "BATCH_STEP_EXECUTION_CONTEXT" MODIFY ("SHORT_CONTEXT" NOT NULL ENABLE);
  ALTER TABLE "BATCH_STEP_EXECUTION_CONTEXT" MODIFY ("STEP_EXECUTION_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table BATCH_JOB_EXECUTION
--------------------------------------------------------

  ALTER TABLE "BATCH_JOB_EXECUTION" ADD CONSTRAINT "JOB_INST_EXEC_FK" FOREIGN KEY ("JOB_INSTANCE_ID")
	  REFERENCES "BATCH_JOB_INSTANCE" ("JOB_INSTANCE_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BATCH_JOB_EXECUTION_PARAMS
--------------------------------------------------------

  ALTER TABLE "BATCH_JOB_EXECUTION_PARAMS" ADD CONSTRAINT "JOB_EXEC_PARAMS_FK" FOREIGN KEY ("JOB_EXECUTION_ID")
	  REFERENCES "BATCH_JOB_EXECUTION" ("JOB_EXECUTION_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BATCH_JOB_EXECUTION_CONTEXT
--------------------------------------------------------

  ALTER TABLE "BATCH_JOB_EXECUTION_CONTEXT" ADD CONSTRAINT "JOB_EXEC_CTX_FK" FOREIGN KEY ("JOB_EXECUTION_ID")
	  REFERENCES "BATCH_JOB_EXECUTION" ("JOB_EXECUTION_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BATCH_STEP_EXECUTION
--------------------------------------------------------

  ALTER TABLE "BATCH_STEP_EXECUTION" ADD CONSTRAINT "JOB_EXEC_STEP_FK" FOREIGN KEY ("JOB_EXECUTION_ID")
	  REFERENCES "BATCH_JOB_EXECUTION" ("JOB_EXECUTION_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BATCH_STEP_EXECUTION_CONTEXT
--------------------------------------------------------

  ALTER TABLE "BATCH_STEP_EXECUTION_CONTEXT" ADD CONSTRAINT "STEP_EXEC_CTX_FK" FOREIGN KEY ("STEP_EXECUTION_ID")
	  REFERENCES "BATCH_STEP_EXECUTION" ("STEP_EXECUTION_ID") ENABLE;
    
    CREATE TABLE ACQUIRER_SETTLEMENTS 
(
  CREDIT_CARD_NUMBER VARCHAR2(16 BYTE) NOT NULL 
, META_JOB_ID NUMBER(20, 0) NOT NULL 
, META_JOB_START_TIME VARCHAR2(100 BYTE) NOT NULL 
, META_PROCESSING_FILE VARCHAR2(100 BYTE) NOT NULL 
, META_ACQUIRER VARCHAR2(20 BYTE) NOT NULL 
, META_CHUNK_COMMIT_SIZE NUMBER(20, 0) NOT NULL 
, META_LINE_NUMBER NUMBER(20, 0) NOT NULL 
);

CREATE TABLE CONFIGURATION_PARAMETERS 
(
  KEY VARCHAR2(100 BYTE) 
, VALUE VARCHAR2(100 BYTE) 
);

CREATE SEQUENCE JOB_ID_SEQUENCE INCREMENT BY 1 MAXVALUE 9999999999 MINVALUE 1 CACHE 20;

Insert into CONFIGURATION_PARAMETERS (KEY,VALUE) values ('COMMIT_SIZE','5');
Insert into CONFIGURATION_PARAMETERS (KEY,VALUE) values ('LANDING_DIRECTORY','/home/batchconfig/batch/landing');
Insert into CONFIGURATION_PARAMETERS (KEY,VALUE) values ('SUCCESS_DIRECTORY','/home/batchconfig/batch/success');
Insert into CONFIGURATION_PARAMETERS (KEY,VALUE) values ('ERROR_DIRECTORY','/home/batchconfig/batch/errors');
Insert into CONFIGURATION_PARAMETERS (KEY,VALUE) values ('PROCESSING_DIRECTORY','/home/batchconfig/batch/processing');
commit;


