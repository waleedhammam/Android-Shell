# Android-Shell
Executing Linux commands on android is an advanced method to gain access to restricted features in phone that you can't get directly from programing for example; recording screen, deleting corrupted files, getting system info, processes, hardware information. There are some commands that won’t work unless you have a rooted device.
To do so, we can make it directly by opening another process that uses shell or using a library to handle all corner cases. Also, it can be interactive if you want.

## Direct Method
This method directly access the system command file app, such as echo; ls; pwd; .. etc. and provides it with one parameter. IT CONSIDERS THE WHOLE INPUT AS 1 Argument. For example:
This snippet just ls the sd card and returns result into a variable.
~~~
try {

    // Executes the command.

    Process process = Runtime.getRuntime().exec("/system/bin/ls /sdcard");

    // Reads stdout.
    // NOTE: You can write to stdin of the command using
    //       process.getOutputStream().
    BufferedReader reader = new BufferedReader(
            new InputStreamReader(process.getInputStream()));
    int read;
    char[] buffer = new char[4096];
    StringBuffer output = new StringBuffer();
    while ((read = reader.read(buffer)) > 0) {
        output.append(buffer, 0, read);
    }
    reader.close();

    // Waits for the command to finish.
    process.waitFor();

    return output.toString();
} catch (IOException e) {

    throw new RuntimeException(e);

} catch (InterruptedException e) {

    throw new RuntimeException(e);
}
~~~
## Library <br/>

	Chainfire the company who introduced SuperUser and SuperSU made a great library to handle all these stuffs just like a pie. Install the library and it just works!
### INSTALLATION <br/>
	Installation is easy just copy this line  
~~~
compile 'com.jrummyapps:android-shell:1.0.1'
~~~
<br/>
and add it to build.gradle file (App level) in the project <br/>


## USAGE
```
Shell.run(String shell, String... commands)
Shell.SH.run(String... commands)
Shell.SU.run(String... commands)
```

<br/>
These return a CommandResult DataType, it has an exit code to check too 
<br/>
Example: 
<br/>

~~~
	CommandResult result = Shell.SU.run("id");
	if (result.isSuccessful()) {
	  System.out.println(result.getStdout());
	  // Example output on a rooted device:
	  // uid=0(root) gid=0(root) groups=0(root) context=u:r:init:s0
	}
~~~

<br/>
In our case we just want to execute an order so we do  <br/>
Shell.SH.run(``` the command here as a string ```); <br/>
It can be saved in a variable or checked on whatever you want <br/>
CommandResult result = Shell.SH.run(input.getText().toString()); <br/>

## Rooted Devices <br/>
	Rooted devices gives you more privileges to get its benefits instead use 
<br/>
Shell.SU.run(String... commands) <br/>

```
```
## To download APK Check github releases
## Don't forget to clean/rebuild project if you are modifying it on your machine
## Credits
Many Thanks: Dr Mostafa Said 

Thanks:</br>
	https://github.com/jrummyapps/android-shell </br>
  https://stackoverflow.com/a/5686992/5380417 </br>
  https://www.learn2crack.com/2014/03/android-executing-shell-commands.html
