pipeline {
    agent any
    
    environment {
        DOCKERHUB_REPO = 'jtan22/microservice-owner'
        DOCKERHUB_CREDENTIAL = 'dockerhub'
    }

    stages {
        stage('Build Package') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Get Project Version') {
            steps {
                script {
                    env.PROJECT_VERSION = sh(script: "mvn help:evaluate -Dexpression=project.version -q -DforceStdout", returnStdout: true).trim()
                    if (env.BRANCH_NAME == 'main') {
                        env.PROJECT_VERSION = env.PROJECT_VERSION.replace('-SNAPSHOT', '')
                    }
                }
            }
        }
        stage('Build Image') {
            steps {
                script {
                    app = docker.build("${DOCKERHUB_REPO}:${env.PROJECT_VERSION}")
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', DOCKERHUB_CREDENTIAL) {
                        app.push("${env.PROJECT_VERSION}")
                        if (env.BRANCH_NAME == 'main') {
                            app.push("latest")
                        }
                    }
                }
            }
        }
        stage('Deploy Image') {
            steps {
                sh "sed -i '' 's/\${PROJECT_VERSION}/${env.PROJECT_VERSION}/g' deployment.yaml"
                sh 'kubectl apply -f deployment.yaml'
            }
        }
        stage('Increment Version') {
            when {
                branch 'main'
            }
            steps {
                sh 'git checkout main'
                sh 'mvn build-helper:parse-version versions:set \
                    -DnewVersion=`mvn help:evaluate -Dexpression=project.version -q -DforceStdout | sed -e "s/-SNAPSHOT//" -e "s/\\([0-9]*\\.[0-9]*\\.[0-9]*\\)/\\1+1/"`-SNAPSHOT versions:commit'
                sh 'git commit -am "Increment version [skip ci]"'
                sh 'git push origin main'
            }
        }
    }
}