# QAF-maven-example
This is sample QAS + maven  project in Java. It shows how to upload test result file on JIRA instance using [QMetry for JIRA - Test Management](https://marketplace.atlassian.com/plugins/com.infostretch.QmetryTestManager/cloud/overview).  


### Run test

please update these details in `pom.xml` file. 

<div id="automationFramework" class="border-top m-t-10 p-t-10"><div class="m-t-sm">
    <label class="bold">Step 1: Add the following to the &lt;build&gt; -&gt; &lt;plugins&gt; block in your
				pom.xml:</label> 
    <pre class="code-block"><code>&lt;build&gt;</code>
	<code>&lt;plugins&gt;</code>
		<code>&lt;plugin&gt;</code>
			<code>&lt;groupId&gt;org.apache.maven.plugins&lt;/groupId&gt;</code>
			<code>&lt;artifactId&gt;maven-surefire-plugin&lt;/artifactId&gt;</code>
			<code>&lt;version&gt;2.22.0&lt;/version&gt;</code>
			<code>&lt;configuration&gt;</code>
			    <code>&lt;properties&gt;</code>
					<code>&lt;property&gt;</code>
						<code>&lt;name&gt;listener&lt;/name&gt;</code>
						<code>&lt;value&gt;com.qmetry.automation.QAFResultUploader&lt;/value&gt;</code>
					<code>&lt;/property&gt;</code>
				<code>&lt;/properties&gt;</code>
			<code>&lt;/configuration&gt;</code>
		<code>&lt;/plugin&gt;</code>
	<code>&lt;/plugins&gt;</code>
<code>&lt;/build&gt;</code>
	</pre>   
    
</div>

<div class="m-t-sm">
    <label class="bold">Step 2: Add the following to the &lt;dependencies&gt; block in pom.xml:</label>
    <pre class="code-block"><code>&lt;dependencies&gt;</code>
    <code>&lt;dependency&gt;</code>
        <code>&lt;groupId&gt;com.qmetry&lt;/groupId&gt;</code>
        <code>&lt;artifactId&gt;automation&lt;/artifactId&gt;</code>
        <code>&lt;version&gt;2.0.2&lt;/version&gt;</code>
    <code>&lt;/dependency&gt;</code>
<code>&lt;/dependencies&gt;</code>
	</pre>
</div>

<div class="m-t-sm">
    <label class="bold">Step 3: Add the following to the &lt;repositories&gt; block in pom.xml like:</label>
    <pre class="code-block"><code>&lt;repositories&gt;</code>
	<code>&lt;repository&gt;</code>
		<code>&lt;id&gt;qmetrytestmanager-mvn-repo&lt;/id&gt;</code>
		<code>&lt;name&gt;QMetry Test Manager Maven Repository&lt;/name&gt;</code>
		<code>&lt;url&gt;https://raw.github.com/qmetry/qtm4j-maven-uploader/mvn-repo/&lt;/url&gt;</code>
	<code>&lt;/repository&gt;</code>
<code>&lt;/repositories&gt;</code>
	</pre>
</div>


<div class="m-t-sm">
    <label class="bold">Step 4: Add qmetry.properties file to root directory of your project</label>
</div>
<div class="m-t-sm">
	<label>Configure below properties:</label>
    <pre class="select-block code-block">
<code>automation.qmetry.enabled = true</code>
<code>automation.qmetry.debug = true</code>
<code>automation.qmetry.url=https://qtmcloud.qmetry.com/rest/api/automation/importresult</code>
<code>automation.qmetry.apikey = 366f41cf6659c66e02dddd965efd8fde002979b55e4d1f6b52908f93b82ad8487a7edb49262cd350009b89025f7546b7667765f80888b9308566e78b6120872</code>
<code>automation.qmetry.environment=env</code>
<code>automation.qmetry.build=build</code>
<code>automation.qmetry.attachfile=true</code>
<code>automation.qmetry.testCycleToReuse=NR-TR-1</code>
<code>automation.qmetry.testcycle.summary=summary</code>
<code>automation.qmetry.testcycle.labels=l1,l2,l3</code>
<code>automation.qmetry.testcycle.components=c1,c2,c3</code>
<code>automation.qmetry.testcycle.priority=High</code>
<code>automation.qmetry.testcycle.status=To Do</code>
<code>automation.qmetry.testcycle.sprintId=1242</code>
<code>automation.qmetry.testcycle.fixVersionId=14234</code>
<code>automation.qmetry.testcase.labels=l1,l2,l3</code>
<code>automation.qmetry.testcase.components=c1,c2</code>
<code>automation.qmetry.testcase.priority=priority</code>
<code>automation.qmetry.testcase.status=status</code>
<code>automation.qmetry.testcase.sprintId=34534</code>
<code>automation.qmetry.testcase.fixVersionId=35345</code>
	</pre>
</div>
<div class="m-t-sm">
    <label>if you are using on premise JIRA, then configure below properties as well:</label>
    <pre class="select-block code-block">
<code>#Add below property for Basic Authentication</code>
<code>automation.qmetry.authorization=Basic YWRtaW46YWRtaW4=</code><br />
<code>#Update below property to change server url</code>
<code>automation.qmetry.url=https://{JIRA Base URL}/rest/qtm4j/automation/latest/importresult</code>
	</pre>
    <label>Once the file is configured, the automation test results will get uploaded automatically whenever the user executes the automation project (e.g. using 'mvn test').</label>
</div>
</div>

After providing these details, you are ready to start test.

```
mvn test
```

It will generate `surefile-reports`. 

Addionally, right after test completion, test result file will be uploaded on your JIRA instance if you have provided correct details in properties file. 
