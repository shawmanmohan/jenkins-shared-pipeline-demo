# jenkins-shared-pipeline-demo

A shared library is a collection of independent Groovy scripts which you pull into your Jenkinsfile at runtime.

What’s inside a Shared Library

Inside your Library you’ll probably have two types of common code.
1) **Steps**: These are called Global Variables in Jenkins terminology.
These are the custom steps that you want to be available to all your Jenkins pipelines.

For example, you might write a standard step to deploy an application, or perform a code review. 
To do this, add your code into vars/YourStepName.groovy and then implement a def call function:

```groovy
#!/usr/bin/env groovy
// vars/YourStepName.groovy

def call() {
  // Do something here...
}
```

2) **Other common code**: This might include helper classes, or common code that you might want to include inside pipeline steps themselves (meta!). 
You could also use it as a place to store static constants that you use throughout your pipelines.
Code like this needs to go in the src/your/package/name directory, and then you can use normal Groovy syntax, e.g.:
This file in example is called GlobalVars.groovy and resides in com/mashaw/GlobalVars.groovy

```groovy
#!/usr/bin/env groovy
package com.mashaw

class GlobalVars {
   static String foo = "bar"
}
```

Note: You can then import this class into your Jenkinsfile and reference the static variable like GlobalVars.foo

**Points to Consider Before starting to code** :shipit:

Each of your custom steps is a different .groovy file inside your vars/ directory. 
In Jenkins terminology, these are called Global Variables, which is why they are located inside vars/.
So for instance a code checkout stage will be a seperate groovy file in the vars/ directory. Another example, Hipchat notification will be a sperarate groovy file in the vars/ directory

Create a file for your custom step, and fill in the code. For example, a simple greeting function would look like this:

In the below example , I created a new file in vars directory ,  vars/sayHello.groovy

```groovy
#!/usr/bin/env groovy

def call(String name = 'human') {
  echo "Hello, ${name}."
}
```

> Notice how the Groovy script must implement the call method. 
> Then you should write your custom code within the braces { }. 
> You can also add parameters to your method - the example above has one parameter name, with a default value of human.


Using the newly created library in Jenkinsfile, once you have imported the Jenkins library , write code as below

``` groovy
@Library('pipeline-library-demo')_

stage('Demo') {
    echo 'Hello world'
    sayHello 'Dave'
}
```
