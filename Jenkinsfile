pipeline {
  agent none
  stages {
    stage('') {
      steps {
        parallel(
          "xx1": {
            sh 'echo "hello world.."'
            
          },
          "xx2": {
            echo 'hahaha'
            
          }
        )
      }
    }
    stage('yyy1') {
      steps {
        echo 'xxxxx'
      }
    }
  }
}