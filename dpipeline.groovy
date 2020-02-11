      pipeline {
        agent any 
        stages {
          stage('Build') { 
            steps {
              git credentialsId: 'a8d4eb27-bcb1-4811-81d1-80e1852f68f4', url: 'git@github.com:kamal-kant-jangir/demo_git.git'
            }
          }
          stage('Test') { 
            steps {
                    sh label: '', script: '''pwd
ls'''
            }
          }
          stage('Deploy') { 
            steps {
              echo 'the end'
            }
          }
        }
      }