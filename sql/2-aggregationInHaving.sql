<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
<plist version="1.0">
<dict>
	<key>ContentFilters</key>
	<dict/>
	<key>auto_connect</key>
	<true/>
	<key>data</key>
	<dict>
		<key>connection</key>
		<dict>
			<key>database</key>
			<string>leetcode</string>
			<key>host</key>
			<string>localhost</string>
			<key>kcid</key>
			<string>-8086204013488500081</string>
			<key>name</key>
			<string>local</string>
			<key>rdbms_type</key>
			<string>mysql</string>
			<key>sslCACertFileLocation</key>
			<string></string>
			<key>sslCACertFileLocationEnabled</key>
			<integer>0</integer>
			<key>sslCertificateFileLocation</key>
			<string></string>
			<key>sslCertificateFileLocationEnabled</key>
			<integer>0</integer>
			<key>sslKeyFileLocation</key>
			<string></string>
			<key>sslKeyFileLocationEnabled</key>
			<integer>0</integer>
			<key>type</key>
			<string>SPSocketConnection</string>
			<key>useSSL</key>
			<integer>0</integer>
			<key>user</key>
			<string>root</string>
		</dict>
		<key>session</key>
		<dict>
			<key>connectionEncoding</key>
			<string>latin1</string>
			<key>contentFilter</key>
			<dict/>
			<key>contentPageNumber</key>
			<integer>1</integer>
			<key>contentSelection</key>
			<data>
			YnBsaXN0MDDUAQIDBAUGJCVYJHZlcnNpb25YJG9iamVjdHNZJGFy
			Y2hpdmVyVCR0b3ASAAGGoKgHCBMUFRYaIVUkbnVsbNMJCgsMDxJX
			TlMua2V5c1pOUy5vYmplY3RzViRjbGFzc6INDoACgAOiEBGABIAF
			gAdUdHlwZVRyb3dzXxAdU2VsZWN0aW9uRGV0YWlsVHlwZU5TSW5k
			ZXhTZXTSFwsYGVxOU1JhbmdlQ291bnQQAIAG0hscHR5aJGNsYXNz
			bmFtZVgkY2xhc3Nlc1pOU0luZGV4U2V0oh8gWk5TSW5kZXhTZXRY
			TlNPYmplY3TSGxwiI1xOU0RpY3Rpb25hcnmiIiBfEA9OU0tleWVk
			QXJjaGl2ZXLRJidUZGF0YYABAAgAEQAaACMALQAyADcAQABGAE0A
			VQBgAGcAagBsAG4AcQBzAHUAdwB8AIEAoQCmALMAtQC3ALwAxwDQ
			ANsA3gDpAPIA9wEEAQcBGQEcASEAAAAAAAACAQAAAAAAAAAoAAAA
			AAAAAAAAAAAAAAABIw==
			</data>
			<key>contentSortCol</key>
			<string>sid</string>
			<key>contentSortColIsAsc</key>
			<true/>
			<key>contentViewport</key>
			<string>{{0, 0}, {891, 568}}</string>
			<key>isToolbarVisible</key>
			<true/>
			<key>queries</key>
			<string>select sid, avg(score)
from sc
group by sid
having avg(score) &gt; 60;</string>
			<key>table</key>
			<string>SC</string>
			<key>view</key>
			<string>SP_VIEW_CUSTOMQUERY</string>
			<key>windowVerticalDividerPosition</key>
			<real>379</real>
		</dict>
	</dict>
	<key>encrypted</key>
	<false/>
	<key>format</key>
	<string>connection</string>
	<key>queryFavorites</key>
	<array/>
	<key>queryHistory</key>
	<array>
		<string>select sid, avg(score)
from sc
group by sid
having avg(score) &gt; 60</string>
		<string>select sid, avg(score)
from sc
having avg(score) &gt; 60</string>
		<string>select t1.id
from (select student.id, sc.score from student join sc on student.id = sc.sid where sc.cid = 1) t1, 
	(select student.id, sc.score from student join sc on student.id = sc.sid where sc.cid = 2) t2
where t1.score &gt; t2.score and t1.id = t2.id</string>
		<string>select t1.id
from (select student.id, sc.score from student join sc on student.id = sc.sid) t1, 
	(select student.id, sc.score from student join sc on student.id = sc.sid) t2
where t1.score &gt; t2.score and t1.id = t2.id</string>
		<string>select id
from (select student.id, sc.score from student join sc on student.id = sc.sid) t1, 
	(select student.id, sc.score from student join sc on student.id = sc.sid) t2
where t1.score &gt; t2.score and t1.id = t2.id</string>
		<string>select id
from (select student.id, sc.score from student join sc on student.id = sc.sid) t1, 
	(select student.id, sc.score from student join sc on student.id = sc.sid) t2
where t1.score &gt; t2.score</string>
		<string>select id
from (select student.id, sc.sid from student join sc on student.id = sc.sid) t1</string>
		<string>select id
from (select student.id, sc. from student join sc on student.id = sc.sid) t1</string>
		<string>from student join sc on student.id = sc.sid) t1</string>
		<string>select id
from (select student.id, sc.studentid from student join sc on student.id = sc.sid) t1</string>
		<string>select sid
from (select student.id, sc.studentid from student join sc on student.id = sc.sid) t1</string>
		<string>select studentid
from (select student.id, sc.studentid from student join sc on student.id = sc.sid) t1</string>
		<string>select student.id, sc.studentid
from (select student.id, sc.studentid from student join sc on student.id = sc.sid) t1</string>
		<string>select student.id, sc.studentid
from student, sc</string>
		<string>select student.id
from student</string>
		<string>select Student.Id, sc.score
from (select Student.Id, sc.score from student join sc on Student.Id = sc.studentid) t1</string>
		<string>select Student.Id, sc.score
from (select Student.Id, sc.score from student join sc on student.id = sc.studentid) t1</string>
		<string>select Student.Id, sc.score
from (select student.id, sc.score from student join sc on student.id = sc.studentid) t1</string>
		<string>select Student, sc.score
from (select student.id, sc.score from student join sc on student.id = sc.studentid) t1</string>
		<string>select student.Id, sc.score
from (select student.id, sc.score from student join sc on student.id = sc.studentid) t1</string>
	</array>
	<key>rdbms_type</key>
	<string>mysql</string>
	<key>rdbms_version</key>
	<string>5.7.11</string>
	<key>version</key>
	<integer>1</integer>
</dict>
</plist>
