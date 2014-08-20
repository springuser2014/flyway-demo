#!/bin/bash

psql -U mark -d template1 -c "drop database if exists flyway;"

psql -U mark -d template1 -c "create database flyway;"

psql -U mark -d flyway -c "create schema transport"

psql -U mark -d flyway -f src/main/resources/db/migration/V1__base_version.sql
