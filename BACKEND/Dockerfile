#FROM jboss/wildfly.jdk8:16.0.0.Final
USER root
ADD target/ /opt/jboss/wildfly/standalone/deployments/
RUN rm -rf /etc/localtime
RUN ln -s /usr/share/zoneinfo/Asia/Ho_Chi_Minh /etc/localtime
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]