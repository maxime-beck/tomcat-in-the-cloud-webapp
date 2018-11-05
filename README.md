# Tomcat Source-to-Image (s2i)

[Download and install s2i](https://github.com/openshift/source-to-image/releases)

Start by pulling the s2i builder image:
```sh
docker pull sarcouy/s2i-tomcat:8.5-jdk8-mvn3.5.0
```

Then simply build your sources using `s2i build` with the following parameters:
```sh
s2i build [REPO_URL|LOCAL_PATH] [S2I_IMAGE] [NAME_OF_RESULTING_IMAGE] --env WAR_NAME=[NAME_OF_WAR_AFTER_BUILD]
```

You can try it out using the following command:
```sh
s2i build https://github.com/maxime-beck/tomcat-in-the-cloud-webapp.git sarcouy/s2i-tomcat:8.5-jdk8-mvn3.5.0 titctest --env WAR_NAME=tomcat-in-the-cloud-webapp.war
```
This will create an image nammed `titc-image` with your sources built and integrated to tomcat all ready for deployment to your favorite cloud provider.

## References
DockerHub of prototype s2i-tomcat:         
https://hub.docker.com/r/sarcouy/s2i-tomcat/

Github of prototype s2i-tomcat:         
https://github.com/Sarcouy/s2i-tomcat

Simple JEE application for testing:         
https://github.com/jboss-openshift/openshift-examples/tomcat-helloworld
