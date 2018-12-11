**OnlineFormatter** is a POC project which I have implemented for internal usage. This will work to identify the Unique error information from a bunch of log files in one shot.

It also has additional formatting tools like JSON, XML and SQL formatter. This tools will help to organized unordered data into proper structure with readable format.

The reason behind to implement this project is, in realtime projects we use to get the output of bunch of logs or JSON data of an object or a huge query which are not in proper readable format. In such cases we need to use any of online tools to make it into readable format. Posting clients data into open websites is not good as of I know. To overcome such issues, I have made this small project which you can deploy in any of your servers and will be used by a team or an organization which is an internal project.

ErrorLogger tool will be taken upto 10 file with each of 10 MB size in the format of TXT or LOG to find unique error information. There are some minimal changes required based on your LOGGER configuration. Like, starting format of log line. There may be different projects follows different type of formats.

JSON, XML and SQL formatters has been taken bunch of similar data as input and it provides the output as in the form of proper readable format.

Project Home page look a like,

![OnlineFormatter Home Page](https://github.com/Nallamachu/OnlineFormatter/blob/master/online%20formatter%20home%20page.JPG)

**Configuration:**

Download the source code and build the war file or download the readily available war file from target directory and deploy into any of web/application servers available.

**Errors:**
1. Increase the war file size: since the application war file size is bigger, you need to increase the war file size in web.xml file. For example, you are using tomcat to deploy the war file, you need to modify below values from the path of ```C:\apache-tomcat-8.5.35\webapps\manager\WEB-INF\web.xml```
    ```
    <multipart-config>
      <max-file-size>72428800</max-file-size>
      <max-request-size>72428800</max-request-size>
      <file-size-threshold>0</file-size-threshold>
    </multipart-config>
    ```
2. Temporarly uploaded log files will be store in the below path based on running OS,
    
    **For Windows: C:\Users\USER\Documents\logger\input\data
    
    **For UNIX/LINUX: /home/user/logger/input/data
    
    if that directory path is not available, please create the same to avoid the issues. Otherwise, you can also specify your own path in application web.xml prior to building war file.


**Note:** If anyone interested to contribute to upgrade the application into new technologies like Angular/React/VieJS, please let me know. 
