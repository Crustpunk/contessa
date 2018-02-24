.PHONY: test start start-maria debug

test:
	@mvn clean verify

start:
	@mvn spring-boot:run -Dcontessa.base-dir=target/

start-maria:
	@mvn spring-boot:run -Dcontessa.base-dir=target/ -Dspring.profiles.active=mariadb

start-minio:
	@mvn spring-boot:run -Dcontessa.base-dir=target/ -Dspring.profiles.active=minio

debug:
	@mvnDebug clean spring-boot:run -Ddebug=true -Dcontessa.base-dir=target/
