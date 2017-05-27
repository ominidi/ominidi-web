# Ominidi.org
> Gli ominidi, noti anche come grandi scimmie, sono una famiglia di primati risalente al Miocene inferiore, alla quale appartiene l'uomo.

[![Build Status](https://travis-ci.org/ominidi/ominidi-web.svg?branch=master)](https://travis-ci.org/ominidi/ominidi-web) [![codecov](https://codecov.io/gh/ominidi/ominidi-web/branch/master/graph/badge.svg)](https://codecov.io/gh/ominidi/ominidi-web)

### Description

The official repository for [https://www.ominidi.org](https://www.ominidi.org).  

### Installation and run

Clone the repository, then install all application's dependencies:

    $ mvn install && yarn install
    
Build javascript package:

    $ gulp build

Launch application's tests with:

	$ mvn test && gulp test

Run the application:

	$ java -Dspring.profiles.active=test -jar target/ominidi-web-1.0-SNAPSHOT.jar
	