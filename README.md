### Spring Boot Auto Configuration Unit Tests [![Build Status](https://travis-ci.org/sgyyz/autoconfig-test.svg?branch=master)](https://travis-ci.org/sgyyz/autoconfig-test)
When we create our custom auto configuration in spring boot application, we don't know whether is 
it work like we expect or not, so in this repository will show some example of how to test them in 
test cases before using it in real application.

In this repository, it include 3 types of `ConditionalOnxxx` unit tests:
1. `ConditionalOnClass`
2. `ConditionalOnBean`
3. `ConditionalOnProperty`

**Special** In `ConditionalOnClass` unit test, it brings in `HideClassesLoader` to 
mock the class is not in the classpath cases.