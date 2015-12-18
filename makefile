# (c) 2015 Wojciech A. Koszek <wojciech@koszek.com>

JAVAC=javac
JAVA=java

SRCS:=$(wildcard *.java)
OBJECTS:=$(SRCS:.java=.jar)
TESTDATA:=$(SRCS:.java=.t)

all: objs test
objs: $(OBJECTS)
test: $(TESTDATA)

%.jar: %.java
	$(JAVAC) $<
	jar cvfe $@ $(basename $@) $(basename $@).class

%.t: %.jar
	$(JAVA) -jar $< | tee $@

clean:
	rm -rf *.jar *.class *.t
