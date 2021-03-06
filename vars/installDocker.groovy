def call() {
    sh '''
        sudo yum -y install git epel-release
        sudo yum -y install '/usr/bin/aws'
        curl -fsSL get.docker.com -o get-docker.sh
        env -i sh get-docker.sh || sudo yum -y install docker
        sudo usermod -aG docker `id -u -n`
        sudo mkdir -p /etc/docker
        echo '{"experimental": true}' | sudo tee /etc/docker/daemon.json
        sudo service docker status || sudo service docker start
        sudo docker system prune --all --force
    '''
}
