-- This script was generated by the ERD tool in pgAdmin 4.
-- Please log an issue at https://github.com/pgadmin-org/pgadmin4/issues/new/choose if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE IF NOT EXISTS public."GPU"
(
    "ID" bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    "Name" text COLLATE pg_catalog."default",
    "CapacityMB" bigint,
    "VideoProcessor" text COLLATE pg_catalog."default",
    "Report_ID" bigint,
    CONSTRAINT "GPU_pkey" PRIMARY KEY ("ID")
);

CREATE TABLE IF NOT EXISTS public."Report"
(
    "ID" integer NOT NULL,
    "InformationOSID" bigint,
    "RAMInfoID" bigint,
    "DateTime" date,
    "Location_ID" bigint,
    CONSTRAINT "Report_pkey" PRIMARY KEY ("ID")
);

CREATE TABLE IF NOT EXISTS public."InformationOS"
(
    "ID" bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    "NetworkName" text COLLATE pg_catalog."default",
    "OperatingSystem" text COLLATE pg_catalog."default",
    "OperatingSystemVersion" text COLLATE pg_catalog."default",
    "SerialNumber" text COLLATE pg_catalog."default",
    "RegisteredUser" text COLLATE pg_catalog."default",
    "RegionCode" bigint,
    "UUID" uuid,
    CONSTRAINT "InformationOS_pkey" PRIMARY KEY ("ID")
);

COMMENT ON TABLE public."InformationOS"
    IS 'Таблица которая хранит следующую информацию об операционной системе компьютера: Сетевое имя, Наименование, Версия, Серийный номер, Зарегестрированный пользователь, Код страны или региона, Уникальный номер UUID.';

CREATE TABLE IF NOT EXISTS public."Location"
(
    "ID" bigint NOT NULL,
    "City" text COLLATE pg_catalog."default",
    "Street" text COLLATE pg_catalog."default",
    "House" text COLLATE pg_catalog."default",
    "Cabinet" text COLLATE pg_catalog."default",
    CONSTRAINT "Location_pkey" PRIMARY KEY ("ID")
);

CREATE TABLE IF NOT EXISTS public."RAMInfo"
(
    "ID" bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    "TotalCapacityMB" bigint,
    "CountOfRam" bigint,
    CONSTRAINT "RAMInfo_pkey" PRIMARY KEY ("ID")
);

CREATE TABLE IF NOT EXISTS public."LANCard"
(
    "ID" bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    "Name" text COLLATE pg_catalog."default",
    "MACAddress" macaddr,
    "Type" text COLLATE pg_catalog."default",
    "Report_ID" bigint,
    CONSTRAINT "LANCard_pkey" PRIMARY KEY ("ID")
);

CREATE TABLE IF NOT EXISTS public."Processor"
(
    "ID" bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    "Name" text COLLATE pg_catalog."default",
    "Connector" text COLLATE pg_catalog."default",
    "Description" text COLLATE pg_catalog."default",
    "SpeedMHz" bigint,
    "Report_ID" bigint,
    CONSTRAINT "Processor_pkey" PRIMARY KEY ("ID")
);

CREATE TABLE IF NOT EXISTS public."Motherboard"
(
    "ID" bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    "Manufacturer" text COLLATE pg_catalog."default",
    "Model" text COLLATE pg_catalog."default",
    "SerialNumber" text COLLATE pg_catalog."default",
    "Status" text COLLATE pg_catalog."default",
    "Report_ID" bigint,
    CONSTRAINT "Motherboard_pkey" PRIMARY KEY ("ID")
);

CREATE TABLE IF NOT EXISTS public."HDD"
(
    "ID" bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    "Model" text COLLATE pg_catalog."default",
    "CountOfPartition" bigint,
    "SizeGB" bigint,
    "Interface" text COLLATE pg_catalog."default",
    "Report_ID" bigint,
    CONSTRAINT "HDD_pkey" PRIMARY KEY ("ID")
);

CREATE TABLE IF NOT EXISTS public."LogicalDrive"
(
    "ID" bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    "Name" text COLLATE pg_catalog."default",
    "FileSystem" text COLLATE pg_catalog."default",
    "CapacityGB" bigint,
    "FreeSpaceGB" bigint,
    "Report_ID" bigint,
    CONSTRAINT "LogicalDrive_pkey" PRIMARY KEY ("ID")
);

CREATE TABLE IF NOT EXISTS public."RAM"
(
    "ID" bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    "CapacityMB" bigint,
    "Location" text COLLATE pg_catalog."default",
    "Manufacturer" text COLLATE pg_catalog."default",
    "PartNumber" text COLLATE pg_catalog."default",
    "SerialNumber" text COLLATE pg_catalog."default",
    "Identifier" text COLLATE pg_catalog."default",
    "Report_ID" bigint,
    CONSTRAINT "RAM_pkey" PRIMARY KEY ("ID")
);

ALTER TABLE IF EXISTS public."GPU"
    ADD CONSTRAINT "GPU_fkey" FOREIGN KEY ("Report_ID")
    REFERENCES public."Report" ("ID") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Report"
    ADD CONSTRAINT "InformationOS_fkey" FOREIGN KEY ("InformationOSID")
    REFERENCES public."InformationOS" ("ID") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Report"
    ADD CONSTRAINT "Location_fkey" FOREIGN KEY ("Location_ID")
    REFERENCES public."Location" ("ID") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Report"
    ADD CONSTRAINT "RAMInfoID_fkey" FOREIGN KEY ("RAMInfoID")
    REFERENCES public."RAMInfo" ("ID") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."LANCard"
    ADD CONSTRAINT "LANCard_fkey" FOREIGN KEY ("Report_ID")
    REFERENCES public."Report" ("ID") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Processor"
    ADD CONSTRAINT "Processor_fkey" FOREIGN KEY ("Report_ID")
    REFERENCES public."Report" ("ID") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Motherboard"
    ADD CONSTRAINT "Motherboard_fkey" FOREIGN KEY ("Report_ID")
    REFERENCES public."Report" ("ID") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."HDD"
    ADD CONSTRAINT "HDD_fkey" FOREIGN KEY ("Report_ID")
    REFERENCES public."Report" ("ID") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."LogicalDrive"
    ADD CONSTRAINT "LogicalDrive_fkey" FOREIGN KEY ("Report_ID")
    REFERENCES public."Report" ("ID") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."RAM"
    ADD CONSTRAINT "RAM_fkey" FOREIGN KEY ("Report_ID")
    REFERENCES public."Report" ("ID") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

END;