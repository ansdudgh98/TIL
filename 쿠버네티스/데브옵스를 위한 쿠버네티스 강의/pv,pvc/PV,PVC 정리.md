## Storage

### 볼륨
- 컨테이너가 외부 스토리지에 엑세스하고 공유하는 방법
- 포드의 각 컨테이너에는 고유의 분리된 파일 시스템 존재
- 볼륨은 포드의 컴포넌트이며 포드의 스펙에 의해 정의
- 독립적인 쿠버네티스 오브젝트가 아니면 스스로 생성, 삭제 불가
- 각 컨테이너의 파일시스템의 볼륨을 마운트하여 생성

### 볼륨의 종류
임시 볼륨 : emptyDir
로컬 볼륨(노드): hostpath, local -> 단점 노드가 달라지면 데이터가 달라짐
네트워크 볼륨: iSCSI,NFS,cephFS,glusterFS...
네트워크 볼륨(클라우드 종속적): gcePersistentDisk,awsEBS,azureFile....

### 실습
- EmptyDir
	```yaml
		apiVersion: v1
		
		kind: Pod
		
		metadata:
		
		name: count
		
		namespace: study
		
		spec:
		
		containers:
		
		- name: html-generator
		
		image: gasbugs/count
		
			volumeMounts:
		
		- name: html
		
			mountPath: /var/htdocs
		
		- name: html
		
			image: httpd
		
		volumeMounts:
		
			- name: html
			
			mountPath: /usr/local/apache2/htdocs
			
			readOnly: true
		
		ports:
		
			- containerPort: 80
			
			protocol: TCP
		
		volumes:
		
			- name: html
			
			emptyDir: {}
	```

### hostPath 볼륨
- 노드의 파일 시스템에 있는 특정 파일 또는 디렉터리 지정
- 영구 스토리지
- 다른 노드의 포드끼리 데이터 공유는 안됨
- 노드의 로그를 수집하는 용도로 많이 사용됨
**실습**
``` yaml

## 사전에 index.html파일이 생성되어있음

	apiVersion: v1

	kind: Pod
	
	metadata:
	
		name: count
	
		namespace: study
	
	spec:
	
		containers:
	
			- name: web-server
	
			  image: httpd
	
			volumeMounts:
	
				- name: html
	
				   mountPath: /usr/local/apache2/htdocs
	
				  readOnly: true
	
					ports:
					
					- containerPort: 80
					
					protocol: TCP
	
					volumes:
					
					- name: html
	
					hostPath:
					
					path: /var/htdocs
	
   
```	

