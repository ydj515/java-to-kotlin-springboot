# Springboot java to Kotlin porting sample
2.x버전의 springboot 프로젝트를 kotlin springboot 프로젝트로 포팅하는 과정을 기록

## Environment
- java 11
- springboot 2.1.8

## Caution
### git history
**.java 파일을 .kt로 변경하는 작업을 진행할 경우 .java 파일의 git history가 .kt파일에는 적용이 되지 않음을 유의.**

> intellij의 git 기능을 사용하는 경우 history를 살릴 수 있는 장점이 있으나 Rename .java to .kt라는 커밋이 생김.

- example  

    ![git-history-example.PNG](git-history-example.PNG)

 