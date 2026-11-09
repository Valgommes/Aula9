pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
                junit 'target/surefire-reports/**/*.xml'
            }
        }
        stage('PMD Analysis') {
            steps {
                sh 'mvn pmd:check'
            }
        }
        stage('Deploy to Staging') {
            when {
                branch 'main'
            }
            steps {
                sh 'docker build -t myapp:${GIT_COMMIT} .'
                sh 'kubectl apply -f k8s/deployment.yaml'
            }
        }
    }
    post {
        failure {
            sh 'kubectl rollout undo deployment/myapp || true'
            slackSend channel: '#alerts', message: "Build Failed & Rollback executed: ${env.JOB_NAME}"
        }
    }
}