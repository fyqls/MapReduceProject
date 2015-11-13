#! /usr/bin/env bash
RUNHOME=..

JAVA=$JAVA_HOME/bin/java
BINDIR=`pwd`

#CONF_DIR=./conf/
#CLASSPATH="${CONF_DIR}"
CLASSPATH=$JAVA_HOME/lib/tools.jar

for f in ${RUNHOME}/lib/*.jar; do
  CLASSPATH=${CLASSPATH}:$f;
done

for f in /usr/lib/hadoop*/*.jar; do
  CLASSPATH=${CLASSPATH}:$f;
done

for f in /usr/lib/hadoop/lib/*.jar; do
  CLASSPATH=${CLASSPATH}:$f;
done

#CLASSPATH=/etc/hadoop/conf:../..//conf:$CLASSPATH
CLASSPATH=/etc/hadoop/conf:/etc/hdfs1/conf:/etc/yarn1/conf:$CLASSPATH
#echo $CLASSPATH

java -cp $CLASSPATH lisong.qiu.WordCount "$@"

