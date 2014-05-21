#!/bin/sh
java -jar jasmin.jar ByteCode.j
javap -c -verbose -private HelloWorld.class > ByteCodeJava.txt
java HelloWorld
exit
