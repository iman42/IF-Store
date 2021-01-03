from glob import glob


class TestDockerfiles:
    def get_service_directories(self):
        return glob("../services/*")

    def dockerfile_exists(self, dir, type):
        return len(glob(dir + '/Dockerfile.' + type)) == 1

    def test_all_services_have_prod_dockerfile(self):
        for dir in self.get_service_directories():
            assert self.dockerfile_exists(dir, 'prod'), "not found for: " + dir

    def test_all_services_have_dev_dockerfile(self):
        for dir in self.get_service_directories():
            assert self.dockerfile_exists(dir, 'dev'), "not found for: " + dir

    def test_all_services_have_test_dockerfile(self):
        for dir in self.get_service_directories():
            assert self.dockerfile_exists(dir, 'test'), "not found for: " + dir


class TestDockerComposeFiles:
    def get_service_names(self):
        return (dir[12:] for dir in glob("../services/*"))

    def compose_file_exists(self, service, type):
        return len(glob('../docker-compose/docker-compose.services.'+service+'.'+type+'.yml')) ==1

    def test_all_services_have_prod_compose_file(self):
        for service in self.get_service_names():
            assert self.compose_file_exists(service, 'prod'), "not found for: " + service

    def test_all_services_have_dev_compose_file(self):
        for service in self.get_service_names():
            assert self.compose_file_exists(service, 'dev'), "not found for: " + service

    def test_all_services_have_test_compose_file(self):
        for service in self.get_service_names():
            assert self.compose_file_exists(service, 'test'), "not found for: " + service
