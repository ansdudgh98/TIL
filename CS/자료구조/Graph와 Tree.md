### 1.Graph 
- 두 대상 사이 관계를 나타낼 수 있는 자료구조
- 좌측 그림에서 동그란 점들이 꼭짓점 vertex이 되며, 점끼리 이어진 선들이 모서리 Edge가 됨
**walk**
- 두 꼭짓점을 잇는 모서리가 존재하는 경우 둘을 인접한다고 정의
- 인접한 꼭짓점을 따라 이동한 족적이 곧 walk
열린 walk와 닫힌 walk
- 시작점과 끝 점이 동일한 경우 닫힌 walk이며 다른 경우 열린 walk
**path**
- walk 가운데 중복된 꼭짓점이 존재하지 않는 것을 path라 함
**cycle**
- 닫힌 walk와 path의 조건을 모두 만족하는 경우 이를 cycle이라 함(단 시작점 끝점이 중복되는 것은 무시
### 2. Tree
- 다음의 두 조건을 만족하는 경우를 Tree라 칭함
		![[Pasted image 20240102151256.png|300]]
	1. 주어진 Graph는 연결 Graph
	2. 주어진 Graph는 cycle을 가지지 않음
- 좌측 Tree에서 개별 원을 Node라 하며, 각 원들은 부모 Node 및 자식 Node의 관계로 이어져 있음

- Root Node와 Leaf Node(단말 노드)
	- 부모 Node를 갖지 않는 Node는 Root Node
	- 자식 Node를 갖지 않는 Node는 Leaf Node 한편, Leaf Node가 아닌 모든 Node를 내부 Node라 함
- 이진 Tree
	- 모든 Node가 최대 2개의 자식 Node를 갖는 Tree
- 포화 이진 Tree(Perfect Binary Tree)
	 ![[Pasted image 20240102152401.png|300]]
	- 모든 곳이 빈틈없이 채워진 이진 Tree를 일컬음
	- 모든 내부 Node의 자식이 둘이며, 모든 Leaf Node의 깊이가 동일한 이진 Tree
	- 높이가 n 일때 1+2+4+...+2^n => 2^n+1-1의 노드를 가짐
- 완전 이진 Tree(Complete Binary Tree)
	  ![[Pasted image 20240102152442.png|300]]
	- Perfect Binary Tree에서 Node의 일부를 적당히 제거한다면?
	- Tree의 최 하단을 제외한 영역은 Perfect Binary Tree를 이루며, 최 하단의 모든 Node는 좌측에 몰려 있는 경우 완전 이진 Tree
### 3. Heap
- 다음 조건을 만족하는 이진 Tree를 이진 Max Heap이라 칭함
		![[Pasted image 20240102152654.png|300]]
	- 주어진 Tree는 완전 이진 Tree
	- 모든 부모 Node는 자신의 자식 Node보다 큰 값을 가짐
- 모든 부모 Node가 자신의 자식 Node보다 작은 값을 가지는 경우, 해당 이진 Tree는 Min Heap이라 칭함
- 데이터 삽입
	- Heap은 완전 이진 Tree를 따르므로 최초 삽입 위치는 고정
	- Max Heap의 원리를 깨지 않게끔, 삽입된 Node를 움직임
- Heap에서의 Root Node 제거
	- 이진 Tree 전체가 무너질 수 없으므로, 기존 Node중 하나가 Root Node로 대체 되어야 함
	- 완전 이진 Tree의 규칙을 깨지 않게끔, 최하단 최우측 Node를 Root Node로 대체한 후 위치 조정 
- 구현
	- 일반적인 이진 Tree의 경우, Node의 위치가 고정되어 있지 않으므로 Node마다 index를 매기는 접근법을 적용하기 어려움
	- Heap은 완전 이진 Tree이므로 Node의 배치 순서가 모호하지 않음 -> 동적 배열을 활용하여 Heap을 구현하는 것이 가능
### 우선 순위 Queue(**Prioirty Queue**)
![[Pasted image 20240102153238.png|300]]
- 일반적인 Queue는 먼저 들어온 데이터가 가장 먼저 나가는 FIFO의 양상을 띠는 자료구조임
- 우선순위 Queue는 들어온 순서가 무관하게 우선순위가 높은 원소부터 먼저 pop됨
- 동적 배열을 활용하여 우선순위 Queue를 구현한다고 가정
	=> 새로운 원소가 들어올 때마다 append만 하면 되므로 삽입에는 O(1) 소요
- 문제는, 우선순위 Queue의 핵심인 pop작업을 수행하는데 드는 시간 복잡도
	=> 우선순위의 최댓값을 직접 찾아야 하므로, 순차 탐색 기준 최악의 경우 O(N) 소요
- Heap을 이용한 우선순위 Queue의 구현
	- Heap은 하나의 원소를 삽입할 때도, Root Node를 삭제할 때도 O(logN)의 시간복잡도를 가진다는 특성을 지님
	- 따라서, Heap을 이용해서 우선순위 Queue를 구현할 경우 삽입과 삭제를 모두 빠르게 안정적으로 수행할  수 있음


### 이진 Tree의 구현과 데이터 순회
- 좌측과 같은 Heap의 경우, 애당초 완전 이진 Tree의 성질을 가지므로 index의 논리를 적용해 동적 배열로 나타내는 것이 가능했음
- 일반적 이진 Tree의 경우, 노드의 갯수가 같더라도 그 구조가 하나로 확정되지 않으므로, 구현에 있어 다른 차원의 접근이 필요함
**level-order Traversal**
- 동일한 깊이를 가지는 Node를 좌측부터 차례차례 방문하고 모두 순회한 경우 아래로 한 단계 내려가는 순회방법

**너비 우선 탐색(Breadth First Search)**
- 인접한 노드를 우선 방문
- Level-order 순회
- Queue를 이용하여 구현

**깊이 우선 탐색**(Depth First Search)*
- 갈 수 있는 가장 깊은 곳 까지
- Pre/In/Post-order 순회
- 재귀를 이용하여 구현 

**Tree와 SubTree**
- 왼쪽 Tree에서 Root Node는 좌우측 자식 Node를 모두 지니며, 좌측 지식을 Root Node로 하는 또 다른 Tree를 생각할 수 있 음
- 주어진 Tree에 대하여, Root Node의 좌측 자식을 새로운 Root Node로 삼는 Tree를 왼쪽 Subtree라고 정의

![[Pasted image 20240102155123.png|400]]
**전위 순회(Pre-order Traversal)**
- Root Node > 왼쪽 Sub Tree > 오른쪽 Sub Tree
**중위 순회(In-order Traversal)** 
- 왼쪽 Sub Tree > Root Node > 오른쪽 Sub Tree
**후위 순회(Post-order Traversal)**
- 왼쪽 Sub Tree > 오른쪽 Sub Tree > Root Node

**이진 탐색 Tree의 뜻**
	![[Pasted image 20240102160507.png|300]]
- 다음의  두 조건을 만족하는 이진 Tree를 이진 탐색 Tree라 정의
	(1)임의의 Node의 좌측 Sub Tree에는 자신보다 작은 값만이 존재
	(2)임의의 Node의 우측 Sub Tree에는 자신보다 큰 값만 존재
	**이진 탐색 Tree에서의 원소 삽입**
	(1) 주어진 이진 탐색 Tree의 Root Node로 부터 출발 삽입하고자 하는 값과 현재 Node의 값을 반복하여 비교
	(35삽입) 45 L -> 23 R -> 38 L -> 33 R -> 완료
	(10 삽입) 45 L -> 23 L -> 11 L -> 완료
	(82 삽입) 45 R -> 59 R -> 완료
	**이진 탐색 Tree의 원소 제거**
	제거 하고자 하는 대상 Node가 자식 노드를 가지는 지 머전 확인 (자식없음/ 좌측자식만 있음/ 우측 자식만 있음/ 모두있음)
**이진 트리의 근원적 한계**
- 노드가 N개인 이진 탐색 Tree에서, 삽입-삭제-탐색에 드는 시간 복잡도는 최악의 경우 공히 O(N)
	 
		
	

### AVL Tree
**정의**
1. 이진 탐색 트리의 성질을 충족함과 동시에 모든 Node의 Balance Factor 절대값이 1 이하인 경우 Adleson-Velsky, Landis의 앞글자를 따 AVL Tree로 명명

**Balance Factor**
	-  임의의 Node에 대하여 다음을 Balance Factor로 정의(좌측 Subtree의 높이) - (우측 Subtree의 높이)
**삽입**
- 이진 탐색 트리의 성질에 입각하여 우선 삽입
- 삽입된 노드에서 시작하여 Root Node에 이르기까지 Balance Factor의 절대값이 1을 넘는 Node가 하나라도 존재하는지 추적
- AVL Tree의 성질을 깨는 Node를 발견한 경우 즉시 Tree 균형화 과정을 수행


### Red-Black Tree의 이해
- 일반적으로 이진 Tree의 Node는 값과 left 및 right를 가지는데 left나 right 중 하나 이상이 None일 수 있음
- 모든 None을 NIL로 규정하면, 좌측과 같은 Tree를 얻을 수 있음 -> 모든 리프 Node는 NIL이 되며 값을 가지는 모든 Node는 내부 Node가 됨
- 모든 Node가 Red/Black이며 다음을 모두 만족하는 이진 탐색 Tree
	1. Root Node와 NIL은 모두 Black
	2. Root Node에서 임의의 NIL까지 경로에서 RED는 연속불가
	3. Root Node에서 임의의 NIL까지 경로에서 BLACK수는 동일
### B Tree
다음을 모두 만족하면 m차 B-Tree
1. 모든 리프 노드의 깊이가 동일
2. 노드 당 자식 수는 (m/2) ~ m개
3. 자식 노드 수는 데이터 수보다 1많은
4. 단일 노드 내에서 데이터는 정렬됨
5. 트리의 관점에서도 데이터는 정렬됨
**삽입**
데이터 수 제한을 넘어서지 않는 경우에서의 삽입
1. 탐색에서와 유사한 방법으로, 새 데이터가 들어갈 적절한 리프 노드를 선정
2. 해당 리프 노드에 데이터가 추가될 여유가 있는 경우, 그대로 삽입을 수행
데이터 수 제한을 넘어서는 경우에서의 삽입
- 리프 노드에 데이터가 삽입될 여우가 없을 경우, 가운데 데이터를 튕겨내는 과정을 반복
- 이 과정에서 튕겨 나가는 데이터의 좌우 값을이 분리 된다는 점을 유의









