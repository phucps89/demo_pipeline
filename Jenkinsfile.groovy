def COLOR_MAP = ['SUCCESS': 'good', 'FAILURE': 'danger', 'UNSTABLE': 'danger', 'ABORTED': 'danger']

pipeline {
    agent any 

    environment {
        SSH_INFO="logisoft@14.225.5.109"
        CW_DIR="/var/dev/web"
        CW_LARADOCK_DIR="/var/dev/web/laradock"
    }

    stages {
        stage('Example') {
            steps {
                sshagent (credentials: ['ssh-logisoft']) {
                    sh """
                        ssh -o StrictHostKeyChecking=no ${SSH_INFO} "
                        docker ps -a
                            cd ${CW_DIR}
                            cd lts_live/wms360/backend
                            git pull
                            cd ${CW_LARADOCK_DIR}
                            docker-compose exec -T -u laradock -w /var/www/lts_live/wms360/backend workspace bash -c "composer install"
                            docker-compose exec -T php-swoole supervisorctl restart swoole-lts-live
                            docker-compose exec -T php-worker supervisorctl restart worker-lts-live:
                        "
                    """
                }
            }
        }
    }
}
