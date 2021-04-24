pipeline {
    agent {
        label 'jenkins-agent'
    }

    triggers {
        githubPush()
    }

    stages {
        stage('Build') {
            steps {
                sh '''
                    echo 'Building ...'
                    mvn clean install -DskipTests --batch-mode -Dstyle.color=always
                '''
            }
        }

        stage('Test') {
            steps {
                sh '''
                    echo 'Testing'
                    mvn clean verify --batch-mode -Dstyle.color=always
                '''
            }
        }

        stage('Release') {
            steps {
                withDockerRegistry(credentialsId: '5d633ea9-05d5-4038-bf63-a723025b95ff', url: 'https://docker.rcomanne.nl') {
                    sh '''
                        echo 'Releasing artifact'
                        mvn clean deploy -DskipTests --batch-mode -Dstyle.color=always
                    '''
                }
            }
        }

        stage('Deploy') {
            steps {
                withKubeConfig(credentialsId: 'ce42c69e-6274-4126-93f8-4339dfd0ad85', namespace: 'services') {
                    sh '''
                        echo 'Deploying...'
                        sed -i "s/homepage-service:latest/homepage-service:${BUILD_ID}/g" kubernetes/01-deployment.yaml
                        kubectl apply -f kubernetes/
                        kubectl rollout status deployment homepage-service
                    '''
                }
            }

        }
    }
}