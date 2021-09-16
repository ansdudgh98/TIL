# 2장 순환

## 순환

- 정의 : 어떤 알고리즘이나 함수가 자기 자신을 호출하여 문제를 해결하여 프로그래밍 기법이다.

- 내부적인 구현 : 프로그래밍에서는 자기 자신을 다시 호출하는 것은 다른 함수를 호출하는 것이 동일하여 순환호출이 계속 중첩될수록 시스템 스택에는 활성 레코드들이 쌓이게 됨

## 순환 알고리즘의 구조

- 순환 알고리즘은 아래의 예와 같이 자기 자신을 호출하는 부분과 순환 호출을 멈추는 부분으로 구성되어 있다.

- 순환 호출을 멈추는 부분이 없다면 시스템 스택을 다 사용할 때 까지 순환적으로 호출되다가 오류를 내면서 멈춤

```c
int factorial(int n){
    if(n <= 1) return (1); //순환을 멈추는 부분
    else return (n * factorial(n-1)); // 순환 호출을 하는 부분
}
```

## 순환의 예

1. 팩토리얼

순환적인 팩토리얼 계산 프로그램
```c
int factorial(int n){
    if(n <= 1) return (1);
    else return (n * factorial(n-1));
}
```

2. 거듭제곱의 계산

반복적인 거듭제곱 계산 프로그램
```c
double slow_power(double x,int n){
    int i;
    double reult = 1.0 ;

    for(i=0;i<n;i++)
        result = result * x;
    
    return (result)
}
```

순환적인 거듭제곱 계산 프로그램
```c
double power(double x,int n){
    if(n==0) return 1;
    
}

```
